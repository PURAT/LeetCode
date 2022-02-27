package easy.easy_136;

import java.util.Arrays;
import java.util.Collection;

/**
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 *
 * Example 1:
 * Input: nums = [2,2,1]
 * Output: 1
 *
 * Example 2:
 * Input: nums = [4,1,2,1,2]
 * Output: 4
 *
 * Example 3:
 * Input: nums = [1]
 * Output: 1
 */

public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int step = 1;
        while (step < nums.length && nums[step - 1] == nums[step]) {
            step += 2;
        }
        return nums[step - 1];
    }
}
