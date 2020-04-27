package com.stu;

import javax.xml.soap.Node;

/**
 * 两数相加
 * 给出两个 非空的链表用来表示两个非负的证书。其中，他们各自的文书是按照逆序的方式存储的，并且他们每个节点只能存储一一位数组
 * <p>
 * 如果我们将这两个数加起来，则会返回一个新的链表来表示他们的和
 * <p>
 * 假设数字0除外,这两个数都不会以0开头
 *
 * <p>
 * eg、
 * input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * output: 7 -> 0 -> 8
 * reason:  342 + 465 = 807
 * </p>
 * Created by bingye on 2020/4/27
 */
public class AddTwoNumbers {


    static class ListNode {
        int val;
        ListNode next = null;

        public ListNode(int val) {
            this.val = val;
        }
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int d1 = l1 == null ? 0 : l1.val;
            int d2 = l2 == null ? 0 : l2.val;
            int sum = d1 + d2 + carry;
            carry = sum >= 10 ? 1 : 0;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) cur.next = new ListNode(1);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode listNode = addTwoNumbers(node1, node2);

        while (true) {
            System.out.println(listNode.val);
            if (listNode.next == null) break;
            listNode = listNode.next;
        }
    }
}
