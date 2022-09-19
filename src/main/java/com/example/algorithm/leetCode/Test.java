package com.example.algorithm.leetCode;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        ListNode res = mergeKLists(getR());
        System.out.println("args = " + Arrays.deepToString(args));
    }
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode resHead = null;
        ListNode end = null;
        while (true) {
            Arrays.sort(lists, (o2, o1) -> {
                if(o1 == null) {
                    if(o2 == null) {
                        return 0;
                    }
                    return -1;
                }
                if(o2 == null) {
                    return 1;
                }
                return o2.val - o1.val;
            });

            if (null == lists[0]) {
                return resHead;
            }
            if (null == resHead) {
                resHead = lists[0];
                lists[0]=lists[0].next;
                end = resHead ;
                resHead.next=null;
            } else {
                end.next = lists[0];
                end = lists[0];
                lists[0] = lists[0].next;
                end.next=null;
            }

        }

    }
    public static ListNode[] getR(){
       int[] aa ={7,49,73,58,30,72,44,78,23,9,40,65,92,42,87,3,27,29,40,12,3,69,9,57,60,33,99,78,16,35,97,26,12,67,10,33,79,49,79,21,67,72,93,36,85,45,28,91,94,57,1,53,8,44,68,90,24,96,30,3,22,66,49,24,1,53,77,8,28,33,98,81,35,13,65,14,63,36,25,69,15,94,29,1,17,95,5,4,51,98,88,23,5,82,52,66,16,37,38,44,1,97,71,28,37,58,77,97,94,4,9,31,45,75,35,98,42,99,68,12,60,57,94,8,95,68,13,30,6,62,42,65,82,52,67,21,95,12,71,1,90,31,38,57,16,90,40,79,35,6,72,98,95,19,54,23,89,60,5,26,23,6,13,70,38,94,20,44,66,34,26,94,63,38,44,90,50,59,23,47,85,17,72,39,47,85,96,85,23,20,44,68,35,15,25,34,42,11,79,52,44,95,18,96,92,15,91,33,69,97,53,47,25,10,62,11,8,77,61,25,35,68,95,76,67,39,74,31,56,1,72,60,94,84,55,89,7,15,93,69,80,55,55,6,63,2,76,8,49,31,44,38,8,97,51,49,3,31,31,14,19,75,9,80,29,23,54,60,37,45,17,25,0,56,64,97,48,4,50,50,76,12,54,97,4,81,48,65,78,99,9,29,53,83,47,7,73,22,5,76,53,24,30,66,0,44,70,85,16,98,55,33,57,76,78,66,57,11,78,14,19,37,33,91,20,62,33,97,31,88,89,73,77,4,58,0,54,60,15,47,80,30,55,46,7,38,0,26,35,57,13,14,93,60,54,18,57,85,29,15,63,2,17,43,19,67,47,69,95,3,73,3,48,85,58,59,6,30,24,32,73,3,97,20,50,31,80,3,0,20,33,58,3,76,50,34,80,79,32,74,49,42,49,71,10,79,83,70,40,23,50,71,29,18,46,99,30,21,76,24,44,58,96,71,64,60,98,51,40,3,51,1,5,80,18,74,49,13,20,25,12,83,88,17,8,50,24,95,57,11,90,66,10,93,53,65,60,42,3,52,7,41,10,0,99,27,71,87,14,25,41,17,48,42,15,74,45,73,20,11,39,54,5,29,53,89,66,56,4,60,98,92,20,16,80,67,52,39,98,1,11,16,91,71,28,71,61,45,20,40,58,53,27,50,11,63,94,33,27,27,95,31,42,16,6,15,24,1,97,61,3,24,8,36,81,15,10,16,5,73,81,20,91,69,65,27,36,28,25,84,67,49,76,46,76,66,67,20,84,91,10,58,11,44,18,18,34,25,67,89,18,14,25,18,28,29,34,27,40,54,40,96,35,83,48,65,11,52,64,76,37,75,45,10,15,92,10,47,37,99,47,15,93,79,29,64,79,1,25,89,58,33,0,89,70,17,46,38,43,38,36,21,19,96,47,88,59,87,35,35,12,84,89,84,34,67,19,15,45,76,61,25,19,31,3,98,98,39,4,3,79,65,91,7,24,65,21,54,6,50,3,32,32,41,54,77,17,0,89,65,47,22,79,17,16,48,62,29,39,8,3,57,61,52,66,21,57,96,55,30,94,55,21,12,93,27,32,44,91,98,52,56,70,3,39,14,99,66,35,21,43,52,86,19,50,10,23,69,5,43,11,31,92,16,99,71,39,70,36,91,57,33,28,77,10,83,76,89,91,34,11,4,26,91,90,22,64,90,84,13,41,27,79,84,37,70,61,81,65,2,32,32,54,59,47,77,62,10,19,50,77,41,36,20,99,12,59,56,90,52,48,14,44,18,50,1,95,21,31,1,45,61,57,10,28,5,73,37,69,96,3,21,75,18,0,89,62,54,63,43,89,50,35,15,64,94,63,58,52,92,16,14,20,60,50,68,41,47,96,87,1,34,28,71,48,75,53,71,29,93,19,71,20,64,79,30,10,80,13,42,38,82,44,28,93,75,80,0,96,47,70,87,43,33,52,61,24,0,80,78,57,23,98,14,45,62,9,10,49,18,90,55,43,55,85,34,75,21,51,26,51,59,83,14,37,79,98,0,37,85,78,84,42,15,60,67,40,7,66,28,62,63,69,90,23,78,13,61,10,40,78,0,94,7,56,51,86,31,44,39,76,84,52,8,14,54,19,28,71,70,63,47,24,43,54,8,81,52,88,63,59,19,79,56,61,87,53,99,88,44,80,66,83,74,36,9,67,34,39,84,51,49,66,67,10,89,27,73,81,95,36,74,35,31,72,28,98,70,87,97,89,46,90,11,12,63,12,81,51,30,21,13,28,50,0,59,54,92,94,30,32,59,77,79,32,72,83,81,53,22,21,56,18,91,0,96,20,4,99,29,44,75,70,16,99,80,18,88,52,28,0,62,40,49,85,83,15,59,78,59,61,82,48,54,40,81,70,28,51,44,69,95,69,10,72,23,25,19,50,31,43,46,69,70,94,10,92,64,24,61,19,20,62,61,25,34,49,90,22,60,93,28,22,81,66,68,23,22,39,17,93,64,78,56,71,41,55,36,89,28,20,2,12,16,47,46,51,72,11,23,36,5,7,33,66,53,12,25,40,53,57,33,95,39,51,58,94,60,38,29,75,98,92,33,62,76,36,46,73,64,84,92,19,42,28,59,62,45,16,27,72,48,0,70,98,92,45,28,0,43,92,63,83,72,1,9,21,86,13,69,31,57,19,86,56,16,54,54,14,15,37,66,97,77,60,12,91,31,74,63,77,24,84,33,50,27,99,29,9,44,64,51,12,79,34,7,83,0,59,10,53,91,21,25,53,29,96,53,61,58,91,63,20,68,87,26,72,19,41,4,51,92,45,70,74,62,76,17,26,13,44,71,79,35,29,88,48,78,17,23,38,8,29,26,68,6,99,55,29,76,88,96,19,64,37,16,18,91,83,98,20,48,61,51,18,77,46,61,78,28,63,35,6,8,68,79,19,23,77,92,53,78,53,95,71,75,4,62,32,19,31,35,68,68,10,34,70,78,65,45,79,75,27,87,63,37,66,34,83,75,84,55,56,99,64,93,86,33,24,47,94,30,67,65,10,82,5,14,52,41,85,91,6,60,60,12,3,30,85,0,85,67,84,88,0,86,0,95,99,2,28,83,17,36,2,89,78,25,89,22,95,5,19,91,21,74,14,62,6,83,26,19,1,30,44,75,58,62,31,36,20,8,24,47,8,11,97,0,14,96,99,45,33,62,39,54,21,86,36,10,62,73,93,35,88,71,38,21,91,13,60,57,92,43,75,68,13,15,36,91,47,69,32,34,28,43,79,6,54,7,37,3,21,47,34,49,16,59,38,50,83,86,96,85,24,22,63,81,12,51,2,95,36,54,8,80,31,30,95,14,12,36,37,9,85,19,81,10,8,9,39,67,19,66,99,20,15,77,22,42,80,81,85,30,25,36,94,45,2,33,80,56,34,17,81,81,58,5,92,60,51,1,42,44,35,55,72,43,22,13,41,81,79,18,60,29,55,82,64,32,13,95,28,4,55,11,81,10,4,51,16,61,64,5,22,13,43,36,18,94,88,43,39,2,43,70,19,12,17,32,82,97,59,73,90,19,10,11,15,78,42,45,70,62,8,83,99,9,13,50,51,65,2,17,53,99,16,84,69,42,3,15,29,57,82,64,52,54,26,27,55,59,52,86,22,29,86,49,79,98,90,3,86,43,27,85,98,87,17,31,76,61,63,14,83,32,22,11,91,71,42,33,53,30,80,4,15,87,10,81,58,86,33,40,59,36,62,38,54,26,26,12,95,21,77,41,58,54,20,97,27,51,62,32,37,4,57,5,7,43,58,39,43,97,81,65,57,5,17,12,24,84,59,99,16,40,51,46,22,93,15,49,61,49,31,96,23,96,44,50,38,31,59,35,65,1,87,37,48,20,24,94,75,3,89,86,45,43,57,32,61,78,4,2,31,20,86,30,43,67,48,44,17,49,25,73,63,16,80,48,79,57,14,5,89,7,5,27,14,15,8,97,49,95,29,26,66,98,85,62,18,53,79,3,83,23,59,21,74,34,75,2,36,79,15,50,13,50,92,48,83,81,47,8,6,78,6,67,14,10,70,58,17,46,4,56,63,37,98,34,56,8,12,13,80,24,4,13,73,62,79,77,69,47,31,53,33,39,20,94,97,24,71,58,20,48,18,1,17,92,13,80,56,40,94,68,70,63,49,34,25,71,91,50,17,10,54,25,1,94,92,34,70,46,87,21,65,89,71,65,60,10,75,9,94,23,34,74,14,94,23,75,77,57,27,22,74,72,39,39,83,17,30,90,6,96,12,95,38,16,21,84,27,78,60,72,87,35,81,26,94,30,95,58,19,12,43,12,6,28,93,26,26,26,33,81,96,92,61,9,77,24,22,40,52,15,80,92,51,52,73,77,17,26,65,61,39,49,7,19,30,76,25,81,27,59,97,93,25,29,22,48,53,79,68,27,24,31,77,6,0,72,1,30,98,77,49,94,27,52,59,77,70,51,24,84,20,15,19,77,95,95,64,0,18,17,23,17,54,68,87,75,13,22,57,16,82,42,62,8,40,5,70,6,1,19,20,62,17,35,52,94,35,10,31,63,51,47,51,10,49,47,34,48,23,88,71,32,59,56,45,2,23,89,19,94,86,7,92,0,46,1,65,44,56,74,17,75,95,66,64,91,91,40,56,59,97,97,9,63,22,85,99,19,20,92,48,53,76,76,33,97,93,3,8,74,66,3,30,81,86,25,69,25,58,85,99,21,14,60,56,72,53,53,75,81,55,62,48,45,52,70,31,0,63,47,19,70,1,59,82,79,96,29,1,56,30,81,20,62,51,45,70,54,57,93,15,8,61,66,73,78,86,30,52,26,79,10,32,51,72,1,87,79,8,37,36,2,78,23,88,74,9,96,23,62,23,46,79,55,74,22,31,57,71,79,94,27,56,36,16,47,13,84,57,60,57,0,36,13,33,75,10,62,66,6,8,7,73,37,96,55,24,66,8,33,61,57,71,76,14,14,89,35,59,38,94,60,27,43,42,55,21,11,80,12,9,90,83,45,38,34,38,64,81,40,50,18,75,98,74,87,42,88,20,82,5,34,20,46,3,20,50,75,62,42,70,38,42,15,35,77,34,67,74,80,90,96,6,81,43,72,55,38,75,20,75,86,97,5,37,95,83,95,76,83,82,27,51,99,5,51,77,6,90,95,96,61,31,25,6,79,70,24,57,22,53,73,80,3,83,34,82,57,63,41,37,29,87,86,51,94,22,30,30,54,6,19,17,83,39,13,92,39,44,68,83,29,65,5,87,40,87,97,79,68,63,0,99,47,1,88,5,20,44,72,76,30,19,69,88,29,52,32,58,7,81,62,16,9,45,48,85,8,13,67,5,14,54,35,70,63,79,58,39,59,45,23,48,44,77,37,91,42,98,77,4,82,56,75,33,10,92,70,70,53,53,28,28,73,82,71,0,5,55,21,84,34,47,28,88,85,8,58,74,23,61,72,24,35,89,56,44,98,47,95,67,83,76,43,36,37,46,62,57,42,96,3,81,81,94,88,4,55,87,83,17,65,93,56,38,51,87,90,80,32,26,29,7,14,17,25,38,26,45,57,25,7,79,51,41,59,81,65,25,94,93,64,63,29,1,72,40,53,29,32,80,59,74,40,76,89,4,18,68,86,66,62,74,98,21,27,15,27,41,9,58,35,65,61,61,32,72,19,94,3,54,31,16,4,83,74,13,11,44,8,59,5,72,92,72,15,29,13,43,80,9,5,84,49,11,9,83,48,85,7,60,80,89,63,33,66,85,0,85,42,74,91,63,93,3,98,63,61,91,77,89,97,29,12,69,60,31,65,11,13,96,50,4,23,88,22,20,16,65,77,72,12,80,76,0,41,18,75,19,43,63,81,58,82,67,52,51,61,95,17,29,27,91,86,60,56,92,1,39,11,84,70,13,70,8,85,20,57,45,97,79,99,2,83,67,19,69,37,29,99,18,18,5,15,37,15,29,24,15,66,72,96,60,78,79,71,24,45,80,77,58,54,15,8,21,8,45,52,95,11,10,60,82,10,82,10,1,60,35,20,84,6,5,8,77,24,49,93,44,16,24,81,61,85,38,3,7,22,13,95,51,83,98,57,0,56,89,1,99,10,74,95,28,91,47,81,93,20,68,15,76,24,53,64,87,95,19,93,6,5,31,78,49,30,9,87,32,74,84,70,53,11,88,64,38,88,7,62,58,16,75,77,92,77,29,90,60,51,27,21,39,40,64,77,36,5,11,84,55,75,59,39,49,99,72,74,90,66,42,22,21,60,34,47,93,17,1,65,48,74,32,88,65,58,2,10,19,10,37,92,36,48,8,50,33,19,37,32,94,93,10,11,5,58,7,53,74,64,7,2,14,69,39,14,87,95,48,67,13,67,60,53,70,83,56,68,26,0,22,37,99,71,96,17,41,58,35,88,71,73,7,20,92,93,52,89,13,28,3,98,17,50,88,46,43,65,88,11,66,43,38,4,67,57,22,46,31,3,20,27,64,51,5,29,42,16,88,50,85,2,73,45,97,15,52,88,86,28,17,22,23,26,96,61,79,84,42,90,97,28,11,43,44,52,25,38,72,87,57,15,27,61,82,77,44,28,13,35,1,39,23,23,64,91,58,59,43,48,27,52,33,8,41,21,99,69,30,81,76,13,7,54,98,69,15,80,47,27,75,88,86,64,47,6,38,27,2,31,79,57,46,27,40,38,41,42,2,65,69,11,8,2,43,73,80,36,2,64,70,1,87,40,8,55,5,87,14,1,65,99,59,57,90,43,82,82,3,39,84,61,4,32,27,84,24,56,14,7,48,8,4,87,35,32,36,57,25,64,54,28,33,23,30,44,70,32,4,85,79,64,55,26,79,10,20,90,1,24,49,67,2,10,4,63,60,64,28,27,1,0,82,44,85,69,23,55,68,78,27,69,74,21,37,57,20,89,12,42,83,2,41,52,67,87,88,7,33,32,81,3,32,27,50,85,70,19,23,65,74,17,18,93,0,34,91,57,19,45,93,12,79,69,18,30,98,49,57,90,68,8,26,72,52,17,93,11,41,31,7,68,63,1,22,37,58,78,46,94,63,83,10,84,73,87,32,69,7,62,84,48,35,30,98,94,26,50,34,15,68,91,99,71,69,1,96,10,73,92,11,28,0,12,79,39,69,51,14,64,84,11,44,91,27,41,99,97,95,6,91,11,38,82,53,18,23,3,80,8,73,37,80,99,93,49,43,18,46,75,75,81,76,30,35,28,48,97,62,61,47,37,14,95,30,7,56,25,43,66,15,50,42,75,23,65,12,29,80,73,57,56,23,53,6,52,76,62,38,11,66,94,9,82,96,9,96,44,35,65,58,3,3,4,46,55,50,75,27,63,52,11,84,87,16,77,51,90,83,20,99,90,42,11,36,62,60,69,14,78,66,57,99,50,19,98,43,68,76,1,46,88,20,81,49,11,47,44,76,96,78,56,36,62,39,39,79,87,66,0,6,91,56,98,46,70,33,1,90,84,58,27,94,86,97,89,35,27,68,0,64,40,88,10,83,23,31,23,56,14,12,69,52,62,81,35,35,71,24,70,66,93,28,26,33,99,3,26,88,41,89,19,81,15,23,98,52,68,61,89,1,83,93,20,13,42,26,50,56,32,6,92,64,2,6,90,19,2,34,75,92,32,94,69,43,47,27,95,64,93,66,94,84,58,21,66,70,42,92,54,29,45,47,72,80,96,97,46,40,6,0,43,81,14,75,17,2,92,11,68,75,37,98,32,37,66,86,92,4,60,59,15,95,85,81,63,68,64,78,25,4,15,26,86,40,23,8,50,59,20,97,79,18,17,57,30,21,51,71,28,22,99,52,56,49,76,4,48,87,33,14,57,59,10,76,0,16,70,72,55,42,86,14,86,29,83,87,87,31,59,85,99,19,71,69,3,53,96,41,98,48,37,26,21,28,94,63,27,47,98,31,90,90,30,23,17,29,7,83,39,74,33,46,89,31,71,55,36,79,46,84,76,74,84,85,87,45,49,0,86,8,13,12,27,50,42,85,71,49,54,68,60,96,59,73,98,85,48,19,67,4,33,29,90,94,66,31,11,69,58,99,57,45,23,55,75,20,76,75,85,68,92,67,24,44,86,90,13,25,38,43,3,12,11,96,72,63,96,27,65,3,19,43,71,0,49,29,38,97,65,16,43,79,47,48,77,48,80,60,38,92,61,17,76,88,42,45,4,79,69,75,65,53,15,40,69,27,1,56,10,85,93,6,93,72,15,99,5,46,53,37,49,22,20,54,22,46,59,96,28,52,16,57,76,99,93,3,36,63,35,15,19,21,93,52,44,15,76,23,80,9,37,23,85,42,41,57,2,98,43,62,85,34,92,23,79,83,94,86,52,93,77,9,54,67,68,98,50,52,54,32,8,1,90,41,44,94,87,74,31,37,82,96,81,72,82,33,56,36,30,15,70,11,33,46,45,20,97,26,12,14,33,1,77,83,35,45,66,70,69,47,84,81,32,41,81,1,47,23,15,61,61,32,26,40,62,64,59,77,35,55,23,26,59,23,65,39,46,67,21,83,51,73,43,86,99,17,61,93,55,14,94,16,73,7,1,80,58,4,91,44,81,63,98,92,90,20,54,29,40,81,60,55,82,79,65,95,15,50,88,89,25,57,86,82,45,14,93,42,81,12,96,66,66,90,61,89,59,35,19,36,92,23,81,2,5,27,18,5,63,92,38,49,33,8,36,31,96,28,9,44,17,36,36,9,39,90,14,4,68,56,84,17,75,65,12,10,59,88,48,33,32,34,6,50,10,7,75,20,8,21,7,99,57,61,7,90,10,0,36,78,38,93,15,15,72,47,43,51,39,95,26,14,85,19,80,98,56,9,89,45,65,76,51,41,73,15,44,46,3,83,40,33,53,86,52,12,68,82,87,68,62,4,96,12,64,9,45,16,9,61,78,61,31,12,11,56,60,99,97,42,6,23,44,7,84,87,80,57,78,40,9,62,66,21,36,7,26,37,36,6,52,30,67,0,36,16,15,46,99,77,12,80,36,24,10,87,54,35,23,31,73,77,57,94,16,65,71,12,76,25,7,9,75,50,92,6,63,88,29,0,36,3,15,31,75,97,8,96,9,16,77,75,24,57,19,92,44,57,15,72,54,25,67,37,48,96,70,36,13,42,41,78,3,81,62,19,8,11,76,82,67,23,68,20,51,20,49,62,24,91,65,71,29,69,73,83,27,68,88,11,30,24,57,39,59,60,79,24,77,86,1,65,32,47,62,91,79,91,0,87,31,23,18,35,10,24,19,57,92,64,76,5,36,31,66,92,26,20,77,4,85,7,5,12,6,71,18,94,81,69,33,71,81,86,62,0,19,41,79,9,85,79,82,80,56,19,94,86,59,22,63,83,30,28,50,99,65,97,39,83,13,53,92,24,53,13,95,11,20,69,43,68,67,51,10,15,64,91,49,40,87,23,44,38,21,67,52,52,12,56,62,51,84,0,16,27,17,20,8,10,61,90,63,90,58,4,32,42,73,10,11,57,53,14,72,0,7,21,38,60,81,34,37,82,41,10,33,37,4,9,91,49,60,71,36,59,49,75,25,87,28,80,7,55,72,7,23,97,62,12,14,38,96,19,47,63,74,58,69,32,12,67,79,22,66,48,54,63,84,47,79,0,37,23,20,11,55,38,45,19,9,77,43,8,92,76,49,2,52,13,71,74,71,4,1,86,91,0,22,15,64,57,71,13,82,77,85,50,58,70,54,9,5,10,74,91,58,66,77,83,71,15,33,91,58,21,44,83,18,73,85,40,84,27,61,28,6,15,73,14,31,54,12,32,12,39,79,12,57,18,1,47,35,87,25,93,59,33,53,7,7,52,93,90,69,33,35,23,76,61,18,15,49,79,32,2,88,35,56,5,22,34,46,4,75,93,20,48,98,87,46,97,67,20,39,73,99,16,5,56,64,34,0,17,61,56,0,29,99,4,88,27,60,96,34,82,53,48,1,4,40,36,50,22,84,81,19,72,1,90,43,69,74,79,8,85,85,22,11,78,87,2,75,21,82,16,93,70,60,81,75,12,63,51,28,48,87,57,89,90,5,89,5,89,85,67,36,5,23,59,36,88,34,51,32,66,88,35,15,69,97,87,86,90,90,69,52,96,55,1,0,90,34,94,0,74,88,86,25,53,91,68,75,20,81,99,85,95,19,51,95,39,95,69,45,98,94,79,47,43,96,26,63,45,26,71,19,85,19,80,79,34,26,47,58,24,96,73,98,91,53,39,0,30,6,60,28,38,0,10,28,58,87,94,52,80,56,98,15,55,22,43,59,49,28,0,70,65,92,89,66,92,52,57,24,90,87,5,31,89,56,38,90,50,67,96,91,44,16,33,58,62,66,19,32,2,18,77,81,93,89,47,71,49,47,41,65,79,14,99,60,66,27,71,94,17,41,95,15,97,74,51,74,46,17,79,66,79,1,97,52,37,50,70,31,14,68,97,91,78,13,19,29,12,3,36,98,89,86,9,43,95,99,4,75,33,4,61,63,61,22,51,61,42,62,88,85,3,74,18,56,96,78,11,37,36,89,60,20,77,98,18,97,80,38,35,62,3,40,92,76,74,26,34,64,47,43,92,76,63,68,90,16,96,53,60,57,77,58,65,94,38,30,13,27,11,51,46,48,82,26,71,8,78,73,5,15,42,22,90,18,84,50,44,69,10,97,2,53,60,42,91,56,57,36,89,26,58,57,1,40,12,67,48,13,23,32,75,36,71,97,54,41,21,37,72,81,46,36,32,45,91,24,69,41,81,18,83,77,93,68,8,90,20,47,6,15,41,39,35,33,94,16,35,70,76,96,63,40,91,91,51,89,80,85,17,17,23,2,29,8,50,67,86,32,39,88,15,29,92,0,4,12,7,39,77,7,85,76,14,60,22,35,9,97,93,86,76,13,63,42,1,77,71,92,84,95,11,93,79,77,39,19,49,40,75,55,33,34,65,82,48,21,7,67,3,44,30,78,50,51,95,66,95,65,58,84,14,56,10,48,43,55,62,57,44,62,86,57,85,95,57,99,77,36,30,84,47,71,96,6,93,53,83,55,38,80,5,15,33,34,47,89,94,83,3,0,19,5,14,74,64,95,38,93,20,5,35,49,14,8,29,33,83,36,40,82,36,6,78,4,46,4,7,24,83,44,19,51,6,88,19,92,17/*,92,52,80,20,81,22,96,1,93,38,53,74,97,69,59,61,55,14,19,7,27,58,66,1,73,1,83,12,76,88,85,69,9,66,99,64,0,95,2,24,18,11,56,34,0,73,84,94,23,69,67,71,45,76,35,97,41,76,54,88,3,95,37,45,58,89,4,47,14,83,61,13,25,54,60,76,71,79,70,99,21,92,88,89,37,79,12,97,27,15,96,23,46,59,62,68,68,61,38,68,11,82,31,95,99,23,26,97,9,67,16,90,29,69,78,9,1,89,66,40,49,18,14,75,41,63,20,64,76,9,93,34,45,20,80,54,3,78,43,88,78,15,84,95,83,7,9,33,85,96,37,13,87,60,25,45,16,74,51,68,66,30,53,4,41,63,39,90,37,70,40,51,85,71,26,22,63,24,6,91,51,5,4,61,8,51,97,48,64,26,8,24,54,88,45,91,18,22,19,68,82,89,48,82,43,74,7,26,95,46,15,4,30,4,50,14,84,13,24,93,17,62,13,59,63,95,64,17,30,62,46,13,90,19,59,34,73,98,7,82,81,72,58,87,62,84,46,42,53,84,69,87,62,49,16,41,52,37,84,87,43,0,13,49,36,53,61,97,82,76,28,83,9,68,46,75,56,80,98,54,61,69,83,78,86,17,94,61,81,31,82,89,81,16,44,8,17,48,95,59,28,81,91,81,77,8,58,56,12,61,96,12,38,51,50,69,37,10,26,91,37,20,96,21,3,89,29,79,44,48,94,88,3,33,29,69,33,73,14,84,21,70,55,57,82,14,28,48,14,91,97,4,47,17,74,14,36,86,20,75,79,74,16,53,36,52,72,62,3,64,98,39,18,7,60,11,52,22,2,76,46,20,42,95,1,64,82,91,92,98,85,96,62,41,6,72,76,73,3,96,31,54,50,69,57,51,62,92,64,99,58,78,78,7,67,21,85,69,56,50,78,10,5,39,57,40,17,83,85,34,40,20,95,81,53,19,71,28,92,28,6,86,26,63,76,61,56,62,53,39,67,60,82,0,30,20,34,69,40,12,59,67,23,25,34,19,67,45,10,20,30,36,33,46,70,60,59,43,71,21,97,10,1,43,85,53,53,81,63,21,20,11,10,67,9,64,65,97,6,67,8,9,61,57,35,45,53,12,40,83,34,65,31,75,35,4,83,15,0,86,64,31,59,35,79,52,19,58,29,69,90,92,32,43,65,93,14,72,56,71,45,27,98,61,15,78,12,31,71,10,12,32,79,23,79,69,28,41,45,9,91,43,53,46,86,47,26,6,12,4,58,3,41,10,57,48,91,56,94,37,13,13,32,66,54,54,66,90,72,19,69,94,31,25,9,68,6,14,62,67,38,38,92,19,43,26,34,6,50,26,60,69,91,15,71,66,41,39,84,12,25,61,40,19,6,40,96,41,59,10,72,13,67,42,14,96,42,27,93,78,44,64,8,91,16,97,73,80,88,90,12,61,53,41,71,30,33,58,39,16,3,73,73,11,69,7,23,81,35,9,39,5,63,26,52,47,88,84,86,69,99,11,34,13,40,96,78,52,42,84,1,37,40,25,43,43,56,74,34,62,58,29,22,6,92,64,63,1,75,85,40,23,88,14,95,59,99,95,10,81,33,46,49,36,91,68,81,39,80,78,58,63,7,40,75,68,60,90,35,55,53,94,44,68,46,61,26,26,29,89,84,25,10,77,14,68,50,31,93,38,4,28,72,1,65,79,26,93,62,58,32,16,41,16,90,89,45,32,51,29,33,73,95,95,73,81,48,50,15,49,22,87,65,40,67,73,65,23,36,8,52,17,14,33,39,34,60,86,67,21,49,81,79,70,10,0,7,64,81,29,34,79,14,22,23,38,5,12,52,26,79,33,94,97,72,71,31,91,52,42,12,60,94,76,39,86,84,82,7,68,2,17,34,24,76,87,77,91,32,70,24,57,96,82,96,96,31,9,27,22,56,98,66,51,37,0,62,60,1,55,28,20,65,1,53,54,57,72,26,8,0,95,96,77,51,1,84,43,64,83,63,79,60,53,39,27,65,40,60,85,2,10,63,32,10,27,84,3,22,14,87,46,76,72,86,56,58,16,4,19,74,28,94,38,22,66,62,76,84,71,79,60,96,56,73,55,24,57,63,73,43,35,43,61,35,58,82,34,81,61,73,22,94,83,31,17,19,46,96,62,75,89,43,43,83,20,17,64,20,55,38,86,55,20,0,50,95,17,41,28,85,15,37,12,28,29,52,33,71,86,78,34,30,52,65,48,39,75,23,9,83,5,42,58,26,25,57,15,38,44,2,91,61,27,21,0,88,16,51,93,47,9,5,71,24,47,91,96,66,18,59,18,29,2,25,61,42,4,80,58,44,99,14,24,75,37,39,8,83,51,84,54,99,95,79,4,23,90,18,54,18,61,13,40,38,42,11,10,36,42,73,81,40,25,80,9,77,23,75,10,65,25,65,13,12,69,75,7,83,46,47,26,64,74,28,16,6,22,11,22,81,69,40,13,32,91,40,90,13,59,46,16,7,51,58,20,9,20,56,0,68,39,95,40,36,69,24,89,45,17,5,40,98,97,73,46,67,85,88,98,80,74,13,22,37,83,28,14,63,58,42,84,40,45,87,19,12,47,99,50,8,76,6,76,93,92,75,23,53,50,87,25,38,23,63,64,58,48,85,63,20,24,30,0,93,93,68,4,69,3,43,49,79,38,10,43,60,46,43,54,35,29,90,1,66,78,33,87,87,94,91,97,30,59,31,83,26,0,27,47,50,27,48,22,37,75,85,79,75,63,6,50,1,47,46,14,28,73,34,80,91,3,74,61,12,65,58,49,79,22,7,81,49,49,57,11,94,34,31,48,33,22,60,22,13,8,81,46,31,95,97,87,24,27,92,17,76,67,11,97,55,2,18,68,23,48,24,51,68,92,68,63,44,48,27,78,43,80,43,58,16,14,33,96,74,42,35,81,31,45,0,91,20,7,72,53,33,29,2,81,32,94,65,38,97,48,54,40,11,18,90,9,84,63,50,40,23,67,48,19,98,17,57,97,29,95,63,34,54,44,4,70,5,14,36,9,31,70,33,97,64,69,39,28,90,42,63,17,10,17,7,24,4,36,77,57,10,87,84,19,51,10,57,14,75,20,21,55,95,54,18,70,62,86,52,91,67,71,88,23,63,22,91,68,32,93,6,74,69,41,60,21,94,67,18,36,24,19,84,34,45,99,75,86,85,2,21,78,65,19,29,68,18,59,17,26,24,95,94,16,69,74,28,20,54,54,68,21,79,30,59,61,65,34,94,29,22,18,27,80,45,55,2,75,65,36,94,98,93,77,76,42,44,33,69,46,8,81,92,8,5,56,69,86,27,30,92,95,61,16,86,77,32,72,56,44,88,88,34,37,57,11,9,33,76,70,10,91,51,21,31,30,10,23,75,88,27,43,0,19,17,51,79,3,81,48,96,10,44,3,4,87,44,35,83,81,73,61,46,88,31,34,44,91,2,62,57,81,3,65,69,19,99,62,76,96,48,8,78,9,40,27,67,39,39,94,75,96,2,40,42,16,87,28,29,71,84,93,83,88,12,6,1,60,5,8,11,93,64,27,5,26,93,3,20,25,15,51,14,46,72,34,44,9,93,75,83,71,59,15,91,93,95,74,95,12,52,56,46,45,66,78,25,67,78,66,60,41,12,31,1,90,33,75,98,95,17,64,6,35,90,69,32,42,66,71,89,32,76,19,8,53,16,67,25,66,84,27,33,10,94,65,73,46,79,41,93,86,99,63,93,2,4,59,47,8,50,40,4,7,48,84,12,94,33,93,2,53,99,10,84,73,7,98,54,90,27,18,69,15,76,35,22,4,89,5,74,45,81,87,56,63,93,54,49,45,34,69,67,87,67,9,62,97,8,2,17,54,54,83,44,61,25,3,5,27,43,69,68,44,70,18,75,78,61,1,45,39,31,57,60,0,57,64,55,36,44,37,46,1,31,83,74,64,35,50,13,29,70,40,16,99,12,57,69,57,23,72,84,62,35,83,75,72,71,64,25,63,92,8,20,62,38,33,45,3,16,23,45,19,90,58,50,58,62,4,54,4,16,18,44,20,95,23,95,86,78,6,77,17,86,63,56,88,63,79,73,92,4,75,37,26,86,17,94,7,75,26,8,69,94,69,71,26,86,41,69,10,45,13,7,78,28,78,45,78,22,74,50,62,36,51,41,52,87,44,18,73,70,31,3,55,48,92,85,83,94,89,89,7,61,86,51,40,58,34,94,23,61,39,74,32,1,80,91,32,91,5,39,11,43,56,23,89,24,13,9,81,60,5,75,47,70,38,9,95,92,30,67,52,28,55,6,51,76,78,41,23,17,56,60,20,37,7,19,16,48,39,31,25,54,56,11,23,9,84,3,58,6,68,56,66,22,59,9,24,79,64,20,38,60,75,97,63,28,63,11,8,9,32,31,48,17,5,87,86,71,86,46,58,28,19,19,16,57,99,93,32,60,75,20,31,49,73,37,76,34,80,28,89,52,70,55,43,43,59,16,34,61,17,2,58,45,98,90,45,9,59,76,78,37,15,89,27,71,57,76,56,70,72,73,12,11,82,93,70,17,5,20,46,63,24,2,7,17,5,67,15,68,99,79,77,42,27,91,91,29,49,19,81,68,5,57,65,53,62,0,30,69,87,6,47,42,51,32,90,53,15,44,4,20,81,79,52,40,50,65,41,38,36,33,27,2,23,48,18,16,40,89,81,83,41,88,79,54,73,7,5,71,11,69,78,92,74,13,10,84,97,87,12,14,76,6,14,48,73,14,38,46,11,18,47,34,90,5,41,36,24,47,8,21,74,27,17,25,59,5,38,69,55,74,64,51,84,9,95,19,55,79,71,49,86,48,99,91,81,13,64,71,50,26,14,61,71,87,49,8,96,9,19,89,1,90,34,21,62,1,85,21,58,72,87,93,16,49,98,18,43,18,5,68,83,47,2,82,14,0,15,47,34,44,75,77,83,8,81,5,92,40,51,47,96,47,16,99,44,74,89,38,89,3,24,75,1,34,23,95,60,72,45,9,68,8,48,88,65,44,49,6,65,24,39,52,33,35,33,36,89,15,67,19,85,3,54,68,65,46,52,35,18,80,53,56,51,46,52,74,94,52,83,16,24,90,43,12,23,26,81,19,85,62,7,13,18,30,83,15,48,58,48,55,16,33,38,66,89,15,92,1,44,47,41,67,57,7,11,23,51,97,22,53,9,58,88,10,87,75,62,55,48,77,74,14,21,7,98,24,91,13,64,94,32,0,47,3,0,30,45,44,14,66,66,92,26,66,84,19,96,89,47,26,27,16,16,16,16,19,96,88,23,59,90,85,78,58,37,72,13,24,77,25,11,80,89,16,55,20,58,98,54,73,80,68,2,65,87,81,64,64,82,32,48,13,34,96,42,89,39,47,61,71,17,7,51,52,82,55,69,56,9,54,28,71,40,68,83,58,29,75,92,64,52,94,10,49,19,78,28,87,59,31,6,95,2,68,84,36,80,60,20,16,46,27,56,80,98,67,76,99,56,79,26,12,58,44,7,83,5,48,36,61,71,61,0,17,70,39,2,95,43,32,77,57,94,2,26,70,96,49,16,40,36,52,73,84,34,6,70,0,4,7,57,96,9,15,69,19,39,63,27,88,82,2,42,55,78,41,56,56,34,48,69,17,55,97,98,1,74,83,26,5,70,58,54,4,66,85,92,60,49,29,80,60,99,62,46,87,37,16,38,33,89,74,9,56,85,58,79,57,24,0,56,38,37,33,82,59,67,41,24,80,22,80,68,40,24,72,36,26,69,88,12,88,97,91,8,33,89,48,94,50,76,68,61,70,24,78,63,1,70,58,64,53,60,44,0,91,20,61,63,32,1,8,50,5,94,12,21,88,30,59,25,80,5,81,63,25,1,54,7,87,77,71,82,56,48,79,75,93,47,75,81,77,3,88,32,53,35,21,71,79,14,46,77,5,61,0,55,68,29,69,28,74,85,3,62,50,15,64,1,10,58,36,64,87,31,45,83,4,52,89,85,63,11,6,79,46,51,44,58,38,54,38,56,23,0,12,55,13,98,33,44,2,80,81,33,2,49,0,19,37,35,99,79,42,69,32,12,6,48,51,64,73,84,96,86,27,44,24,14,67,99,68,35,94,6,91,20,10,88,60,93,57,51,29,63,31,61,61,79,6,71,88,27,9,44,30,32,37,54,20,32,11,31,79,68,6,53,87,14,11,92,78,25,5,85,77,62,93,34,8,38,55,20,75,4,60,42,29,22,13,4,76,12,73,74,97,53,59,58,70,36,63,60,56,20,35,54,26,63,72,73,34,3,24,66,70,54,75,42,3,66,88,67,86,90,70,80,70,30,69,92,87,58,46,22,42,37,64,28,35,22,47,59,16,19,80,92,40,11,26,65,24,72,5,82,43,92,62,17,0,28,59,30,95,64,88,54,34,5,59,23,38,46,62,46,18,73,63,56,9,71,0,13,99,14,40,4,88,87,5,94,56,10,45,17,39,36,69,84,16,79,16,41,40,81,54,63,7,67,5,95,73,80,67,28,50,29,41,70,54,35,28,80,46,11,51,91,45,50,0,82,82,5,19,87,38,28,46,38,96,31,45,87,60,42,2,36,30,33,18,94,98,5,26,27,88,99,11,13,7,37,85,70,84,68,74,50,67,13,32,99,22,72,55,59,69,87,81,11,90,57,1,66,71,86,13,81,47,53,70,39,50,16,45,94,23,68,72,18,44,49,1,26,25,29,79,44,96,49,7,79,73,50,13,48,56,78,87,5,3,82,7,43,23,22,56,34,11,97,97,78,97,34,66,15,11,78,0,20,88,48,63,63,34,17,63,2,12,12,77,60,28,73,69,95,68,90,82,36,23,9,97,29,94,2,14,7,96,31,68,69,18,0,23,39,7,80,65,74,17,56,34,2,12,58,60,54,87,55,66,33,62,66,63,11,81,21,86,91,38,57,35,38,73,81,93,73,22,8,68,14,20,93,86,81,53,40,35,56,3,72,65,79,64,19,12,99,33,53,10,7,27,29,96,16,0,89,22,89,57,96,70,30,59,51,25,35,27,7,95,49,43,3,85,9,22,22,37,91,35,81,98,2,84,84,89,65,63,17,87,36,60,72,85,79,90,49,98,3,1,86,59,2,36,18,74,84,9,52,69,71,65,99,85,84,25,95,34,94,29,52,85,6,13,51,61,77,74,93,81,51,45,48,97,98,39,58,87,45,75,74,49,60,89,52,21,22,66,6,20,71,88,74,95,52,64,0,87,21,8,49,89,69,46,0,79,90,82,73,90,55,68,72,75,55,30,4,47,32,59,13,96,97,95,79,44,33,38,56,21,16,29,84,6,78,20,40,37,91,29,92,70,45,67,44,53,71,30,31,5,10,21,35,55,63,53,19,13,71,64,98,97,55,87,83,61,31,41,62,34,15,56,49,87,95,26,42,20,5,78,28,44,70,1,89,71,58,53,74,62,89,18,58,62,43,93,42,6,89,95,79,49,40,86,88,62,80,93,15,45,3,28,31,62,54,76,5,1,81,20,86,75,19,21,2,72,99,91,37,86,66,43,20,29,99,76,13,79,44,35,96,32,97,82,46,83,35,83,15,21,26,23,47,15,28,28,87,70,44,7,99,34,62,47,16,85,61,24,34,21,36,30,59,84,65,6,70,18,45,47,77,57,72,92,68,34,73,16,54,73,48,3,11,47,43,79,17,75,2,29,69,78,28,54,43,61,93,32,40,98,3,92,64,81,41,76,77,71,75,84,22,23,1,27,74,13,30,29,65,41,85,24,83,61,44,24,40,70,86,89,21,28,92,98,25,63,77,11,72,85,31,44,66,57,52,24,43,73,84,70,99,2,24,73,97,48,73,54,93,25,21,1,92,69,37,71,99,33,97,52,14,1,63,54,47,72,46,47,10,92,51,81,62,73,6,63,3,53,39,42,69,10,94,61,85,97,35,18,97,52,70,84,21,73,60,14,34,86,39,48,42,26,73,48,10,47,0,24,13,69,25,2,9,77,66,94,16,37,51,39,37,67,19,70,89,50,48,66,44,64,71,89,20,78,33,53,1,2,31,50,77,54,52,51,85,83,47,38,59,37,16,42,71,87,33,22,12,74,40,21,12,85,92,82,84,60,68,72,35,65,77,20,92,86,58,9,87,18,49,96,50,61,0,41,98,3,11,2,28,87,62,38,58,55,22,87,25,50,80,16,49,75,82,78,44,97,89,77,92,30,31,42,61,12,74,85,4,40,94,74,26,54,31,25,83,69,0,37,92,85,39,9,38,93,23,75,27,49,29,99,95,61,4,88,91,85,92,5,31,86,68,36,28,99,4,22,49,20,73,83,93,58,89,2,93,52,2,0,2,13,80,40,4,86,76,48,5,97,5,50,25,55,88,84,37,30,78,26,21,56,14,3,85,95,31,9,63,96,10,29,13,55,53,34,14,1,99,37,76,84,89,3,87,71,20,13,32,85,45,24,82,10,18,20,45,32,68,34,90,35,84,32,40,21,32,50,92,28,96,98,94,11,87,49,83,77,64,31,28,18,93,56,13,57,12,46,25,75,27,33,2,10,74,55,46,16,91,12,96,65,94,82,20,28,66,94,17,39,95,42,49,61,76,24,41,96,73,89,55,19,91,43,33,80,33,89,58,64,55,60,24,56,7,62,89,29,92,84,81,11,95,79,17,2,24,8,32,30,34,7,26,14,90,57,37,16,45,3,7,53,80,62,3,29,42,40,20,37,40,85,79,28,11,49,45,26,35,45,19,72,54,33,19,26,46,47,74,68,94,62,47,46,37,71,4,13,84,76,97,14,73,52,77,61,54,82,25,47,6,87,92,39,65,3,27,3,70,42,65,67,77,94,94,61,52,37,58,6,0,44,67,74,37,32,71,18,94,79,22,71,67,59,69,39,24,76,46,39,23,39,92,79,76,98,72,36,16,62,66,4,98,57,38,67,49,27,52,33,16,48,13,46,78,56,72,73,78,65,94,67,8,87,73,54,15,7,33,35,1,95,49,39,90,79,65,52,97,89,71,54,56,6,55,50,62,48,35,79,92,99,72,57,52,30,83,6,17,61,75,76,22,2,50,44,91,27,39,54,88,65,23,84,50,32,23,51,53,69,49,12,95,33,43,79,87,0,44,72,43,79,53,56,16,21,22,24,96,67,48,3,57,75,4,68,21,83,24,98,34,2,99,56,78,3,34,63,79,12,90,92,32,93,8,59,41,53,87,87,39,66,51,76,50,57,74,97,74,83,64,39,74,49,12,85,82,39,56,51,72,38,48,77,95,90,73,6,75,2,2,65,36,42,39,61,21,48,82,39,29,54,6,77,42,18,66,79,18,86,96,39,56,6,64,96,21,18,9,41,87,93,87,86,75,52,57,42,73,30,66,91,77,17,61,49,42,20,45,79,16,15,84,71,5,34,61,61,70,34,75,44,57,78,38,32,56,59,83,57,4,25,16,96,63,44,1,85,9,39,79,13,7,34,41,43,39,38,35,72,98,24,87,15,54,96,83,34,22,75,34,43,54,10,38,34,20,53,17,6,92,18,74,96,60,57,78,26,36,20,76,15,17,19,83,65,50,6,7,71,39,70,77,71,57,42,56,75,40,2,62,71,18,76,96,21,62,79,39,58,24,56,23,88,79,98,2,26,80,99,6,85,9,45,92,15,66,69,78,64,11,76,75,80,43,30,78,90,94,47,85,63,23,52,11,59,8,39,27,28,2,43,0,96,75,38,91,84,63,32,39,66,88,67,64,32,44,68,58,11,31,77,29,52,45,18,13,91,55,77,5,0,22,30,0,41,3,62,90,96,11,76,5,54,46,80,0,90,32,49,57,57,36,32,22,1,72,14,41,44,55,8,14,54,13,98,47,96,25,80,77,61,69,71,66,77,22,92,1,66,12,1,10,24,26,70,99,66,3,32,78,86,25,16,36,50,39,44,98,93,24,10,5,50,77,12,34,93,13,53,57,28,25,75,50,25,50,80,52,59,83,29,47,78,45,90,2,91,42,0,72,2,27,60,9,48,31,0,48,5,39,12,48,71,52,74,34,44,89,6,45,34,18,0,40,34,91,59,67,7,97,80,77,99,54,45,4,85,56,89,53,48,23,98,95,91,39,83,0,40,93,45,36,71,69,87,25,80,93,87,32,61,10,39,57,48,85,97,84,6,61,40,45,85,50,12,83,46,48,98,99,57,27,92,79,66,21,0,83,51,5,99,73,48,60,85,55,55,95,20,54,51,52,66,77,94,21,51,80,26,3,82,52,44,20,2,5,96,70,88,5,71,37,79,66,62,31,7,3,70,47,91,87,87,12,20,85,38,42,5,60,22,69,58,37,47,75,1,51,33,64,52,49,35,2,34,90,69,74,2,90,74,21,50,29,15,89,9,19,7,17,72,68,84,96,66,27,29,9,17,67,87,59,47,60,86,18,32,44,12,53,66,96,55,27,3,96,47,60,14,58,63,0,87,96,14,0,91,65,28,32,50,75,81,40,58,75,6,58,15,63,50,71,39,11,53,15,36,19,79,60,60,52,67,6,95,81,48,58,69,50,37,93,5,64,55,99,61,45,82,36,14,40,6,57,94,77,97,25,98,36,52,12,86,19,1,97,75,7,43,48,51,53,28,65,7,48,33,85,96,76,44,80,72,20,46,37,66,27,49,5,33,45,46,23,43,2,79,72,19,46,16,96,6,57,37,86,83,14,37,6,42,51,95,58,95,72,47,99,48,70,15,53,22,15,22,94,94,73,93,12,36,61,35,4,79,12,8,74,93,21,51,68,48,48,17,52,14,2,89,15,96,70,48,39,53,28,42,66,45,48,54,48,84,35,30,96,14,89,40,48,50,33,40,86,9,25,24,63,68,40,34,39,18,72,39,71,25,91,94,22,24,45,46,94,69,59,38,14,3,15,22,27,47,91,16,63,98,58,5,51,76,92,65,9,91,16,29,47,33,56,82,82,78,48,14,58,91,37,91,8,36,35,27,96,12,69,13,92,44,26,15,82,47,53,90,62,33,67,31,32,97,88,31,60,69,32,11,53,49,73,7,65,61,60,26,46,69,78,64,85,70,83,27,33,41,32,60,57,85,96,61,15,97,81,17,88,49,93,77,68,41,92,13,66,0,34,20,30,38,15,8,55,41,91,78,55,60,14,78,30,61,56,12,15,48,50,95,88,43,27,1,88,88,41,89,5,24,31,21,31,23,62,9,14,79,19,66,53,85,15,65*/};
        // int[] aa ={7,7};
        ListNode[] res = new ListNode[aa.length];
        for (int i = 0; i < aa.length; i++) {
            res[i]=new ListNode(aa[i]);
        }
        return res;
    }

}
