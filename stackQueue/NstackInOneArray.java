package internship.stackQueue;

public class NstackInOneArray {
	private int arr[];
	private int top[];
	private int next[];
	private int free;
	
	NstackInOneArray(int n,int k){
		arr = new int[n];
		top = new int[k];
		next = new int[n];
		free = 0;
		
		for(int i=0;i<k;i++)
			top[i] = -1;
		for(int i=0;i<n-1;i++) {
			next[i] = i+1;
		}
		next[n-1] = -1;
	}
	
	public boolean isEmpty(int sn) {
		return top[sn] == -1;
	}
	
	public boolean isFull() {
		return free == -1;
	}
	
	public void push(int item,int sn) {
		if(isFull()) {
			System.out.println("Overflow");
			return;
		}
		
		int i = free;
		free = next[i];
		next[i] = top[sn];
		top[sn] = i;
		arr[i] = item;
	}
	
	public int pop(int sn) {
		if(isEmpty(sn)) {
			System.out.println("Already Empty");
			return -1;
		}
		
		int i = top[sn];
		top[sn] = next[i];
		next[i] = free;
		free = i;
		return arr[i];
	}
	
	public static void main(String args[]) {
		
		NstackInOneArray ks = new NstackInOneArray(10,3);
		
		// Put some items in stack number 2
		ks.push(15, 2);
        ks.push(45, 2);
  
        // Put some items in stack number 1
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
  
        // Put some items in stack number 0
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
  
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
	}
}
