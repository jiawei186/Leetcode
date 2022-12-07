// 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 

public class MergeTwoLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        if (list1.val <= list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3);
        ListNode b = new ListNode(4);
        int i = 0;
        while (i < 2) {
            a = new ListNode(2 - i, a); // [1, 2, 3]
            b = new ListNode(3 - i, b); // [2, 3, 4]
            i++;
        }

        MergeTwoLists c = new MergeTwoLists();
        a = c.mergeTwoLists(a, b);

        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
