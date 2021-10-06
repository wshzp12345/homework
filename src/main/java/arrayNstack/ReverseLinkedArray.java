package arrayNstack;

public class ReverseLinkedArray {
    class Solution {
        public ListNode reverseList(ListNode head) {
            ListNode last = null;
            while(head != null) {
                ListNode nextN  = head.next;

                head.next = last;
                last = head;
                head = nextN;

            }
            return last;
        }
    }
}
