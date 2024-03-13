package stackimpl.arrayImpl;



public class StackArrayImpl {
    int capacity = 0;
    int arr[];
    int top = 0;
    int size = 0;

    public StackArrayImpl(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public void push(int item) {
        if (size == capacity) {
            throw new IllegalStateException("Over Flow");
        }
        arr[size] = item;
        size++;
        top++;
    }

    public int pull() {
        int res = -1;
        if (size == 0) {
            throw new IllegalStateException("Under flow");
        }
        res = arr[top-1];
        top--;
        size--;
        return res;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException("Under flow");

        }
        return arr[top-1];
    }

    public int getSize() {
        return  size;
    }

    public boolean isEmpty(){
        return size==0;
    }


}
