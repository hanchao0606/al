package com.example.algorithm.sequence;

import java.util.Arrays;

/**
*时间复杂度：O(n²)
* 空间复杂度：O(1)
*非稳定排序
*原地排序
 */
public class 选择 {
    public static void main(String[] args) {
        int[] nums = new int[]{8, 8, 8, 65555, 5, 4, 3, 2,};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minNum = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    //*********用^(异或)交换数组；注意：交换的两个数不是同一内存地址****************
                    utill.swap(nums, i, j);
                    //*********用位移交换数组；注意：交换的两个数不是同一内存地址****************
                }

            }
        }

    }
}
