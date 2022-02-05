package com.fouo.algorithm.listnode;

/**
 * 最简单链表反转
 * 递归法
 * 非递归法
 *
 * @author fouo
 * @date 2020/10/30 0:23
 */
public class ReverseListDemo1 {

    public ListNode reverseList(ListNode head) {
        //初始化指针 prev和curr两个指针 分别指向 头结点和 头结点下一位
        ListNode prev = head;
        ListNode curr = head.next;


        //使用3指针法，反转链表的主题部分（除头结点外的部分）
        while(curr != null){
            ListNode temp= curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //修改头结点  使头结点next指针 指向空
        head.next = null;

        return prev;

    }

    public static void main(String[] args) {

    }
}
