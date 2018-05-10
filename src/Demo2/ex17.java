package Demo2;

/**
 * 复杂链表的复制
 */

public class ex17 {

    private static class ListNode<T> {
        T value;
        ListNode Pnext = null;
        ListNode pSibling = null;

        public ListNode(T value) {
            this.value = value;
        }

        public ListNode() {
        }
    }

    /**
     * 链表的创建
     *
     * @param a
     * @return
     */
    public ListNode<Integer> create(int[] a) {
        if (a.length <= 0) new NullPointerException("数组为空");
        ListNode<Integer> head = new ListNode<>(a[0]);
        ListNode<Integer> p1 = head;
        ListNode<Integer> p2 = head;
        for (int i = 1; i < a.length; i++) {
            p1 = new ListNode<>(a[i]);
            p2.Pnext = p1;
            p2 = p2.Pnext;
        }
        p1.Pnext = null;
        return head;
    }

    /**
     * 链表的遍历
     *
     * @param listNode
     */
    public void print(ListNode<Integer> listNode) {
        ListNode<Integer> listNode2 = listNode;
        while (listNode2 != null) {
            System.out.println(listNode2.value);
            listNode2 = listNode2.Pnext;
        }
    }

    /**
     * 寻找环形链表中环的入口结点
     *
     * 注释：
     * 就好比两个相遇的人，如果他俩有缘，就算一个人跑的再快，另一个人跑的再慢，命运指环终将让他们再次相遇
     * @param head
     * @return
     */
    public ListNode<Integer> EntryNodeOfLoop(ListNode<Integer> head){
        if (head == null || head.Pnext == null)
            return null;
        ListNode<Integer> slow = head.Pnext;
        ListNode<Integer> fast = head.Pnext.Pnext;
        // 让两个速率不同的指针向后指，直到找到两个指针相遇，此时两个指针一定都处在环中
        // 他两相遇的位置到链表的头必然是环的长度
        // slow + 链表的长度 = fast
        while (slow != fast){
            slow = slow.Pnext;
            fast = fast.Pnext.Pnext;
        }
        fast = head;
        // 根据环的长度，然后两个指针相差环的长度，当两个指针再次相遇时，相遇的地点就是环的入口
        while (fast != null){
            if (slow == fast)
                return fast;
            slow = slow.Pnext;
            fast = fast.Pnext;
        }
        return slow;
    }

    /**
     * 删除链表中的重复结点
     *
     * @param head
     * @return
     */
    public ListNode<Integer> DeleteDuplication(ListNode<Integer> head) {
        if (head == null) return null;
        ListNode<Integer> h = head;     // 由于头结点有可能会有改动，所以要保存头结点
        ListNode<Integer> list = head.Pnext;
        ListNode<Integer> pre = head;
        if (head.value == list.value) {
            h = list.Pnext;
            list = h;
        }
        while (list.Pnext != null) {
            if (list.value == list.Pnext.value) {
                pre.Pnext = list.Pnext.Pnext;
                list = pre.Pnext;
            } else{
                pre = list;
                list = list.Pnext;
            }
        }
        return h;
    }

    /**
     * 复杂链表的复制第一步
     * 1、复制每一个结点，并放在其后面
     *
     * @param listNode
     * @return
     */
    public ListNode<Integer> CloneNode(ListNode<Integer> listNode) {
        if (listNode == null) new NullPointerException("链表为空");
        ListNode<Integer> listNode2 = listNode;
        ListNode<Integer> head = new ListNode<>(listNode2.value);
        ListNode<Integer> node = head;
        ListNode<Integer> node2 = head;
        int count = 1;
        while (listNode2 != null) {
            if (count != 1) {
                node = new ListNode<>(listNode2.value);
                node2.Pnext = node;
                node2 = node2.Pnext;
                node = new ListNode<>(listNode2.value * 2);
                node2.Pnext = node;
                node2 = node2.Pnext;
                listNode2 = listNode2.Pnext;
            } else {
                node = new ListNode<>(listNode2.value * 2);
                node2.Pnext = node;
                node2 = node2.Pnext;
                listNode2 = listNode2.Pnext;
                ++count;
            }
        }
        // pSibling 指向设置
        node = head;
        node.pSibling = node.Pnext.Pnext.Pnext.Pnext;
        node = node.Pnext.Pnext;
        node.pSibling = node.Pnext.Pnext.Pnext.Pnext.Pnext.Pnext;
        node = node.Pnext.Pnext.Pnext.Pnext;
        node.pSibling = head.Pnext.Pnext;
        return head;
    }

    /**
     * 复制 pSibling 指针
     *
     * @param head
     * @return
     */
    public void setSiblingNodes(ListNode<Integer> head) {
        ListNode<Integer> listnode = head;
        while (listnode != null) {
            if (listnode.pSibling != null) {
                listnode.Pnext.pSibling = listnode.pSibling.Pnext;
            }
            listnode = listnode.Pnext;
        }
    }

    /**
     * 拆分链表
     *
     * @param head
     * @return
     */
    public ListNode<Integer> divideList(ListNode<Integer> head) {
        ListNode<Integer> listNode = head;
        listNode = listNode.Pnext;
        int n = 2;
        ListNode<Integer> newhead = listNode;
        ListNode<Integer> node = listNode;
        ListNode<Integer> node2 = listNode;
        while (listNode != null) {
            ++n;
            listNode = listNode.Pnext;
            if ((n & 0x1) == 0) {
                node = listNode;
                node2.Pnext = node;
                node2 = node2.Pnext;
            }
        }
        return newhead;
    }

    public static void main(String[] args) {
        ex17 e = new ex17();
        /*int[] a = {1,2,3,4,5};
        ListNode<Integer> head = e.create(a);
        ListNode<Integer> clonehead = e.CloneNode(head);
        e.setSiblingNodes(clonehead);
        e.print(clonehead);
        ListNode<Integer> newhead = e.divideList(clonehead);
        e.print(newhead);*/
        int[] a = {1, 2, 3, 3, 4, 4, 5};
        ListNode<Integer> head = e.create(a);
        ListNode<Integer> ch = e.DeleteDuplication(head);
        e.print(ch);
    }
}
