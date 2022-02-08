package internship.stackQueue;

import java.util.*;

public class CircularQueue {
	private int size;
	private int front,rear;
	private ArrayList<Integer> arr;
	
	CircularQueue(int n){
		size = n;
		front = rear = -1;
		arr = new ArrayList<>();
	}
	
	public boolean isEmpty() {
		return front == -1;
	}
	
	public boolean isFull() {
		return (front == 0 && rear == size-1) || rear == (front-1)%(size-1); 
	}
	
	public void enqueue(int x) {
		if(isFull()) {
			System.out.println("Overflow");
			
		}else if(isEmpty()) {
			front = rear = 0;
			arr.add(rear, x);
		}else if(rear == size-1 && front != 0) {
			rear = 0;
			arr.set(rear, x);
		}else {
			rear++;
			if(front <= rear)
				arr.add(rear, x);
			else
				arr.set(rear, x);
		}
	}
	
	public int dequeue() {
		if(isEmpty()) {
			System.out.println("Empty Already");
			return -1;
		}
		
		int x = arr.get(front);
		
		if(front == rear) {
			front = rear = -1;
			
		}else if(front == size-1) {
			front = 0;
		}else {
			front++;
		}
		
		return x;
	}
	
	public void displayQueue() {
		 if(isEmpty())
		    {
		        System.out.print("Queue is Empty");
		        return;
		    }
		 
		 System.out.print("Elements in the circular queue are: ");
		 if(rear >= front)
		    {
		        for(int i = front; i <= rear; i++)
		        {
		            System.out.print(arr.get(i) + " ");
		        }
		        System.out.println();
		    }
		 
		    else
		    {
		         
		        for(int i = front; i < size; i++)
		        {
		            System.out.print(arr.get(i) + " ");
		        }
		 
		        for(int i = 0; i <= rear; i++)
		        {
		            System.out.print(arr.get(i) + " ");
		        }
		        System.out.println();
		    }
	}
	
	public static void main(String args[]) {
		
		CircularQueue q = new CircularQueue(5);
	     
	    q.enqueue(14);
	    q.enqueue(22);
	    q.enqueue(13);
	    q.enqueue(-6);
	     
	    q.displayQueue();
	 
	    int x = q.dequeue();
	 
	    if(x != -1)
	    {
	        System.out.print("Deleted value = ");
	        System.out.println(x);
	    }
	 
	    x = q.dequeue();
	 
	    if(x != -1)
	    {
	        System.out.print("Deleted value = ");
	        System.out.println(x);
	    }
	 
	    q.displayQueue();
	     
	    q.enqueue(9);
	    q.enqueue(20);
	    q.enqueue(5);
	     
	    q.displayQueue();
	     
	    q.enqueue(20);
	}
}
