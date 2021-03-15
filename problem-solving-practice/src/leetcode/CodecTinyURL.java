package leetcode;

import java.util.HashMap;
import java.util.Map;

public class CodecTinyURL
{
	private Map<String, String> codeToUrl = new HashMap<>();
	private Map<String, String> urlToCode = new HashMap<>();
	private int count = 0;

	// Encodes a URL to a shortened URL.
	public String encode(String longUrl)
	{
		if (!urlToCode.containsKey(longUrl))
		{
			count++;
			codeToUrl.put("http://tinyurl.com/" + count, longUrl);
			urlToCode.put(longUrl, "http://tinyurl.com/" + count);
		}

		return urlToCode.get(longUrl);
	}

	// Decodes a shortened URL to its original URL.
	public String decode(String shortUrl)
	{
		if(codeToUrl.containsKey(shortUrl)) {
			return codeToUrl.get(shortUrl);
		}
		return null;
	}
}
