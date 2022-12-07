// 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。

public class RemoveNthFromEnd {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {this.val = val};
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode removeNthFromEnd (ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (n-- > 0) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        System.out.println(a.val);
        for (int i = 0; i < 4; i++) {
            a = new ListNode(4 - i, a);
            System.out.println(a.val);
        }

        RemoveNthFromEnd b = new RemoveNthFromEnd();
        a = b. removeNthFromEnd(a, 2);

        for (int i = 0; i < 4; i++, a = a.next) {
            System.out.println(a.val);
        }
    }
}
