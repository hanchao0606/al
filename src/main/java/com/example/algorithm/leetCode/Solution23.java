package com.example.algorithm.leetCode;

public class Solution23 {
    public static void main(String[] args) {
        ListNode ListNode9 =new ListNode(9,null);
        ListNode ListNode8 =new ListNode(8,ListNode9);
        ListNode ListNode7 =new ListNode(7,ListNode8);
        ListNode ListNode3 =new ListNode(3,null);
        ListNode ListNode2 =new ListNode(2,ListNode3);
        ListNode ListNode1 =new ListNode(1,ListNode2);
        ListNode[] lists={ListNode7,ListNode1};
        ListNode res = mergeKLists(lists);
        System.out.println(res);

    }

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = mergeTwoLists(ans, lists[i]);
        }
        return ans;
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
    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null) {
            return a != null ? a : b;
        }
        ListNode head = new ListNode(0);
        ListNode tail = head, aPtr = a, bPtr = b;
        while (aPtr != null && bPtr != null) {
            if (aPtr.val < bPtr.val) {
                tail.next = aPtr;
                aPtr = aPtr.next;
            } else {
                tail.next = bPtr;
                bPtr = bPtr.next;
            }
            tail = tail.next;
        }
        tail.next = (aPtr != null ? aPtr : bPtr);
        return head.next;
    }
}