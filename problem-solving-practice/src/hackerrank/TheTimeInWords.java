package hackerrank;

public class TheTimeInWords
{
    public static void main(String[] args)
    {
        System.out.println(timeInWords(5, 15));
    }


    static String timeInWords(int h, int m)
    {
        String[] nums =
            new String[] {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "quarter", "sixteen", "seventeen",
                "eighteen", "nineteen", "twenty", "twenty one", "twenty two", "twenty three", "twenty four", "twenty five", "twenty six", "twenty seven", "twenty eight",
                "twenty nine", "half"};
        StringBuilder sb = new StringBuilder();

        if (m == 0)
        {
            sb.append(nums[h]).append(" ").append("o' clock");
        }
        else if (m <= 30)
        {
            if (m == 1)
            {
                sb.append(nums[m]).append(" minute past ").append(nums[h]);
            }
            else if (m != 15 && m != 30)
            {
                sb.append(nums[m]).append(" minutes past ").append(nums[h]);
            }
            else
            {
                sb.append(nums[m]).append(" past ").append(nums[h]);
            }
        }
        else
        {
            if (m != 45)
            {
                sb.append(nums[60 - m]).append(" minutes to ").append(nums[h + 1]);
            }
            else
            {
                sb.append(nums[60 - m]).append(" to ").append(nums[h + 1]);
            }
        }

        return sb.toString();
    }
}
