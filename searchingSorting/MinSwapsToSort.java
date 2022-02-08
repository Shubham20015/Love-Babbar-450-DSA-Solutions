package internship.searchingSorting;

import java.util.*;

public class MinSwapsToSort {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int nums[] = new int[n];
		
		for(int i=0;i<n;i++) {
			nums[i] = sc.nextInt();
		}
		
		HashMap<Integer,Integer> map = new HashMap<>();
        int temp[] = new int[n];
        
        for(int i=0;i<n;i++) {
            temp[i] = nums[i];
            map.put(nums[i],i);
        }
        
        Arrays.sort(temp);
        
        int ans = 0;
        
        for(int i=0;i<n;i++){
            if(nums[i] != temp[i]){
                ans++;
                int extra = nums[i];
                swap(nums, i, map.get(temp[i]));
                map.put(extra,map.get(temp[i]));
                map.put(temp[i],i);
            }
        }
        
        System.out.println(ans);
		
		sc.close();
	}
	
	static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
