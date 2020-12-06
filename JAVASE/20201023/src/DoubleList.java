class ListNode {
    public int val;
    public ListNode next;
    public ListNode prev;
    public ListNode(int val) {
        this.val = val;
    }
}
public class DoubleList {
    public ListNode head;
    public ListNode last;//标记双向链表的尾部
    //头插法
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        if (this.head == null) {
            this.head = node;
            this.last = node;
        }else {
            node.next = this.head;
            this.head.prev = node;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        if (this.last == null) {
            this.last = node;
            this.head = node;
        }else {
            this.last.next = node;
            node.prev = this.last;
            this.last = node;
        }
    }
    //查找关键字
    public boolean contains(int key) {
        if (this.head == null) {
            return false;
        }
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //计算长度
    public int size() {
        if (this.head == null) {
            return 0;
        }
        ListNode cur = head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印双向链表
    public void display() {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //任意位置插入，第一个数据结点为0号下标
    public void addIndex(int index,int data) {
        if (index < 0 || index > size()) {
            System.out.println("下标不合法");
            return;
        }
        if(index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode node = new ListNode(data);
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        node.next = cur;
        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
    }
    //删除第一次出现关键字key的结点
    public void remove(int key) {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                break;
            }
            cur = cur.next;
        }
        if (cur == null) {
            System.out.println("找不到关键字key");
            return;
        }
        if (cur == this.head) {
            this.head = this.head.next;
            this.head.prev = null;
            return;
        }
        if (cur == this.last) {
            cur.prev.next = cur.next;
            this.last = cur.prev;
            return;
        }
        cur.prev.next = cur.next;
        cur.next.prev = cur.prev;
    }
    //删除所有关键字key的结点
    public void removeAllKey(int key) {
        if (this.head == null) {
            return;
        }
        ListNode cur = this.head;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == this.head) {
                    if(head.next == null) {
                        head = null;
                        break;
                    }
                    this.head = this.head.next;
                    this.head.prev = null;
                }else if (cur == this.last) {
                    cur.prev.next = cur.next;
                    this.last = cur.prev;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    public void clear() {
        this.head = null;
        this.last = null;
    }
}

