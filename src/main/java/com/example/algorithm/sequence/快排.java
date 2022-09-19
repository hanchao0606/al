package com.example.algorithm.sequence;


import java.util.Arrays;
import java.util.Collections;
/*
*quickSort快排3.0版本，
*时间复杂度：O(nlong(n))
* 空间复杂度：O(1)
*非稳定排序
*原地排序
*/
public class 快排 {
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
        return quickSort(nums, 0, nums.length - 1);
    }

    public static int[] sort(int[] nums, int l, int r) {
        if (l >= r)
            return nums;
        if (r - l == 1) {
            if (nums[l] > nums[r]) utill.swap(nums, l, r);
            return nums;
        }
        int p = nums[r];
        int pr = r - 1;
        int pl = l;
        while (pr > pl) {
            if (nums[pr] >= p) {
                pr--;
                continue;
            }
            while (pr > pl) {
                if (nums[pl] <= p) {
                    pl++;
                } else {
                    utill.swap(nums, pl, pr);
                    pl++;
                }
            }
        }
        utill.swap(nums, pr, r);
        if (!(r - l <= 3)) {
            sort(nums, l, pr - 1);
            sort(nums, pr + 1, r);
        }
        return nums;
    }

    public static int[] quickSort(int[] arr,int l,int r) {
        if (l<r){
            utill.swap(arr,l+(int)(Math.random()*(r-l+1)),r);//随机取一个值与最后一个交换
            int[] p = partition(arr,l,r);
            quickSort(arr,l,p[0]-1);
            quickSort(arr,p[1]+1,r);

        }
        return arr;

    }

    /**
     * 这是一个处理arr[1..r]的函数
     * 默认以arrt[r]做划分，arr[r] -> p  <p ==p  >p
     * 返回等于区域(左边界，右边界)，返回长度为二的数组
     */
    public static int[] partition (int[] arr,int l,int r){
        int less = l-1;
        int more = r;
        while (l<more){
            if (arr[l]<arr[r]){
                utill.swap(arr, ++less, l++);
            }else if (arr[l]>arr[r]){
                utill.swap(arr,--more,l);
            }else {
                l++;
            }
        }

        utill.swap(arr,more,r);
        return new int[]{ less+1,more };
    }
}
