package ADT;

public class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1; // Indicates an empty stack
    }

    public void push(int element) {
        if (isFull()) {
            System.out.println("Stack Overflow: Cannot push element, stack is full.");
            return;
        }
        arr[++top] = element;
        System.out.println(element + " pushed to stack.");
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: Cannot pop element, stack is empty.");
            return -1; // Or throw an exception
        }
        int poppedElement = arr[top--];
        System.out.println(poppedElement + " popped from stack.");
        return poppedElement;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty, no element to peek.");
            return -1; // Or throw an exception
        }
        return arr[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }

    public int size() {
        return top + 1;
    }
    public void print() {
        if (isEmpty()) {
            System.out.println("Stack is empty.");
            return;
        }
        System.out.print("Stack elements: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 
    public static void main(String args[])
    {
    	Stack s = new Stack(5);
    	s.push(10);
    	s.push(20);
    	s.push(30);
    	s.print();
    	s.pop();
    	s.push(40);
    	System.out.println("last elemenent" + s.peek());
    	s.print();
    }
}