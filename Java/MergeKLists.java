// 给你一个链表数组，每个链表都已经按升序排列。

// 请你将所有链表合并到一个升序链表中，返回合并后的链表。

public class MergeKLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }
        for (int i = 0; i < n - 1; ++i) {
            lists[i + 1] = mergeLists(lists[i], lists[i + 1]);
        }
        return lists[n - 1];
    }

    private ListNode mergeLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        MergeKLists.ListNode a = new MergeKLists.ListNode(3);
        MergeKLists.ListNode b = new MergeKLists.ListNode(4);

        int i = 0;
        while (i < 2) {
            a = new MergeKLists.ListNode(2 - i, a); // [1, 2, 3]
            b = new MergeKLists.ListNode(3 - i, b); // [2, 3, 4]
            i++;
        }

        ListNode[] c = new ListNode[] {a, b};

        MergeKLists d = new MergeKLists();
        a = d.mergeKLists(c);

        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
