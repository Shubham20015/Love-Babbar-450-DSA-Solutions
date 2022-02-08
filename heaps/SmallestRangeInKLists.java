package internship.heaps;

import java.util.*;

public class SmallestRangeInKLists {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int k = sc.nextInt();
		int n = sc.nextInt();
		
		List<List<Integer>> list = new LinkedList<>();
		
		for(int i=0;i<k;i++) {
			List<Integer> arr = new LinkedList<>();
			for(int j=0;j<n;j++) {
				arr.add(sc.nextInt());
			}
			list.add(arr);
		}
		
		int ans[] = smallestRange(list);
		
		for(int val : ans) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
	static class Pair{
        int value;
        int index;
        int row;
        int arrSize;
        
        Pair(int value,int index,int row,int arrSize){
            this.value = value;
            this.index = index;
            this.row = row;
            this.arrSize = arrSize;
        }
    }
	
    static int[] smallestRange(List<List<Integer>> list) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair o1,Pair o2) -> o1.value - o2.value);
        int min = Integer.MAX_VALUE,max = Integer.MIN_VALUE;
        int n = list.size();
        for(int i=0;i<n;i++){
            pq.add(new Pair(list.get(i).get(0),0,i,list.get(i).size()));
            min = Math.min(min,list.get(i).get(0));
            max = Math.max(max,list.get(i).get(0));
        }
        
        int range = Integer.MAX_VALUE;
        int low = min,high = max;
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int mayBeMin = curr.value;
            if(range > max -  mayBeMin){
                min = mayBeMin;
                range = max -  min;
                low = min;
                high = max;
            }
            
            if(curr.index == curr.arrSize - 1) break;
            
            curr.index += 1;
            pq.add(new Pair(list.get(curr.row).get(curr.index),curr.index,curr.row,list.get(curr.row).size()));
            max = Math.max(max,list.get(curr.row).get(curr.index));
        }
    
        return new int[] {low,high};
    }

}
