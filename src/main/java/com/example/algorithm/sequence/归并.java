package com.example.algorithm.sequence;

import java.util.Arrays;
/*
 *时间复杂度：O(nlong(n)) 由master公式得出
 * 空间复杂度：O(n)
 *稳定排序
 *非原地排序
 */
public class 归并 {
    public static void main(String[] args) {
        int[] nums = new int[101];
        for (int i = 0; i < 101; i++) {
            nums[i] = (int) (Math.random()*101);
        }
        System.out.println(Arrays.toString(nums));
        nums = sort(nums);
        int[] nums2 = 冒泡.sort(nums);
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums).equals(Arrays.toString(nums2)));
    }

    public static int[] sort(int[] nums) {
        return swap(nums, 0, nums.length-1);
    }

    public static int[] swap(int[] nums, int l, int r) {
        if (l == r) {
            return new int[]{nums[r]};
        }
        int z = l + ((r - l) >> 1);
        int[] maxL = swap(nums, l, z);
        int[] maxR = swap(nums, z + 1, r);
        int pl = 0;
        int pr = 0;
        int ph = 0;
        int[] help = new int[maxL.length + maxR.length];
        while (pl < maxL.length && pr < maxR.length) {
            help[ph++] = maxL[pl] > maxR[pr] ? maxR[pr++] : maxL[pl++];
        }
        while (pl < maxL.length) {
            help[ph++] = maxL[pl++];
        }
        while (pr != maxR.length) {
            help[ph++] = maxR[pr++];
        }

        return help;
    }
}
