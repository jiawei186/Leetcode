public class SwapPairs {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {this.val = val;}
        ListNode(int val, ListNode next) {this.val = val; this.next = next;}
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy, cur = head;
        while(cur != null && cur.next != null) {
            ListNode t = cur.next;
            cur.next = t.next;
            t.next = cur;
            pre.next = t;
            pre = cur;
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        SwapPairs.ListNode a = new SwapPairs.ListNode(3);
        int i = 0;
        while(i < 2) {
            a = new SwapPairs.ListNode(2 - i, a);
            i++;
        }

        SwapPairs c = new SwapPairs();
        a = c.swapPairs(a);

        while(a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
