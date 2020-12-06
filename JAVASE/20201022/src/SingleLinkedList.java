import javax.swing.plaf.IconUIResource;

public class SingleLinkedList {
    //找到链表入环的第一个结点，没有返回null
    public Node detectCycle(Node head) {
        if(head == null || head.next == null) {
            return null;
        }
        //定义快慢指针
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            //快慢指针如果有环，则再某个时间快指针一定会和慢指针在环内相遇
            fast = fast.next.next;
            slow = slow.next;
            //表示有环相遇
            if (slow == fast) {
                break;
            }
        }
        //判断是以为循环条件退出还是有环跳出的
        if (fast == null || fast.next == null) {
            return null;//因为循环条件退出则无环
        }
        //有环，则让两个指针分别从头和相遇位置开始一起移动，第一次相遇的位置即就是第一个结点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
    //判断是否有环
    public boolean hasCycle(Node head){
        if (head == null || head.next == null) {
            return false;
        }
        //定义快慢指针
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            //有环则返回true
            if (slow == fast) {
                return true;
            }
        }
        //无环返回false
        return false;
    }
    //找出两个链表的公共结点
    public Node getIntersectionNode(Node headA, Node headB) {
        if(headA == null || headB == null) {
            return null;
        }
        //定义两个指针分别从各自链表头结点开始
        Node pA = headA;
        Node pB = headB;
        int a = 0;//计算A链表的长度
        int b = 0;//计算B链表的长度
        while (pA != null) {
            pA = pA.next;
            a++;
        }
        while (pB != null) {
            pB = pB.next;
            b++;
        }
        //重置指针
        pA = headA;
        pB = headB;
        int sub = a - b;//得到两链表的长度差，让链表长的先走sub个结点，然后一起移动
        if (sub < 0) {//说明此时链表A比链表B短
            for (int i = 0; i < -sub; i++) {
                pB = pB.next;//长的先走sub步
            }
        }else if (sub > 0) {
            for (int i = 0; i < sub; i++) {
                pA = pA.next;
            }
        }else {//长度相等
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
    //判断链表回文
    public boolean chkPalindrome(Node head) {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        //定义快慢指针，用以找到中间的结点
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        //cur此时为中间结点的下一个结点
        Node cur = slow.next;
        while (cur != null) {
            //临时变量
            Node curNext = cur.next;
            //反转
            cur.next = slow;
            slow = cur;
            cur = curNext;
        }
        //此时链表后边段已经反转完成，接下来只需要判断每个结点的值是否相等，不相等则返回false
        while (head != slow) {
            //链表结点偶数个的情况下head和slow不可能相遇，则如果head.next为slow也说明是回文
            if (head.next == slow) {
                return true;
            }
            if (head.data != slow.data) {
                return false;
            }
            head = head.next;
            slow = slow.next;
        }
        return true;
    }
    //删除链表中重复的结点
    public Node deleteDuplication(Node pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        //定义傀儡结点
        Node newHead = new Node(0);
        //可以防止开始两个结点就重复的情况
        newHead.next = pHead;
        Node pre = newHead;
        Node cur = newHead.next;
        while (cur != null) {
            //重复
            //防止最后的结点一直连续，加入判断条件，避免空指针异常
            if (cur.next != null && cur.data == cur.next.data) {
                //加入循环防止有多个cur重复，但是循环走完之后，cur还在重复结点的最后一个结点位置
                while (cur.next != null && cur.data == cur.next.data) {
                    cur = cur.next;
                }
                //cur就跳过了所有重复的结点
                cur = cur.next;
                //这句语句添加在这里当cur为null时pre的最后结点的next也能指向null，无需后面在让pre
                //最后一个结点指向null
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return newHead.next;
    }
    //通过给定值x将链表分成两部分，小的在前，大于等于在后
    public Node partition(Node pHead, int x) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        Node cur = pHead;
        Node as = null;
        Node ae = null;
        Node bs = null;
        Node be = null;
        while (cur != null) {
            if (cur.data < x) {
                if (as == null) {
                    as = cur;
                    ae = as;
                    cur = cur.next;
                }else {
                    ae.next = cur;
                    ae = ae.next;
                    cur = cur.next;
                }
            }else {
                if (bs == null) {
                    bs = cur;
                    be = bs;
                    cur = cur.next;
                }else {
                    be.next = cur;
                    be = be.next;
                    cur = cur.next;
                }
            }
        }
        if (as == null) {
            return bs;
        }
        if (bs == null) {
            return as;
        }
        be.next = null;
        ae.next = bs;
        return as;
    }
    //合并两个有序链表
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //创建傀儡结点
        Node newHead = new Node(0);
        Node cur = newHead;
        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            }else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        //判断如果是l1走完退出循环，那l2剩下的结点直接拼接就行
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return cur.next;
    }
    //找到链表中倒数第k个结点
    public Node FindKthToTail(Node head,int k) {
        if (head == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        //定义快慢指针
        Node fast = head;
        Node slow = head;
        //让快指针先走k-1个结点，之后快慢指针一起移动，当快指针走到最后一个结点的时候，
        // 慢指针所在的结点就是要找的结点
        for (int i = 0; i < k-1; i++) {
            //当k值大于链表长度的时候，fast会走到null，此时判断如果fast.next = null，则k值不合法
            if (fast.next == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //返回链表中间结点
    public Node middleNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义快慢指针
        Node fast = head;
        Node slow = head;
        //路程相等，fast的速度是slow的二倍，当fast跑完全程之后，slow的位置就在中间
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    //反转一个单链表
    public Node reverseList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义两个指针
        Node pre = head;//指向之前结点
        Node cur = head.next;//指向当前结点
        while (cur != null) {
            Node next = cur.next;//临时变量保存下一个结点
            cur.next = pre;//完成反转
            pre = cur;//pre向后移动
            cur = next;//cur向后移动
        }
        //原来的头结点变为尾结点，指向null
        head.next = null;
        return pre;
    }
    //删除链表中所有等于val的结点
    public Node removeElements(Node head, int val) {
        if (head == null) {
            return null;
        }
        //定义两个指针
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (cur.data == val) {
                pre.next = cur.next;
                cur = cur.next;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        //判断头结点是否等于val
        if (head.data == val) {
            head = head.next;
        }
        return head;
    }
    //删除中间结点，假设只能访问该结点
    public void deleteNode(Node node) {
        //只能访问该节点，那么也就是说只能访问这个结点之后的
        //如a，b，c，d，e这样以个链表要删除c，让d的data等于c的data，在逻辑上就变成
        //a,b,d,d,e然后删除本来的d
        node.data = node.next.data;
        node.next = node.next.next;
    }
    /*
        输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
        输出：7 -> 0 -> 8
        原因：342 + 465 = 807
     */
    public Node addTwoNumbers(Node l1, Node l2) {
        Node newHead = new Node(0);//创建傀儡结点用于存放两个链表每个结点之后的和形成新的链表
        Node pre = newHead;
        int carry = 0;//进位位
        //如果两个链表长度不一样，则让短链表后面每位相当于0，如果最后两个结点之和有进位，需要有新的结点来保存
        while (l1 != null || l2 != null || carry != 0) {
            int val1 = (l1 == null ? 0 : l1.data);//链表1的结点数据，为空则为0，不为空就是该节点data
            int val2 = (l2 == null ? 0 : l2.data);
            int val3 = val1 + val2 + carry;//每个结点的和等于两个结点本身加上上一次的进位
            carry = 0;//每次加完之后将进位位重新置为0
            if (val3 > 9) {//说明有进位
                carry = 1;
                val3 -= 10;//得到val3的个位
            }
            pre.next = new Node(val3);
            pre = pre.next;
            l1 = (l1 == null ? null : l1.next);//l1为null则继续为null，直到跳出循环
            l2 = (l2 == null ? null : l2.next);
        }
        return newHead.next;
    }
    public Node swapPairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义傀儡结点
        Node newHead = new Node(0);
        newHead.next = head;//让它成为新的头结点
        Node tmp = newHead;//创建指针
        //让两个指针分别指向tmp的next结点和next.next的结点，让这两个结点交换，然后tmp再移到交换后的第二个结点
        //开始下一次的交换
        Node node1;
        Node node2;
        //因为tmp每次移动都要判断后面两个结点，所以当tmp在最后一个结点的时候就退出
        //或者tmp在倒数第二个结点的时候就退出，因为最后一个结点不需要换
        while (tmp.next != null && tmp.next.next != null) {
            //这两个条件必须在这里进行，不然在外面赋值，再在循环体里变化的时候会发生空指针异常
            node1 = tmp.next;
            node2 = tmp.next.next;
            //交换结点
            tmp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            //tmp移到此时的第二个结点，开始下一次的交换
            tmp = node1;
        }
        return newHead.next;
    }
    //复杂链表的复制
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        copy(head);
        findRandom(head);
        return reList(head);
    }
    //复制单链表
    //例如 7,4,2,3复制之后变为7,7,4,4,2,2,3,3
    public void copy(Node head) {
        while (head != null) {
            Node clone = new Node(head.data);
            clone.next = head.next;
            head.next = clone;
            head = clone.next;
        }
    }
    //找复制的结点的random的地址
    //假设原来的结点此时random不为null，那么创建一个结点direct来让原来节点的random指向它，则复制的结点
    //的random的位置就是direct.next的位置
    public void findRandom(Node head) {
        while (head != null) {
            Node clone = head.next;
            if (head.random != null) {//说明此时结点的random有地址
                Node direct = head.random;
                clone.random = direct.next;
            }
            head = clone.next;
        }
    }
    //分割原来的链表，让复制的和原来的分开，最后返回复制的链表
    public Node reList(Node head) {
        Node newHead = head.next;
        Node node = newHead;
        head.next = node.next;
        head = head.next;
        while (head != null) {
            node.next = head.next;
            node = node.next;
            head.next = head.next.next;
            head = head.next;
        }
        return newHead;
    }
    //重排练表
    //例如:1,2,3,4,5重排之后变成:1,5,2,4,3
    public void reorderList(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }
        //第一步找到链表的中间结点
        Node fast = head;
        Node slow = head;
        Node last = new Node(0);//建立傀儡结点用来指向slow的前一个节点
        last.next = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            last = last.next;
        }
        //第二步以slow为分界线将链表分为两部分，后半部分反转，前半部分新的尾结点要指向null，即last.next = null
        last.next = null;//此时head为前半部分
        Node pre = slow;
        Node cur = slow.next;
        slow.next = null;//后半部分的尾结点指向null
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        //第三步得到两个新的链表之后按顺序进行拼接
        Node node1 = head;
        Node node2 = pre;
        Node node1Next = null;
        Node node2Next = null;
        while (node1 != null && node2 != null) {
            node1Next = node1.next;
            node2Next = node2.next;
            node1.next = node2;
            node1 = node1Next;
            //说明此时如果两个链表长度一样，则其中一个链表已经结束所有连接，剩下一个结点指向null无需再执行
            //如果两个链表长度不同（只能是前半部分比后半部分短），此时走完短的之后长的还剩一个结点，但是
            //此时也不需要继续走下去，因为结点本来不交换，切指向null
            if (node1 == null) {
                break;
            }
            node2.next = node1;
            node2 = node2Next;
        }
    }
    //删除链表中的结点，只知道入参node一个参数
    public void delNode(Node node) {
        //让该结点的值等于下一个结点
        node.data = node.next.data;
        //删除下一个结点
        node.next = node.next.next;
    }
    //奇偶链表，让奇数位的结点在前，偶数位在后，第一个结点是奇数位
    public Node oddEvenList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //创建两个傀儡结点用以分别存放奇数位和偶数位的结点
        Node node1 = new Node(0);
        Node node2 = new Node(0);
        //两个指针分别从两个傀儡结点开始
        Node tmp1 = node1;
        Node tmp2 = node2;
        Node cur = head;//用来遍历奇数位的指针
        Node pre = head.next;//遍历偶数位指针
        while (pre != null && pre.next != null) {
            tmp1.next = cur;
            tmp1 = tmp1.next;
            tmp2.next = pre;
            tmp2 = tmp2.next;
            cur = cur.next.next;
            pre = pre.next.next;
        }
        //循环跳出后要么偶数位和奇数位都遍历完成，此时cur和pre都为null
        //还有一种情况是奇数位还剩一位，cur在奇数位的最后结点也是整个链表的最后一个结点，pre为null
        tmp1.next = cur;//直接让存放奇数位结点继续拼接
        tmp1 = tmp1.next;
        tmp2.next = pre;//pre在null，所以偶数位最后一个结点指向null
        tmp1.next = node2.next;//奇数位最后一个结点拼接偶数位链表
        return node1.next;
    }
    //从链表中删除总和值为零的连续结点
    public Node removeZeroSumSublists(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            if (head.data == 0) {
                return null;
            }else {
                return head;
            }
        }
        Node newHead = new Node(0);//定义傀儡结点
        newHead.next = head;//这样指针从下一位开始的时候可以判断原来的头结点是否为0的情况
        Node h = newHead;
        while (h.next != null) {
            //定义两个指针，两个指针形成一个区间，让两个指针所指向的结点的值相加，如果这段区间的总和为0，就把这一段区间删除即可，以此重复
            Node pre = h.next;//区间左边
            Node cur = pre;//区间右边
            int sum = pre.data;//总和值是从pre加到cur
            while (cur.next != null || sum == 0) {//加入sum == 0的判断是为了防止最后的结点值的和为0，进入循环即可让链表的最后一位指向null
                if (sum == 0) {//判断当前区间开头是否为零，为零则直接删除
                    h.next = cur.next;
                    break;
                }
                //当前结点不为0，则让右边区间指针向后移动，然后计算sum
                cur = cur.next;
                sum += cur.data;
            }
            if (sum != 0) {//判断循环是否是因为和为0跳出，不是则将h移动下一位
                h = h.next;
            }
        }
        return newHead.next;
    }
    //插入排序
    public Node insertionSortList(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = new Node(0);
        newHead.next = head;
        Node pre = head;
        Node cur = head.next;
        while (cur != null) {
            if (pre.data <= cur.data) {//表示有序
                pre = cur;
                cur = cur.next;//向后移动
            }else {//无序
                Node h = newHead;
                //当链表此时无序的时候，如果h.next结点的值小于cur结点的值，那么就要进行交换，并且两者之间至少要相差一个结点，不然没办法交换
                while (h.next != cur && h.next.data < cur.data) {
                    h = h.next;
                }
                pre.next = cur.next;
                cur.next = h.next;//因为每次要确保换过来的结点是已经排序的结点里最小的
                h.next = cur;
                cur = pre.next;//cur始终在pre的下一位
            }
        }
        return newHead.next;
    }
    //反转m结点到n结点的链表，1<=m<=n<=链表长度
    public Node reverseBetween(Node head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        //快慢指针分别找到m和n位置的结点
        Node fast = head;
        Node slow = head;
        Node newHead = new Node(0);
        newHead.next = head;
        Node pre = newHead;//新的头结点用来找到m位置前的结点
        //从1开始是因为下标从1开始
        for (int i = 1; i < m; i++) {
            slow = slow.next;
            pre = pre.next;
        }
        for (int i = 1; i < n; i++) {
            fast = fast.next;
        }
        //定义指针开始反转
        Node node = slow;
        Node cur = slow.next;
        Node fNext = fast.next;//保存n结点后面的结点
        while(cur != fNext) {//要让node最后走到fast位置，因此循环退出条件是cur != fNext，这里注意，一定先保存fast的下一位，
            //不然写成 cur != fast.next就会出错，因为fast.next最后会反转
            Node next = cur.next;
            cur.next = node;
            node = cur;
            cur = next;
        }
        pre.next = node;//拼接m前的结点
        slow.next = fNext;//拼接n后的结点
        return newHead.next;
    }
    //从尾到头打印链表，返回一个数组
    public int[] reversePrint(Node head) {
        if (head == null) {
            return new int[] {};//返回一个空数组
        }
        //定义两个指针一次反转
        Node pre = head;
        Node cur = head.next;
        int size = 1;//计算长度
        while (cur != null) {
            Node next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            size++;
        }
        head.next = null;
        int[] array = new int[size];
        int i = 0;
        while (pre != null) {
            array[i] = pre.data;
            pre = pre.next;
            i++;
        }
        return array;
    }
    //移除未排序链表中重复的结点
    public Node removeDuplicateNodes(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        //定义两个指针，两次循环，第二个指针每次循环用来删除和第一个指针所指向结点值相同的结点，因此嵌套循环
        Node pre = head;
        while (pre != null) {
            Node cur = pre;//每次都让第二个指针从第一个指针开始
            while (cur.next != null) {
                if (pre.data == cur.next.data) {
                    cur.next = cur.next.next;
                }else {
                    cur = cur.next;
                }
            }
            pre = pre.next;
        }
        return head;
    }
}
