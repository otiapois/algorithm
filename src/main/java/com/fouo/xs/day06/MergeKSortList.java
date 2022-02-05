package com.fouo.xs.day06;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 多个链表排序 合并且排序
 *
 * @author fouo
 * @date 2021/12/8 20:48
 */
public class MergeKSortList {

    public static class ListNode {
        public int val;
        public ListNode next;
    }

    /**
     * 负数返回第一个
     * 正数返回第二个
     * <p>
     * 返回较小节点的比较器
     */
    public static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        //加入比较器,实现小根堆
        PriorityQueue<ListNode> heap = new PriorityQueue<>(new ListNodeComparator());

        if (lists != null && lists.length > 0) {
            for (ListNode list : lists) {
                heap.add(list);
            }
        }
        if (heap.isEmpty()) {
            return null;
        }

        //弹出最小的头
        ListNode head = heap.poll();
        ListNode pre = head;

        if (pre.next != null) {
            heap.add(pre.next);
        }
        while (!heap.isEmpty()) {
            ListNode cur = heap.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                heap.add(cur.next);
            }
        }
        return head;
    }
}
