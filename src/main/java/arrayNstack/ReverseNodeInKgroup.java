package arrayNstack;

public class ReverseNodeInKgroup {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            // 遍历

            ListNode preHead = new ListNode( 0);
            ListNode last = preHead;
            preHead.next = head;
            while(head != null) {
                //分组
                //找到每组head tail
                ListNode tail = getTail(head,k);
                if(tail==null) break;
                ListNode nextGroup = tail.next;
                //反转 head tail
                reverseList(head, nextGroup);
                //链接各个小组
                last.next = tail;
                head.next = nextGroup;
                last = head;
                head = nextGroup ;
            }

            return preHead.next;
        }
        // 返回 分组的最后一个节点，后续好进行遍历,注意 递增和返回的前后顺序
        public ListNode getTail(ListNode head, int k) {
            int i = 0;
            while(head != null){
                i++;
                if(i==k) return head;
                head = head.next;
            }
            return null;
        }
        // 反转从head 到stop
        public ListNode reverseList(ListNode head,ListNode stop) {
            ListNode last = null;
            while(head != stop) {
                ListNode nextN  = head.next;

                head.next = last;
                last = head;
                head = nextN;

            }
            return last;
        }
    }
}
