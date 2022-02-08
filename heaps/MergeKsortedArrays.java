package internship.heaps;

import java.util.*;

public class MergeKsortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int k = sc.nextInt();
		int arr[][] = new int[k][k]; 
		
		for(int i=0;i<k;i++) {
			for(int j=0;j<k;j++) {
				arr[i][j] = sc.nextInt(); 
			}
		}
		
		ArrayList<Integer> ans = mergeKArrays(arr, k);
		
		for(int val : ans) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
	static class Pair{
        int value;
        int row;
        int index;
        Pair(int x,int i,int j){
            value = x;
            index = i;
            row = j;
        }
    }
    
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>((Pair obj1,Pair obj2) -> obj1.value - obj2.value);
        for(int i=0;i<k;i++){
            pq.add(new Pair(arr[i][0], 0, i));
        }
        
        ArrayList<Integer> ans = new ArrayList<>();
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            ans.add(curr.value);
            
            if(curr.index < k-1){
                int row = curr.row;
                int index = curr.index + 1;
                pq.add(new Pair(arr[row][index],index,row));
            }
        }
        
        return ans;
    }

}
