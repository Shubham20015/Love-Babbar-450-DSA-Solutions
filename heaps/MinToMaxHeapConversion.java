package internship.heaps;

import java.util.Scanner;

public class MinToMaxHeapConversion {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
			
		for(int i=n/2-1;i>=0;i--) {
			maxheapify(arr,n,i);
		}
		
		for(int val : arr) {
			System.out.print(val + " ");
		}
		
		sc.close();

	}
	
	static void maxheapify(int arr[],int n,int i) {
		int largest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < n && arr[left] > arr[largest])
			largest = left;
		if(right < n && arr[right] > arr[largest])
			largest = right;
		
		if(largest != i) {
			int temp = arr[i];
			arr[i] = arr[largest];
			arr[largest] = temp;
			maxheapify(arr,n,largest);
		}
	}

}
