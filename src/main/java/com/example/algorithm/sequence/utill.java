package com.example.algorithm.sequence;

public class utill {
    public static void swap(int[] nums,int i,int j) {
        if (i == j)return;
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }
}
