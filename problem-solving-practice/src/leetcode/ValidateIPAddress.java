package leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddress
{
	private static final Pattern HEXADECIMAL_PATTERN = Pattern.compile("\\p{XDigit}+");

	public static void main(String[] args)
	{
		ValidateIPAddress s = new ValidateIPAddress();
		System.out.println(s.validIPAddress("192.0.0.1"));
	}

	public String validIPAddress(String IP)
	{
		String res = "Neither";
		if (IP.indexOf('.') != -1)
		{
			String[] parts = IP.split("\\.");
			if (parts.length == 4 && !IP.endsWith("."))
			{
				for (int i = 0; i < 4; i++)
				{
					try
					{
						int part = Integer.parseInt(parts[i]);
						if (part < 0 || part > 255 || (part == 0 && parts[i].length() > 1) || (part != 0 && parts[i].indexOf('0') == 0))
						{
							return res;
						}
					}
					catch (NumberFormatException e)
					{
						return res;
					}
				}
				res = "IPv4";
			}
		}
		else
		{
			String[] parts = IP.split(":");
			if (parts.length == 8 && !IP.endsWith(":"))
			{
				for (int i = 0; i < 8; i++)
				{
					if (parts[i].length() > 4 || !isHexadecimal(parts[i]))
					{
						return res;
					}
				}
				res = "IPv6";
			}
		}
		return res;
	}

	private boolean isHexadecimal(String input)
	{
		final Matcher matcher = HEXADECIMAL_PATTERN.matcher(input);
		return matcher.matches();
	}
}
