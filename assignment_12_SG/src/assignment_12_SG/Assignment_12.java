package assignment_12_SG;

public class Assignment_12 {
    
	//making the parameters for the interface
	interface Stack {
        void push(int x);
        int pop();
        int peek();
        boolean isEmpty();
        int getLength();
    }

    interface Queue {
        void enqueue(int x);
        int dequeue();
        int peek();
        boolean isEmpty();
        int getLength();
    }

    class Node {
        int data;
        Node prev, next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    class MyDoublyLinkedList {
        Node head, tail;
        int length;

        public MyDoublyLinkedList() {
            this.head = null;
            this.tail = null;
            this.length = 0;
        }
        //Creating a Doubly-Linked list
    }

    class MyStack extends MyDoublyLinkedList implements Stack { //MyStack Class taking from MyDoubleLinkedList using interface methods from Stack

    	 @Override
    	    public void push(int x) {
    	        Node newNode = new Node(x);
    	        if (head == null) {
    	            head = tail = newNode;
    	        } else {
    	            newNode.next = head;
    	            head.prev = newNode;
    	            head = newNode;
    	        }
    	        length++;
    	    }

    	    @Override
    	    public int pop() {
    	        if (isEmpty()) {
    	            throw new IllegalStateException("Stack is empty"); //failsafe if no data is present
    	        }

    	        int value = head.data;
    	        if (head == tail) {
    	            head = tail = null;
    	        } else {
    	            head = head.next;
    	            head.prev = null;
    	        }
    	        length--;
    	        return value;
    	    }

    	    @Override
    	    public int peek() {
    	        if (isEmpty()) {
    	            throw new IllegalStateException("Stack is empty"); //failsafe if no data is present
    	        }
    	        return head.data;
    	    }

    	    @Override
    	    public boolean isEmpty() { //failsafe if length equals zero
    	        return length == 0;
    	    }

    	    @Override
    	    public int getLength() {
    	        return length;
    	    }
    	}
    class MyQueue extends MyDoublyLinkedList implements Queue { //MyQueue Class taking from MyDoubleLinkedList using interface methods from Queue
    	
    	@Override
        public void enqueue(int x) {
            Node newNode = new Node(x);
            if (tail == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            length++;
        }

        @Override
        public int dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }

            int value = head.data;
            if (head == tail) {
                head = tail = null;
            } else {
                head = head.next;
                head.prev = null;
            }
            length--;
            return value;
        }

        @Override
        public int peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return head.data;
        }

        @Override
        public boolean isEmpty() {
            return length == 0;
        }

        @Override
        public int getLength() {
            return length;
        }
    }

    public static void main(String[] args) {
        Assignment_12 assignment = new Assignment_12();

        //
        MyStack stack = assignment.new MyStack();

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println("Stack Length: " + stack.getLength());
        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Is Stack Empty? " + stack.isEmpty()); //checks if stacks is empty or not

        // Test MyQueue
        MyQueue queue = assignment.new MyQueue();

        queue.enqueue(3);
        queue.enqueue(12);
        queue.enqueue(9);

        System.out.println("Queue Length: " + queue.getLength());
        System.out.println("Peek: " + queue.peek());

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        System.out.println("Is Queue Empty? " + queue.isEmpty()); //checks if queue is empty or not
    }
}
