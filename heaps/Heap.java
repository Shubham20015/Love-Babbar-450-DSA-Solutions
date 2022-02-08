package internship.heaps;

import java.util.Scanner;

public class Heap {
	
	private void maxheapify(int arr[],int n,int i) {
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
	
	private void minheapify(int arr[],int n,int i) {
		int smallest = i;
		int left = 2*i+1;
		int right = 2*i+2;
		
		if(left < n && arr[left] < arr[smallest])
			smallest = left;
		if(right < n && arr[right] < arr[smallest])
			smallest = right;
		
		if(smallest != i) {
			int temp = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = temp;
			minheapify(arr,n,smallest);
		}
	}
	
	void buildMaxheap(int arr[],int n) {
		for(int i=n/2-1;i>=0;i--) {
			maxheapify(arr,n,i);
		}
	}
	
	void buildMinheap(int arr[],int n) {
		for(int i=n/2-1;i>=0;i--) {
			minheapify(arr,n,i);
		}
	}
	
	void heapSort(int arr[],int n) {
		
		buildMaxheap(arr,n);
		
		for(int i=n-1;i>0;i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			maxheapify(arr,i,0);
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		Heap pq = new Heap();
		pq.heapSort(arr, n);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
}
