package internship.searchingSorting;

import java.util.*;

public class SubsetSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		
		solve(arr,0,(n/2)-1,arr1);
		solve(arr,(n/2),n-1,arr2);
		
		
		Collections.sort(arr2);
		
		int count = 0;
		for(int i=0;i<arr1.size();i++) {
			int low = lower_bound(arr2,A-arr1.get(i));
			int high = upper_bound(arr2,B-arr1.get(i));
			count += (high - low);
		}
		
		System.out.println(count);
		
		sc.close();
	}
	
	static int lower_bound(ArrayList<Integer> l2,int target) {
        int low = 0;
        int high = l2.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target <= l2.get(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        if(low < l2.size() && l2.get(low) < target) {
            low++;
         }
        
        return low;
    }
	
	static int upper_bound(ArrayList<Integer> l2,int target) {
		int low = 0;
        int high = l2.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (target >= l2.get(mid)) {
            	low = mid + 1;
            } else {
            	high = mid;
            }
        }
        
        if(low < l2.size() && l2.get(low) <= target) {
            low++;
         }
        
        return low;
	}
	
	static void solve(int arr[],int low,int high,ArrayList<Integer> res){
		int sum = 0;
		int n = high-low+1;
		for(int i=0;i<(1<<n);i++) {
			sum = 0;
			int j = low;
			int x = i;
			while(x > 0) {
				int l = x&1;
				if(l == 1)
					sum += arr[j];
				j++;
				x = x >> 1;
			}
			res.add(sum);
		}
	}

}
