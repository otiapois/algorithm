package com.fouo.xs.day04;

/**
 * 两有序链表合并
 *
 * @author fouo
 * @date 2021/11/30 23:46
 */
public class MergeTwoSortedLinkedList {
    public static class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        //有一个链表是空的 直接返回
        if (head1 == null || head2 == null) {
            return head1 == null ? head2 : head1;
        }
        //记录两个链表值最小的Node作为头
        ListNode head = head1.val <= head2.val ? head1 : head2;
        ListNode cur1 = head.next;
        ListNode cur2 = head1 == head ? head2 : head1;
        ListNode pre = head;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                cur1 = pre.next;
                cur1 = cur1.next;
            } else {
                cur2 = pre.next;
                cur2 = cur2.next;
            }
            pre = pre.next;
        }
        //当一条链表完了 将后面的追加上即可
        pre.next = cur1 != null ? cur1 : cur2;
        return head;
    }
}
