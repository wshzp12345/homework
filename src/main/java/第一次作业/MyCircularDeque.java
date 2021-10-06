package 第一次作业;

public class MyCircularDeque {
    int[] queue;
    int length=0;
    int start=0;
    int end=0;

    public MyCircularDeque(int k) {
        queue = new  int [k];
    }

    public boolean insertFront(int value) {
        if(isFull()) return false;
        else {
            if(isEmpty()) {
                queue[start] = value;
                length++;
                return true;
            }
            start = getIndex(start-1);
            queue[start] = value;
            length++;
            return true;
        }
    }

    public boolean insertLast(int value) {
        if(isFull()) return false;
        else {
            if(isEmpty()) {
                queue[end] = value;

                length++;
                return true;
            }
            end = getIndex(end+1);
            queue[end] = value;
            length++;
            return true;
        }
    }

    public boolean deleteFront() {
        if(isEmpty()) return false;
        else {
            queue[start] = 0;

            length--;
            if(isEmpty()) {
                reset();
            } else {
                start = getIndex(start + 1);
            }
            return true;
        }
    }

    public boolean deleteLast() {
        if(isEmpty()) return false;
        else {
            queue[end] = 0;

            length--;
            if(isEmpty()) {
                reset();
            }else {
                end = getIndex(end - 1);
            }
            return true;
        }
    }

    public int getFront() {
        if(isEmpty()) return -1;
        else {
            return queue[start];

        }
    }

    public int getRear() {
        if(isEmpty()) return -1;
        else {
            return queue[end];

        }
    }

    public boolean isEmpty() {
        if(length == 0) return true;
        else return false;
    }

    public boolean isFull() {
        if(length == queue.length) return true;
        else return false;
    }
    private int getIndex(int i) {
        if(i<0){
            return i + queue.length ;
        } else {
            return i% queue.length;

        }

    }
    private void reset() {
        start = end = 0;
    }
}
