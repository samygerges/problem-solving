package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Twitter
{
	private final Map<Integer, Set<Integer>> users;
	private final ArrayDeque<int[]> tweets;

	/**
	 * Initialize your data structure here.
	 */
	public Twitter()
	{
		users = new HashMap<>();
		tweets = new ArrayDeque<>();
	}

	/**
	 * Compose a new tweet.
	 */
	public void postTweet(int userId, int tweetId)
	{
		users.putIfAbsent(userId, new HashSet<>());
		tweets.push(new int[] { userId, tweetId });
	}

	/**
	 * Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by
	 * the user herself. Tweets must be ordered from most recent to least recent.
	 */
	public List<Integer> getNewsFeed(int userId)
	{
		if (!users.containsKey(userId))
		{
			return new ArrayList<>();
		}
		List<Integer> userTweets = new ArrayList<>();
		for (int[] i : tweets)
		{
			if (users.get(userId).contains(i[0]) || userId == i[0])
			{
				userTweets.add(i[1]);
			}
			if (userTweets.size() == 10)
			{
				break;
			}
		}
		return userTweets;
	}

	/**
	 * Follower follows a followee. If the operation is invalid, it should be a no-op.
	 */
	public void follow(int followerId, int followeeId)
	{
		users.putIfAbsent(followerId, new HashSet<>());
		users.get(followerId).add(followeeId);
	}

	/**
	 * Follower unfollows a followee. If the operation is invalid, it should be a no-op.
	 */
	public void unfollow(int followerId, int followeeId)
	{
		if (users.containsKey(followerId))
		{
			users.get(followerId).remove(followeeId);
		}
	}
}

/**
 * Your Twitter object will be instantiated and called as such: Twitter obj = new Twitter(); obj.postTweet(userId,tweetId); List<Integer> param_2 =
 * obj.getNewsFeed(userId); obj.follow(followerId,followeeId); obj.unfollow(followerId,followeeId);
 */
