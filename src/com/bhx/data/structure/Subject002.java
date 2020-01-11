package com.bhx.data.structure;

public class Subject002 {


    /**
     * 递归实现单链表的转置
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {
        if(head==null||head.next ==null)
            return head;
        System.out.println(head.toString());
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
        node1.next=node2;
        node2.next=node3;
        node3.next=node4;
        node4.next=node5;
        ListNode node = reverseList(node1);
        while (node != null){
            System.out.print(node.val + " ");
            node=node.next;
        }
    }
}
