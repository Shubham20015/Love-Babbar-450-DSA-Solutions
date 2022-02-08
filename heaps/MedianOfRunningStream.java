package internship.heaps;

import java.util.*;

public class MedianOfRunningStream {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			int num = sc.nextInt();
			insertHeap(num);
			System.out.println((int)Math.floor(getMedian()));
		}
		
		sc.close();
	}
	
//	TC: O(NlogN) , SC: O(N)
	static PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
    static PriorityQueue<Integer> minheap = new PriorityQueue<>();
    
//  TC: O(logN)
    public static void insertHeap(int num)
    {
        if(maxheap.isEmpty() || maxheap.peek() >= num){
            maxheap.add(num);
        }else{
            minheap.add(num);
        }
        balanceHeaps();
    }
    
//  TC: O(logN)
    public static void balanceHeaps()
    {
       if(maxheap.size() > minheap.size() + 1){
           minheap.add(maxheap.poll());
       }else if(maxheap.size() < minheap.size()){
           maxheap.add(minheap.poll());
       }
    }
    
//    TC: O(1)
    public static double getMedian()
    {
        if(maxheap.size() == minheap.size())
            return maxheap.peek() / 2.0 + minheap.peek() / 2.0;
            
        return maxheap.peek();    
    }

}
