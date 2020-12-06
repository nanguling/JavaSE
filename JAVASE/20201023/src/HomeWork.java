//实现带头双向链表
public class HomeWork {
    //傀儡结点
    ListNode head = new ListNode(0);
    ListNode last;//尾结点
    //头插法
    public void addFirst(int val) {
        ListNode node = new ListNode(val);
        if (this.head.next == null) {
            this.head.next = node;
            node.prev = this.head;
            last = node;
        }else {
            node.next = this.head.next;
            this.head.next = node;
            node.next.prev = node;
            node.prev = head;
        }
    }
    //尾插法
    public void addLast(int val) {
        ListNode node = new ListNode(val);
        if (last == null) {
            addFirst(val);
        }else {
            this.last.next = node;
            node.prev = this.last;
            last = node;
        }
    }
    //任意位置插入
    public void addIndex(int index,int val) {
        if (index < 0 || index > size()) {
            System.out.println("输入下标不合法");
            return;
        }
        ListNode node = new ListNode(val);
        ListNode cur = this.head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        if (index == size()) {
            addLast(val);
            return;
        }
        cur.prev.next = node;
        node.next = cur;
        node.prev = cur.prev;
        cur.prev = node;
    }
    //查找链表是否有关键字key
    public boolean contains(int key) {
        if (this.head.next == null) {
            return false;
        }
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //删除链表的第一个出现关键字key的结点
    public void remove(int key) {
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == last) {
                    cur.prev.next = cur.next;
                    last = cur.prev;
                    return;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                    return;
                }
            }
            cur = cur.next;
        }
        System.out.println("没有找到key");
    }
    //删除所有包含关键字key的节点
    public void removeAllKey(int key) {
        ListNode cur = this.head.next;
        while (cur != null) {
            if (cur.val == key) {
                if (cur == last) {
                    cur.prev.next = cur.next;
                    last = cur.prev;
                }else {
                    cur.prev.next = cur.next;
                    cur.next.prev = cur.prev;
                }
            }
            cur = cur.next;
        }
    }
    //链表长度
    public int size() {
        ListNode cur = this.head.next;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }
    //打印双链表
    public void display() {
        ListNode cur = this.head.next;
        while (cur != null) {
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    //清除双链表
    public void clear() {
        this.head = null;
        this.last = null;
    }
}
