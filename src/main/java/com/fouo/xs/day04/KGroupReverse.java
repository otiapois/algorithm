package com.fouo.xs.day04;

/**
 * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * <p>
 * k 是一个正整数，它的值小于或等于链表的长度。
 * <p>
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class KGroupReverse {
    public class ListNode {
        public int val;
        public ListNode next;
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        //将头节点指向开始
        ListNode start = head;
        //寻找end节点
        ListNode end = getKGroupEnd(start, k);
        if (end == null) {
            return head;
        }
        //第一组凑齐了
        head = end;
        reverse(start, end);
        ListNode lastEnd = start;
        while (lastEnd.next != null) {
            start = lastEnd.next;
            end = getKGroupEnd(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastEnd.next = end;
            lastEnd = start;
        }

        return head;
    }

    /**
     * 从start 开始返回第k个节点
     * 如果k大于长度（超出界了）
     * 返回空
     *
     * @param start
     * @param k
     * @return
     */
    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }

    /**
     * 从start到end的一个反转
     *
     * @param start
     * @param end
     */
    public static void reverse(ListNode start, ListNode end) {
        //多往后记录一位
        end = end.next;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = start;
        //走链表反转的逻辑
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //将start指向end
        start.next = end;
    }
}
