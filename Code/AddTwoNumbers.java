// 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

// 请你将两个数相加，并以相同形式返回一个表示和的链表。

// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

import java.util.ArrayList;

public class AddTwoNumbers {

    public static class ListNode {

        int val;
        ListNode next;
        ListNode(int val) {this.val = val;}
    }

    public static ListNode addTwoNumbers(ListNode o, ListNode t) {

        ListNode med = new ListNode(0);
        ListNode cur = med;

        int carry = 0;

        while (o != null || t != null || carry != 0) {
            int s = (o == null ? 0 : o.val) + (t == null ? 0 : t.val) + carry; // 单个位加法
            carry = s / 10; // 进位

            cur.next = new ListNode(s % 10); // 将单个位加法的结果置入单个位中
            cur = cur.next;

            o = (o == null ? null : o.next);
            t = (t == null ? null : t.next);
        }

        return med.next;
    }

    public static ListNode listnode_Builder(int start) {

        ListNode cur = new ListNode(start);
        ListNode save = cur;

        start++;
        int i = 1;
        while (i < 3) { // 只将链表设置为3个节点, 步长默认为1
            cur.next = new ListNode(start);
            cur = cur.next;

            start++;
            i++;
        }
        return save;
    }

    public static void main(String[] args) {

        ListNode a = listnode_Builder(6); // [6, 7, 8]
        ListNode b = listnode_Builder(7); // [7, 8, 9]

        ArrayList<Integer> c = new ArrayList<>();

        ListNode result = addTwoNumbers(a, b);
        while (result != null) {
            c.add(result.val);
            result = result.next;
        }

        System.out.println(c); // [3, 6, 8, 1]
    }
}