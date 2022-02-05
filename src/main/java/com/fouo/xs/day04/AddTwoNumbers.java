package com.fouo.xs.day04;

/**
 * 两链表相加
 *
 * @author fouo
 * @date 2021/11/30 23:11
 */
public class AddTwoNumbers {

    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        int len1 = listLength(head1);
        int len2 = listLength(head2);

        //长链表
        ListNode l = len1 >= len2 ? head1 : head2;
        //短链表
        ListNode s = l == head1 ? head2 : head1;
        ListNode curL = l;
        ListNode curS = s;
        //？ last 为长链表的最后一个节点
        ListNode last = curL;
        //进位
        int carry = 0;
        //当前数值
        int curNum = 0;
        //第一阶段 两个链表都有
        while (curS != null) {
            curNum = curL.val + curS.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
            curS = curS.next;
        }
        //第二阶段 长链表存在短链表不存在
        while (curL != null) {
            curNum = curL.val + carry;
            curL.val = (curNum % 10);
            carry = curNum / 10;
            last = curL;
            curL = curL.next;
        }
        //第三阶段都不存在,但是有进位
        if (carry != 0) {
            //last的作用是为了找到最后的位置 进行进位1
            last.next = new ListNode(1);
        }

        return l;
    }

    /**
     * 获取链表长度
     *
     * @param head
     * @return
     */
    public static int listLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }
}
