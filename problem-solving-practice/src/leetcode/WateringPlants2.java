package leetcode;

public class WateringPlants2 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length - 1;
        int canA = capacityA;
        int canB = capacityB;
        int refills = 0;
        while (i <= j) {
            if (i == j) {
                if (plants[i] > canA && plants[i] > canB) {
                    refills++;
                }
                break;
            }
            if (plants[i] > canA) {
                refills++;
                canA = capacityA;
            }
            if (plants[j] > canB) {
                refills++;
                canB = capacityB;
            }

            canA -= plants[i];
            canB -= plants[j];
            i++;
            j--;
        }
        return refills;
    }
}
