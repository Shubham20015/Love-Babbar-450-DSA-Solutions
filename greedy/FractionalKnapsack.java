package internship.greedy;

import java.util.*;

public class FractionalKnapsack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int capacity = sc.nextInt();
		Item arr[] = new Item[n];
		
		for(int i=0;i<n;i++) {
			int value = sc.nextInt();
			int weight = sc.nextInt();
			arr[i] = new Item(value, weight);
		}
		
		System.out.println(fractionalKnapsack(capacity, arr, n));
		
		sc.close();
	}
	
	static class Item {
	    int value, weight;
	    Item(int x, int y){
	        this.value = x;
	        this.weight = y;
	    }
	}
	
	 static class itemComparator implements Comparator<Item>{
	        @Override
	            public int compare(Item a, Item b)
	            {
	                double r1 = (double)a.value/(double)a.weight;
	                double r2 = (double)b.value/(double)b.weight;
	                if(r1 > r2)return -1;
	                if(r1 < r2)return 1;
	                return 0;
	            }
	    }
	    
	    static double fractionalKnapsack(int W, Item arr[], int n) 
	    {
	        Arrays.sort(arr, new itemComparator());
	        
	        double ans = 0;
	        
	        for(Item i : arr){
	            int curWt = (int)i.weight;
	            int curVal = (int)i.value;
	            if(W >= curWt){
	                W -= curWt;
	                ans += curVal;
	            }else{
	                double fraction = ((double)W / (double)curWt);
	                ans += (curVal * fraction);
	                break;
	            }
	        }
	        
	        return ans;
	    }

}
