package internship;

import java.util.*;

public class CommonElements {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		int arr3[] = new int[n3];
		int max = Integer.MIN_VALUE;
		
		
		int replace1 = 1;
		for(int i=0;i<n1;i++){
            arr1[i] = sc.nextInt();
            max = Math.max(max, arr1[i]);
            if(arr1[i] != arr1[replace1 - 1])
            	arr1[replace1++] = arr1[i];
        }
		
		int replace2 = 1;
		for(int i=0;i<n2;i++){
            arr2[i] = sc.nextInt();
            max = Math.max(max, arr2[i]);
            if(arr2[i] != arr2[replace2 - 1])
            	arr2[replace2++] = arr2[i];
        }
		
		int replace3 = 1;
		for(int i=0;i<n3;i++){
            arr3[i] = sc.nextInt();
            max = Math.max(max, arr3[i]);
            if(arr3[i] != arr3[replace3 - 1])
            	arr3[replace3++] = arr3[i];
        }
		
		int freq[] = new int[max+1];
		
		for(int i=0;i<n1;i++)
			freq[arr1[i]]++;
		
		for(int i=0;i<n2;i++)
			freq[arr2[i]]++;
		
		for(int i=0;i<n3;i++)
			freq[arr3[i]]++;
		
		for(int i=0;i<=max;i++) {
			if(freq[i] == 3)
				System.out.print(i + " ");
		}
			
		
		sc.close();
	}
}
