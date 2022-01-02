package leetcode;

import java.util.Arrays;

public class AsteroidsDestroyed {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long sum = mass;
        for (int i : asteroids) {
            if (i > sum) {
                return false;
            }
            sum += i;
        }
        return true;
    }
}
