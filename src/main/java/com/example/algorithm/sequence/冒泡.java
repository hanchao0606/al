package com.example.algorithm.sequence;

import java.util.Arrays;

/**
 * 时间复杂度：O(n²)
 * 空间复杂度：O(1)
 * 稳定排序
 * 原地排序
 */
public class 冒泡 {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 8, 8, 65555, 5, 4, 3, 2,};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if (nums[j - 1] > nums[j]) {
                    utill.swap(nums, j - 1, j);
                }
            }
        }
        return nums;
    }
}
