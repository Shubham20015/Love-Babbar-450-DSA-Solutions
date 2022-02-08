package internship.greedy;

import java.util.*;

public class MinPlatform {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		int dep[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			dep[i] = sc.nextInt();
		}
		
		System.out.println(findPlatform(arr,dep,n));
		
		sc.close();
	}
//	TC: O(2NlogN) , SC: O(2N)
	static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat_need = 1,result = 1;
        int i=1,j = 0;
        
        while(i < n && j < n){
            if(arr[i] <= dep[j]){
                plat_need++;
                i++;
            }
            else if(arr[i] > dep[j]){
                plat_need--;
                j++;
            }
            result = Math.max(result,plat_need);
        }
        
        return result;
    }

}
