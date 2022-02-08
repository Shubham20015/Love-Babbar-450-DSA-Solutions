package internship.searchingSorting;

import java.util.*;

public class CountTripletsLessThanSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		long arr[] = new long[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextLong();
		}
		
		int sum = sc.nextInt();
		
		Arrays.sort(arr);
        int count = 0;
        for(int i=0;i<n-2;i++){
            int j=i+1,k=n-1;
            while(j < k){
                if(arr[i] + arr[j] + arr[k] < sum){
                    count += (k-j);
                    j++;
                }else{
                    k--;
                }
            }
        }
        
        System.out.println(count);
        
        sc.close();
	}

}
