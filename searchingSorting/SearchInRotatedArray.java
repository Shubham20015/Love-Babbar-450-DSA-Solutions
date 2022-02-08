package internship.searchingSorting;

import java.util.Scanner;

public class SearchInRotatedArray {
	public static void main(String[] args) {
			
			Scanner sc = new Scanner(System.in);
			
			int n = sc.nextInt();
			int arr[] = new int[n];
			
			for(int i=0;i<n;i++) {
				arr[i] = sc.nextInt();
			}
			
			int target = sc.nextInt();
			
			System.out.println(search(arr,target));
			
			sc.close();

	}
		
	static int search(int nums[],int target) {
		
		int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;
        
            if (nums[start] <= nums[mid]){
                 if (target < nums[mid] && target >= nums[start]) 
                    end = mid - 1;
                 else
                    start = mid + 1;
            } 
        
            if (nums[mid] <= nums[end]){
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                 else
                    end = mid - 1;
            }
        }
        return -1;
	}

}
