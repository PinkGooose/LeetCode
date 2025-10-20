package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i <= nums.length - 2; i++) {
            for (int j = i+1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    answer[0] = nums[i];
                    answer[1] = nums[j];
                }
            }
        }
        return answer;
    }

    public int[] twoSumHashTable(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < n; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement) && numMap.get(complement) != i) {
                return new int[]{i, numMap.get(complement)};
            }
        }

        return new int[]{};
    }
}

