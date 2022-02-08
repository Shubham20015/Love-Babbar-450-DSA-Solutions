package internship.stackQueue;

public class Queue {
	private int capacity = 100,size;
	private long array[];
	private int front,rear;
	private int count;
	
	public Queue() {
		size = capacity;
		array = new long[size];
		front = 0;
		rear = -1;
		count = 0;
	}
	
	public Queue(int size) {
		this.size = size;
		array = new long[size];
		capacity = size;
		front = 0;
		rear = -1;
		count = 0;
	}
	
	public void offer(long x) {
		if(isFull()) {
			System.out.println("Queue is already filled");
			return ; 
		}
		rear = (rear+1) % capacity;
		array[rear] = x;
		count++;
	}
	
	public long poll() {
		if(isEmpty()) {
			System.out.println("Queue is already empty");
			return -1;
		}
		
		long x = array[front];
		front = (front+1)%capacity;
		count--;
		return x;
	}
	
	public int size() {
        return count;
    }
	
	public long peekFirst() {
		return array[front];
	}
	
	public long peekLast() {
		return array[rear];
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	private boolean isFull() {
		return size() == capacity;
	}
}
