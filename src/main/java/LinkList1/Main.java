package LinkList1;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val){this.val = val;}
    ListNode(){}


    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                '}';
    }
}

public class Main {

    //移除链表元素
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode cur = dummyHead;

        while (cur.next!=null){
            if (cur.next.val == val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }

        return dummyHead.next;
    }

    //两两交换链表
    // 1---> 2 --->3 -->4
    // 2---> 1---->4--->3
    public ListNode swapPairs(ListNode head) {
        //虚拟头结点
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;

        ListNode cur = dummyHead;
        ListNode node1,node3;
        while (cur.next!=null && cur.next.next!=null){

            node1 = cur.next;
            node3 = cur.next.next.next;


            (cur).next = (cur.next.next);
            // 此时cur.next 就是node2
            (cur.next).next = node1;
            node1.next = node3;

            cur = cur.next.next;
        }

        return dummyHead.next;
    }


    //反转链表
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (head!=null){
            head = head.next;
            cur.next = pre;
            pre = cur;
            cur = head;
        }

        return pre;
    }

    //移除第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode();
        dummyHead.next = head;
        ListNode slow = dummyHead,fast = head;
        for (int i = 0;i<n;i++){
            fast = fast.next;
        }

        while (fast !=null){
            slow = slow.next;
            fast = fast.next;
        }

        if(slow!=null && slow.next!=null){
            slow.next = slow.next.next;
        }

        return dummyHead.next;

    }

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;

        while (fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;

            if (fast!=null && slow.val == fast.val){
                return fast.next;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode1;
//        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//
//
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode2;

        Main main = new Main();
        System.out.println(main.detectCycle(listNode1));
//        ListNode listNode = main.swapPairs(listNode1);
//        System.out.println(listNode);

//        ListNode listNode1 = new ListNode(111);
//        ListNode listNode2 = new ListNode(222);
//        listNode1.next = listNode2;
//
//
//        ListNode tmp = listNode2;
//        tmp.next=listNode1;
//
//        System.out.println(listNode2.next.val );
//
//        listNode2.next.val = 3;
//        System.out.println(listNode1.val);
    }

}
