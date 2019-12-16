package com.dyt.swm.godway.test.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author weiming.sun
 * @version 1.0
 * @date 2019/7/23 15:11
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        try {
            int[] ints = twoSum(nums,4);
            System.out.println(Arrays.toString(ints));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static int[] twoSum(int[] nums, int target) throws IllegalAccessException {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])){
                return new int[]{i,map.get(target - nums[i])};
            }
            map.put(nums[i],i);
        }
        throw new IllegalAccessException("NO ANSWMER");
    }

}
