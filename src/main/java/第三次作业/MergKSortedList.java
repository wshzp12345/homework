package 第三次作业;

public class MergKSortedList {
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
        // 合并二个
        private ListNode twoList(ListNode l1, ListNode l2) {
            ListNode prehead = new ListNode();
            ListNode cur = prehead;
            if(l1==null) return l2;
            if(l2==null) return l1;
            while(l1!=null && l2!= null) {
                if(l1.val<l2.val){
                    cur.next =l1;
                    cur = l1;
                    l1 =l1.next;
                }else {
                    cur.next =l2;
                    cur = l2;
                    l2 =l2.next;
                }
            }

            if(l1 == null) cur.next = l2;
            if(l2 == null) cur.next = l1;
            return prehead.next;
        }
        /**
         分治 一次分治 合并 k/2 个 list长变成 k/2
         然后 k/4 k/8 ....直到只剩一个
         对于List,每次把长度k减半，分别合并0-k/2 和k/2+1 - k
         直到被划分的list 长度为2 调用towList 或长度为1返回本身，或者越界返null，
         返回后没有list 存在，变成很多已合并过一次的ListNode,再递归合并这些listNode
         */
        private ListNode merge(ListNode[] lists, int start, int end) {
            if(end< start) return null;
            if(end==start) return lists[end];
            if((end-start)==1) return twoList(lists[start],lists[end]);
            ListNode tmp1 = merge(lists, start, (start+end)/2);
            ListNode tmp2 = merge(lists,(start+end)/2+1, end);
            return twoList(tmp1,tmp2);
        }
        public ListNode mergeKLists(ListNode[] lists) {
            return merge(lists,0,lists.length-1);
        }
    }
}
