
public class BackspaceStringCompare
{
    public static void main(String[] args)
    {
        BackspaceStringCompare b = new BackspaceStringCompare();
        System.out.println(b.backspaceCompare("a#c", "b"));
    }


    public boolean backspaceCompare(String S, String T)
    {
        return getString(S).equals(getString(T));
    }


    private String getString(String S)
    {
        for (int i = 0; i < S.length(); i++)
        {
            if (S.charAt(i) == '#')
            {
                int end = i - 1 >= 0 ? i - 1 : 0;
                S = S.substring(0, end) + S.substring(i + 1);
                i = end - 1;
            }
        }
        return S;
    }
}
