package leetcode;

public class WateringPlants {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int can = capacity;
        for (int i = 0; i < plants.length; i++) {
            steps++;
            can -= plants[i];
            if (i + 1 < plants.length && plants[i + 1] > can) {
                steps += (i + 1) * 2;
                can = capacity;
            }
        }

        return steps;
    }
}
