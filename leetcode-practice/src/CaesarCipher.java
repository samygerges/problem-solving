
public class CaesarCipher
{
    public static void main(String[] args)
    {
        System.out.println(caesarCipher("There’s-a-starman-waiting-in-the-sky", 3));
    }


    static String caesarCipher(String s, int k)
    {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
        {
            if (c >= 'A' && c <= 'Z')
            {
                sb.append((char) (((c - 65 + k) % 26) + 65));
            }
            else if (c >= 'a' && c <= 'z')
            {
                sb.append((char) (((c - 97 + k) % 26) + 97));
            }
            else
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
