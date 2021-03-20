package leetcode;

import java.util.HashMap;
import java.util.Map;

import javafx.util.Pair;

public class UndergroundSystem
{
	private Map<Integer, Integer> checkin;
	private Map<Integer, String> checkinStation;
	private Map<Pair<String, String>, Long> total;
	private Map<Pair<String, String>, Integer> count;

	public UndergroundSystem()
	{
		checkin = new HashMap<>();
		total = new HashMap<>();
		count = new HashMap<>();
		checkinStation = new HashMap<>();

	}

	public void checkIn(int id, String stationName, int t)
	{
		checkin.put(id, t);
		checkinStation.put(id, stationName);
	}

	public void checkOut(int id, String stationName, int t)
	{
		Pair<String, String> key = new Pair<>(checkinStation.get(id), stationName);
		count.putIfAbsent(key, 0);
		count.put(key, count.get(key) + 1);
		total.putIfAbsent(key, 0L);
		total.put(key, total.get(key) + (t - checkin.get(id)));
	}

	public double getAverageTime(String startStation, String endStation)
	{
		Pair<String, String> key = new Pair<>(startStation, endStation);
		return (total.get(key) * 1.0) / (count.get(key) * 1.0);
	}
}
