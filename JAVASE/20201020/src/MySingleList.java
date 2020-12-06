import com.sun.org.apache.xpath.internal.objects.XNodeSet;
import com.sun.org.apache.xpath.internal.objects.XNodeSetForDOM;
import com.sun.xml.internal.ws.addressing.WsaActionUtil;

class Node {
    public int data;
    public Node next;

    //不知道next当前指向哪个节点，因此不初始化next引用
    public Node(int data) {
        this.data = data;
    }
}

public class MySingleList {
    public Node head;//定位头节点
    //头插法
    public void addFirst(int data){
        //通过data构造一个Node对象
        Node node = new Node(data);
        //node的next指向下一个node
        if (head == null) {
            //第一次插入
            this.head = node;
        }else {
            node.next = this.head;
            this.head = node;
        }
    }
    //尾插法
    public void addLast(int data){
        Node node = new Node(data);
        if (head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        /*while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;*/
        while (true) {
            if (cur.next == null) {
                cur.next = node;
                return;
            }
            cur = cur.next;
        }
    }
    //找到index-1位置的节点
    public Node searchPrev(int index) {
        Node cur = this.head;
        int count = 0;
        while (count < index-1) {
            cur = cur.next;
            count ++;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data) {
        if (index < 0 || index > size()) {
            System.out.println("输入下标不合法");
        }else if (index == 0) {
            addFirst(data);
        }else {
            Node node = new Node(data);
            Node cur = searchPrev(index);
            node.next = cur.next;
            cur.next = node;
        }
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key) {
        Node cur = this.head;
        while (cur != null) {
            if (cur.data == key) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }
    //找到key的前驱
    public Node searchPrevNode(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        Node cur = searchPrevNode(key);
        if (head.data == key) {
            this.head = head.next;
            return;
        }
        if (cur == null) {
            System.out.println("没有这个关键字");
            return;
        }
        Node del = cur.next;//要删除的节点
        cur.next = del.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key) {

    }
    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count ++;
        }
        return count;
    }
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }
    public void clear() {
        this.head = null;
    }

}
