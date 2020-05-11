import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EllysThreePrimes {

    private boolean prime[] = new boolean[100000];

    public int[] getPrimes(int[] sums) {
        List<Integer> primes = sieveOfEratosthenes(99999);
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i + 1; j < primes.size(); j++) {
                int x = primes.get(i);
                int y = primes.get(j);
                int num = 0;
                int index = 0;
                int mod = 1;
                boolean check = true;
                while (x > 0) {
                    int sum = x % 10 + y % 10;
                    if (sums[index] - sum > 9 || sums[index] - sum < 0) {
                        check = false;
                        break;
                    }
                    num += (sums[index] - sum) * mod;
                    mod *= 10;
                    x /= 10;
                    y /= 10;
                    index++;
                }
                if (check && num > 9999 && prime[num] && num != primes.get(i) && num != primes.get(j)) {
                    System.out.println(primes.get(i) + " " + primes.get(j) + " " + num);
                    return new int[]{primes.get(i), primes.get(j), num};
                }
            }
        }
        return new int[]{};
    }


    public List<Integer> sieveOfEratosthenes(int n) {
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * 2; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNumbers = new ArrayList<>();
        for (int i = 10000; i <= n; i++) {
            if (prime[i]) {
                primeNumbers.add(i);
            }
        }
        return primeNumbers;
    }
}
