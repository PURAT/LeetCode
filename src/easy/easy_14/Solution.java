package easy.easy_14;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 *
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            prefix = getPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                return "";
            }
        }
        return prefix;
    }

    private String getPrefix(String s1, String s2) {
        char[] arrayFirst = s1.toCharArray();
        char[] arraySecond = s2.toCharArray();
        int n = Math.min(arrayFirst.length, arraySecond.length);
        for (int i = 0; i < n; i++) {
            if (arrayFirst[i] != arraySecond[i]) {
                return s1.substring(0, i);
            }
        }
        return s1.substring(0, n);
    }
}
