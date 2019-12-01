package com.bhx.data.structure;

public class Subject001 {

    /**
     *   合并两个有序的链表  非递归实现方式
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) {
            return l1 != null ? l1 : l2;
        }
        ListNode head = l1.val < l2.val ? l1 : l2;
        ListNode other = l1.val >= l2.val ? l1 : l2;
        ListNode prevHead = head;
        ListNode prevOther = other;
        while (prevHead != null) {
            ListNode next = prevHead.next;
            if (next != null && next.val > prevOther.val) {
                prevHead.next = prevOther;
                prevOther = next;
            }
            if(prevHead.next==null){
                prevHead.next=prevOther;
                break;
            }
            prevHead=prevHead.next;
        }
        return head;
    }

    /**
     * 递归实现单链表的转置
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        ListNode prev = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return prev;
    }

    /**
     * 创建一个静态内部类，用静态修饰是为了在main方法中测试，需随着类的加载而产生。
     */
   static class ListNode {
        /**
         * 为了方便，这两个变量都使用public，而不用private就不需要编写get、set方法了。
         */
        public int val;
        /**
         * 存放结点的变量,默认为null
         */
        public ListNode next;

        public ListNode(int val){
            this.val= val;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next=node3;
        node3.next=node5;
        node2.next=node4;
        ListNode node = mergeTwoLists(node1,node2);
        while (node != null){
            System.out.print(node.val + " ");
            node=node.next;
        }
    }
}
