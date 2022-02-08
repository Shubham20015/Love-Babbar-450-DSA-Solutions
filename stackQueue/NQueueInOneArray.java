package internship.stackQueue;

public class NQueueInOneArray {
	
	private int arr[];
	private int front[];
	private int rear[];
	private int next[];
	private int free;
	
	NQueueInOneArray(int n,int k){
		this.arr = new int[n];
		this.front = new int[k];
		this.rear = new int[k];
		this.next = new int[n];
		
		for(int i=0;i<k;i++) {
			front[i] = rear[i] = -1; 
		}
		
		free = 0;
		
		for(int i=0;i<n-1;i++) {
			next[i] = i+1;
		}
		next[n-1] = -1;
	}
	
	public boolean isEmpty(int i) {
		return front[i] == -1;
	}
	
	public boolean isFull() {
		return free == -1;
	}
	
	public void enqueue(int value,int i) {
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		
		int nextfree = next[free];
		if(isEmpty(i)) {
			front[i] = rear[i] = free;
		}else {
			next[rear[i]] = free;
			rear[i] = free;
		}
		
		next[free] = -1;
		arr[free] = value;
		free = nextfree;
	}
	
	public int dequeue(int i) {
		if(isEmpty(i)) {
			System.out.println("Queue is already empty");
			return -1;
		}
		
		int frontIndex = front[i];
		front[i] = next[frontIndex];
		next[frontIndex] = free;
		free = frontIndex;
		
		return arr[frontIndex];
	}

	public static void main(String[] args) {
        NQueueInOneArray ks=  new NQueueInOneArray(10, 3);
        
        // Put some items in queue number 2
        ks.enqueue(15, 2);
        ks.enqueue(45, 2);
       
        // Put some items in queue number 1
        ks.enqueue(17, 1);
        ks.enqueue(49, 1);
        ks.enqueue(39, 1);
       
        // Put some items in queue number 0
        ks.enqueue(11, 0);
        ks.enqueue(9, 0);
        ks.enqueue(7, 0);
         
        System.out.println("Dequeued element from queue 2 is " + ks.dequeue(2));
        System.out.println("Dequeued element from queue 1 is " + ks.dequeue(1));
        System.out.println("Dequeued element from queue 0 is " + ks.dequeue(0));
	}

}
