package leetcode;

public class AddStrings {
    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            return addStrings(num2, num1);
        }

        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuilder result = new StringBuilder();

        while (i >= 0) {
            int x = num1.charAt(i) - 48;
            int y = j >= 0 ? num2.charAt(j) - 48 : carry;
            if (j < 0) {
                carry = 0;
            }
            if (carry + x + y <= 9) {
                result.append(carry + x + y);
                carry = 0;
            } else {
                int diff = (carry + x + y) - 10;
                result.append(diff);
                carry = 1;
            }
            i--;
            j--;
        }
        if (carry == 1) {
            result.append(carry);
        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new AddStrings().addStrings("237", "284"));
    }
}
