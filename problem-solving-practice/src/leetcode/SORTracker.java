package leetcode;

import java.util.TreeSet;

public class SORTracker {
    private final TreeSet<Location> locations;
    private Location last;

    public SORTracker() {
        locations = new TreeSet<>();
        last = new Location("", Integer.MAX_VALUE);
    }

    public void add(String name, int score) {
        Location location = new Location(name, score);
        locations.add(location);
        if (location.compareTo(last) < 0) {
            last = locations.lower(last);
        }
    }

    public String get() {
        last = locations.higher(last);
        return last.name;
    }

    class Location implements Comparable<Location> {
        String name;
        int score;

        public Location(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Location o) {
            if (score == o.score) {
                return name.compareTo(o.name);
            }
            return o.score - score;
        }
    }
}
