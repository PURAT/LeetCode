package medium.medium_2;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int[] number1 = Arrays.stream(getNumber(l1).split("")).mapToInt(Integer::parseInt).toArray();
        int[] number2 = Arrays.stream(getNumber(l2).split("")).mapToInt(Integer::parseInt).toArray();
        int length = Math.max(number1.length, number2.length);
        int[] sum = new int[length + 1];

        for (int i = 0; i < length; i++) {
            if (i >= number1.length) {
                sum[i] = number2[i] + sum[i];
            }
            else if (i >= number2.length) {
                sum[i] = number1[i] + sum[i];
            }
            else {
                sum[i] = number2[i] + number1[i] + sum[i];
            }

            if ((sum[i]) >= 10) {
                sum[i+1] = 1;
                sum[i] = sum[i] % 10;
            }
        }

        if (sum[length] == 0) {
            return toListNode(sum, 1);
        }

        return toListNode(sum, 0);
    }

    private String getNumber(ListNode listNode) {
        return listNode.next == null ? listNode.val + "" : listNode.val + getNumber(listNode.next);
    }

    public ListNode toListNode(int[] arr, int offset) {
        ListNode rootNode = new ListNode(arr[0], null);
        ListNode node = rootNode;

        for (int i = 1; i < arr.length - offset; i++) {
            node.next = new ListNode(arr[i], null);
            node = node.next;
        }
        return rootNode;
    }

    // to display on the screen
    public String toScreen(ListNode node) {
        return "[" + node.toString() + "]";
    }
}
