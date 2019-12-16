package com.dyt.swm.godway.test.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/7/23 17:23
 */
public class TwoSum2 {

    public class ListNode { int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,99,78};
        int rob = rob(nums);
        System.out.println(rob);

    }

    public static Integer getLength(String s){
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= len; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[len];
    }


    /**
     *
     *      int len = nums.length;
     *         if(len == 0)
     *             return 0;
     *         int[] dp = new int[len + 1];
     *         dp[0] = 0;
     *         dp[1] = nums[0];
     *         for(int i = 2; i <= len; i++) {
     *             dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
     *         }
     *         return dp[len];
     *
     */


    /**
     *          优化滑动窗口
     *
     *          int n = s.length(), ans = 0;
     *         Map<Character, Integer> map = new HashMap<>();
     *         for (int end = 0, start = 0; end < n; end++) {
     *             char alpha = s.charAt(end);
     *             if (map.containsKey(alpha)) {
     *                 start = Math.max(map.get(alpha), start);
     *             }
     *             ans = Math.max(ans, end - start + 1);
     *             map.put(s.charAt(end), end + 1);
     *         }
     *         return ans;
     */



    /**
     *      初始版滑动窗口
     *
     *      int n = s.length();
     *     Set<Character> set = new HashSet<>();
     *     int ans = 0, i = 0, j = 0;
     *         while (i < n && j < n) {
     *         // try to extend the range [i, j]
     *         if (!set.contains(s.charAt(j))){
     *             set.add(s.charAt(j++));
     *             ans = Math.max(ans, j - i);
     *         }
     *         else {
     *             set.remove(s.charAt(i++));
     *         }
     *     }
     *         return ans;
      */


}
