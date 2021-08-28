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

