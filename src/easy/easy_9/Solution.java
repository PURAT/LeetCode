package easy.easy_9;

/**
 * 9. Palindrome Number
 *
 * Given an integer x, return true if x is palindrome integer.
 * An integer is a palindrome when it reads the same backward as forward.
 *
 * For example, 121 is a palindrome while 123 is not.
 *
 *
 * Example 1:
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 *
 * Example 2:
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:
 * Input: x = 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int count = 0;
        int number = x;
        while (number != 0) { // get number of digits
            number /= 10;
            count++;
        }

        while (count > 1) {
            int firstDigit = (int) (x / Math.pow(10, --count));
            int lastDigit = x % 10;

            if (firstDigit != lastDigit) {
                return false;
            }
            x = x / 10; // remove last digit
            x = (int) (x % Math.pow(10, --count)); // remove first digit
        }

        return true;
    }
}
