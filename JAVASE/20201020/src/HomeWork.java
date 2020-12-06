
//实现一个无头单向非循环链表
public class HomeWork {
    public Node head;//作用是，定位头节点的引用

    //头插法
    public void addFirst(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    //尾插法
    public void addLast(int data) {
        Node node = new Node(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        Node cur = this.head;
        /*while (true) {
            if (cur.next == null) {
                cur.next = node;
                break;
            }
            cur = cur.next;
        }*/
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    //找到任意位置index的前驱index-1
    //因为是在这个位置前插入的，next只能指向后一位node
    public Node searchIndex(int index) {
        Node cur = this.head;
        for (int i = 0; i < index - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index, int data) {
        if (index < 0 || index > size()) {
            System.out.println("输入的下标无效");
        } else if (index == 0) {
            addFirst(data);
        } else {
            Node node = new Node(data);
            Node cur = searchIndex(index);
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

    //找到第一次出现关键字key的前驱
    public Node searchKey(int key) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.next.data == key) {
                return cur;
            }
            cur = cur.next;
        }
        //没有找到key
        return null;
    }

    //删除第一次出现关键字为key的节点
    public void remove(int key) {
        Node cur = this.head;
        if (cur.data == key) {
            head = cur.next;
            return;
        }
        cur = searchKey(key);
        if (cur == null) {
            System.out.println("没有要删除的节点");
            return;
        }
        //要删除的节点
        Node del = cur.next;
        cur.next = del.next;
    }

    //删除所有值为key的节点
    public void removeAllKey(int key) {
        Node cur = this.head.next;
        Node pre = this.head;
        while (cur != null) {
            if (cur.data == key) {
                pre.next = cur.next;
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        if (this.head.data == key) {
            this.head = this.head.next;
        }
        /*for (int i = size()-1; i >= 0; i--) {
            remove(key);
        }*/
        //找出关键字key在整个链表中出现几次
        /*Node cur = this.head;
        int count = 0;
        while (cur != null) {
            if (cur.data == key) {
                count ++;
            }
            cur = cur.next;
        }
        for (int i = 0; i < count; i++) {
            remove(key);
        }*/
    }

    //得到单链表的长度
    public int size() {
        Node cur = this.head;
        int count = 0;
        while (cur != null) {
            cur = cur.next;
            count++;
        }
        return count;
    }

    //打印单链表
    public void display() {
        Node cur = this.head;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //从指定位置开始打印
    public void display2(Node newHead) {
        Node cur = newHead;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    //反转一个单链表
    public Node reverse() {
        Node pre = null;
        Node cur = this.head;
        Node next = null;
        Node newHead = null;
        while (cur != null) {
            next = cur.next;
            if (next == null) {
                newHead = cur;
            }
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return newHead;
        /*Node cur = this.head;
        int[] array = new int[size()];
        for (int i = size()-1; i >= 0; i--) {
            array[i] = cur.data;
            cur = cur.next;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();*/
    }

    //返回一个链表的中间结点，如果有两个返回第二个结点
    public Node middleNode() {
        Node fast = this.head;
        Node slow = this.head;
        while (true) {
            if (fast == null || fast.next == null) {
                return slow;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
    }

    //找到倒数第k个结点
    public Node findKthToTail(int k) {
        if (k <= 0) {
            return null;
        }
        Node fast = this.head;
        for (int i = 0; i < k - 1; i++) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return null;
            }
        }
        Node slow = this.head;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    public void clear() {
        this.head = null;
    }

    //合并两个升序链表为一个新的升序链表
    public Node mergeTwoLists(Node node1, Node node2) {
        Node newHead = new Node(0);
        Node cur = newHead;
        while (node1 != null && node2 != null) {
            //小的data放前面
            if (node1.data < node2.data) {
                cur.next = node1;
                cur = cur.next;
                node1 = node1.next;
            } else {
                cur.next = node2;
                cur = cur.next;
                node2 = node2.next;
            }
        }
        //while循环走完之后有其中一个链表还会剩下一个结点，此时让剩下的结点直接拼接就好
        if (node1 == null) {
            cur.next = node2;
        } else if (node2 == null) {
            cur.next = node1;
        }
        return newHead.next;
    }

    //通过定值x将链表分成两个部分，小于x的结点排在大于或等于x的结点之前
    public Node partition(Node pHead, int x) {
        Node cur = pHead;
        //判断是否为空
        if (pHead == null) {
            return null;
        }
        //判断是否只有头节点
        if (pHead.next == null) {
            return pHead;
        }
        //创建存放小于x的傀儡结点
        Node small = new Node(0);
        Node smaller = small;
        //创建存放大于x的傀儡节点
        Node big = new Node(0);
        Node bigger = big;
        while (cur != null) {
            if (x > cur.data) {
                smaller.next = cur;
                cur = cur.next;
                smaller = smaller.next;
            } else {
                bigger.next = cur;
                cur = cur.next;
                bigger = bigger.next;
            }
        }
        //如果没有小于x的结点，直接返回大于x的链表
        if (small.next == null) {
            return big.next;
        }
        //将大于x的最后一位的next指向null
        bigger.next = null;
        //拼接
        smaller.next = big.next;
        return small.next;
    }

    //删除链表中重复的节点，返回头节点
    public Node delete(Node pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //建立一个新的头节点，让cur从新节点的下一个开始，pre从新节点开始，
        //这样可以防止pHead前两个就是重复的情况
        Node newHead = new Node(0);
        newHead.next = pHead;
        Node cur = newHead.next;
        Node pre = newHead;
        //找出重复的结点，让pre指向不重复的，即可完成删除
        while (cur != null) {
            /*当cur的值等于cur.next的值的时候，进入循环cur先往后移一步，倘若多个连续相同的
            那么也能将cur移到这些连续相等的结点的最后一个结点，然后跳出循环再后移一步，
            这样就能删除所有重复的节点了*/
            //加入cur.next != null的判断条件是因为，有可能cur的当前位置是在最后一个结点，那么就会
            //发生空指针异常
            if (cur.next != null && cur.data == cur.next.data) {
                //加入cer.next != null的判断条件是因为，有可能末尾是两个重复的结点，此时cur在倒数
                //第二个结点上，那么当他进去循环执行一次之后，就会发生空指针异常
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                cur = cur.next;
                //尽管后面都是相等的，那么newHead的最后一个结点pre.next也指向null
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
    //旋转链表，给定一个k值，将每个结点向右移动k个位置
    public Node rotateRight(Node head,int k) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义一个尾结点从头开始遍历找到尾结点的位置，并且记录下链表的长度
        Node oldTail = head;
        int count = 1;//这里从1开始计数，是因为oldTail等于null退出时，后面会发生空指针异常，所以
        //遍历少一次，则初始值就从1开始
        while (oldTail.next != null) {
            oldTail = oldTail.next;
        }
        //此时尾结点的next指向head形成一个环
        //如果上面循环是以oldTail == null为结束条件，此时便会发生空指针异常
        oldTail.next = head;
        //count - k % count - 1的位置代表新的尾结点
        //count - k % count的位置代表新的头结点
        //此时只需要找到新的尾结点，通过next指向新的头结点就行
        for (int i = 0; i <= (count - k % count -1); i++) {
            oldTail = oldTail.next;
        }
        //新的尾结点
        Node newTail = oldTail;
        //新的头结点
        Node newHead = newTail.next;
        //将尾结点指向null
        newTail.next = null;
        return newHead;
    }
    //判断是否有环形链表
    public boolean hasCycle(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        //定义一个快指针
        Node fast = head.next;
        //定义一个慢指针
        Node slow = head;
        //如果fast==null的话，这就代表整个链表没有环，并且这样判断速度快，不需要全都遍历一遍
        while (fast != null) {
            //两个结点内存地址相同则代表找到了环
            if (slow == fast) {
                return true;
            }
            //慢指针每次移动一个结点
            slow = slow.next;
            //代表此时没有环，因为有环的化fast.next不可能为null
            if (fast.next == null) {
                return false;
            }else {
                //快指针每次移动两个结点，如果有环则在某个时间点快指针一定会和慢指针相遇
                //即指向同一个结点（路程一样，速度二倍的一定会在之后的某个时间追上速度小的）
                fast = fast.next.next;
            }
        }
        return false;
    }
    //链表相交
    public Node getIntersectionNode(Node headA,Node headB) {
        if (headA == null || headB == null) {
            return null;
        }
        //定义两个指针分别从各自链表头结点开始
        Node pA = headA;
        Node pB = headB;
        int a = 0;//用于计算headA的长度
        int b = 0;///计算headB的长度
        while (pA != null) {
            pA = pA.next;
            a++;
        }
        while (pB != null) {
            pB = pB.next;
            b++;
        }
        //绕过pA和pB再次从头结点开始
        pA = headA;
        pB = headB;
        int sub = a-b;//sub为两个链表的长度差，让长的先向后走sub之后两个指针再同时向后走到相等的结点
        if(sub < 0) {//说明此时pA的长度比pB短，让pB先走sub个结点
            for (int i = 0; i < -sub; i++) {
                pB = pB.next;
            }
        }else if (sub > 0) {//此时pA长度大于pB，pA先走sub个结点
            pA = pA.next;
        }else {//相等
            //判断两个结点是否相等
            if (pA == pB) {
                return pA;
            }
        }
        //此时pA和pB的进度一样，只需判断结点是否相等
        while (pA != pB) {
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
    public Node partition(int x) {
        // write code here
        Node bs = null;
        Node be = null;
        Node as = null;
        Node ae = null;
        Node cur = this.head;

        while (cur != null) {
            if(cur.data < x) {
                if(bs == null) {
                    bs = cur;
                    be = bs;
                }else {
                    be.next = cur;
                    be = be.next;
                }
            }else {
                if(as == null) {
                    as = cur;
                    ae = as;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                }
            }
            cur = cur.next;
        }
        if (bs == null) {
            return as;
        }
        if (as == null) {
            return bs;
        }
        ae.next = null;
        be.next = as;
        return bs;
    }
    //判断是否回文
    public boolean chkPalindrome() {
        if (this.head == null) {
            return false;
        }
        if (this.head.next == null) {
            return true;
        }
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        Node cur = slow.next;
        while (cur != null) {
            Node curNext = cur.next;
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        while (this.head != slow) {
            if (this.head.data != slow.data) {
                return false;
            }
            if (this.head.next == slow) {
                return true;
            }
            this.head = this.head.next;
            slow = slow.next;
        }
        return true;
    }
    //找到环的入口点
    public Node hasCycle() {
        Node fast = this.head;
        Node slow = this.head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        Node cur = this.head;
        while (cur != fast) {
            cur = cur.next;
            fast = fast.next;
        }
        return cur;
    }
    public Node IntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        Node pA = headA;
        Node pB = headB;
        int a = 0;
        int b = 0;
        while (pA != null) {
            pA = pA.next;
            a++;
        }
        while (pB != null) {
            pB = pB.next;
            b++;
        }
        int sub = a-b;
        pA = headA;
        pB = headB;
        if (sub < 0) {
            for (int i = 0; i < -sub; i++) {
                pB = pB.next;
            }
        }else if (sub > 0) {
            for (int i = 0; i < sub; i++) {
                pA = pA.next;
            }
        }else {
            if (pA == pB) {
                return pA;
            }
        }
        while (pA != pB) {
            if (pA.next == null) {
                return null;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return pA;
    }
    
}

