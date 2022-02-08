package internship.searchingSorting;

import java.util.*;

public class FirstLastPosition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		int x = sc.nextInt();
		
		ArrayList<Long> ans = find(arr,n,x);
		
		for(long  q : ans) {
			System.out.print(q + " ");
		}
		
		sc.close();
	}
	
	static ArrayList<Long> find(long arr[], int n, int x)
    {
        ArrayList<Long> list = new ArrayList<>();
        int low = 0,high = n-1,ans = -1;
        while(low <= high){
            int mid = low + (high-low) /2;
            if(arr[mid] < x){
                low = mid+1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else{
                ans = mid;
                high = mid -1;
            }
        }
        
        list.add((long)ans);
        
        low = 0;
        high = n-1;
        ans = -1;
        while(low <= high){
            int mid = low + (high-low) /2;
            if(arr[mid] < x){
                low = mid+1;
            }else if(arr[mid] > x){
                high = mid-1;
            }else{
                ans = mid;
                low = mid + 1;
            }
        }
        
        list.add((long)ans);
        
        return list;
    }
}
