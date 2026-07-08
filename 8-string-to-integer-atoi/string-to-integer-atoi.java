import java.util.*;

class Solution {

    static final int INT_MAX = Integer.MAX_VALUE;
    static final int INT_MIN = Integer.MIN_VALUE;

    static int helper(String s, int i, long num, int sign) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            if (sign == 1)
                return (int) num;
            else
                return (int) (-num);
        }

        num = num * 10 + (s.charAt(i) - '0');

        // Overflow check
        if (sign == 1 && num > INT_MAX)
            return INT_MAX;

        if (sign == -1 && -num < INT_MIN)
            return INT_MIN;

        return helper(s, i + 1, num, sign);
    }

    public int myAtoi(String s) {

        int i = 0;

        while (i < s.length() && s.charAt(i) == ' ')
            i++;

        int sign = 1;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        return helper(s, i, 0, sign);
    }
}