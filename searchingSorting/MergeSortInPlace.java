package internship.searchingSorting;

import java.util.Scanner;

public class MergeSortInPlace {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		mergeSort(arr,0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
//	TC: O(N(logN)^2) , SC: O(1)
	static void mergeSort(int arr[],int low,int high) {
		if(low == high) return;
		int mid = (low+high)/2;
		mergeSort(arr,low,mid);
		mergeSort(arr,mid+1,high);
		inPlaceMerge(arr,low,high);
	}
	
	static void inPlaceMerge(int arr[],int low,int high) {
		int gap = high-low+1;
		for(gap=findGap(gap);gap > 0;gap=findGap(gap)) {
			for(int i=low;i+gap<=high;i++) {
				int j = i+gap;
				if(arr[i] > arr[j]) {
					swap(arr,i,j);
				}
			}
		}
	}
	
	static void swap(int arr[],int i,int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	static int findGap(int gap) {
		if (gap <= 1)
            return 0;
        return (int)Math.ceil(gap / 2.0);
	}

}
