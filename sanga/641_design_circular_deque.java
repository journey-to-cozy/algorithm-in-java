package src.sanga;

/**
 * https://leetcode.com/problems/design-circular-deque/
 */
class DesignCircularDeque {
    public static void main(String[] args) {
        MyCircularDeque obj = new MyCircularDeque(10);
        obj.insertFront(5);
        obj.insertFront(2);
        obj.insertFront(3);
        obj.insertLast(2);
        obj.insertLast(1);
        obj.insertLast(8);
        obj.deleteFront();
        obj.deleteFront();
        obj.deleteLast();
        obj.deleteLast();
        obj.getFront();
        obj.getRear();
        obj.isEmpty();
        obj.isFull();
    }
}


class MyCircularDeque {
    int[] arr;
    int front, rear, len, size;

    public MyCircularDeque(int k) {
        arr = new int[k];
        front = 0;
        rear = k - 1;
        size = k;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        front = (front - 1 + size) % size;
        arr[front] = value;
        len++;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % size;
        arr[rear] = value;
        len++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % size;
        len--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        rear = (rear - 1 + size) % size;
        len--;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[rear];
    }

    public boolean isEmpty() {
        return len == 0;
    }

    public boolean isFull() {
        return len == size;
    }
}



/**
 * 원형 데크 디자인 - 이중 연결 리스트 방식으로 풀어보기
 */
class DesignCircularDequeUsingDoubleLinkedList {

    class MyCircularDeque {
        int size;
        int k;
        DoubleListNode head;
        DoubleListNode tail;

        public MyCircularDeque(int k) {
            head = new DoubleListNode(-1);
            tail = new DoubleListNode(-1);
            head.pre = tail;
            tail.next = head;
            this.k = k;
            this.size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) {
                return false;
            }
            DoubleListNode node = new DoubleListNode(value);
            node.next = head;
            node.pre = head.pre;
            head.pre.next = node;
            head.pre = node;
            size++;

            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) {
                return false;
            }
            DoubleListNode node = new DoubleListNode(value);
            node.next = tail.next;
            tail.next.pre = node;
            tail.next = node;
            node.pre = tail;
            size++;

            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) {
                return false;
            }
            head.pre.pre.next = head;
            head.pre = head.pre.pre;
            size--;

            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) {
                return false;
            }
            tail.next.next.pre = tail;
            tail.next = tail.next.next;
            size--;

            return true;
        }

        public int getFront() {
            return head.pre.val;
        }

        public int getRear() {
            return tail.next.val;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == k;
        }
    }

    class DoubleListNode {
        DoubleListNode pre;
        DoubleListNode next;
        int val;

        public DoubleListNode(int val) {
            this.val = val;
        }
    }
}