package internship;

import java.util.*;

public class MergeSortedArrays {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			arr2[i] = sc.nextInt();
		}
		
		int i = 0;
        int j = 0;
        int k = n-1;
        
        while(i<=k && j<m){
            if(arr1[i] > arr2[j]){
               int temp = arr2[j];
                arr2[j] = arr1[k];
                arr1[k] = temp;
                j++;
                k--;
            }else{
                i++;
            }
        }
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        
        StringBuffer str = new StringBuffer();
        
        for(i=0;i<n;i++) {
			str.append(arr1[i] + " ");
		}
		
		for(i=0;i<m;i++) {
			str.append(arr2[i] + " ");
		}
		
		System.out.println(str);
		
		sc.close();
	}

}
