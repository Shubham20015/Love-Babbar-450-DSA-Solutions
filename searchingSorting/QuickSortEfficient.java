package internship.searchingSorting;

import java.util.Scanner;

public class QuickSortEfficient {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[]= new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		quickSort(arr,0,n-1);
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		
		sc.close();
	}
	
	static class Partition {
		private int left,right;
		Partition(int left,int right){
			this.left = left;
			this.right = right;
		}
	}
	
	static void quickSort(int arr[],int begin,int end) {
		if(end <= begin)
			return;
		Partition pivot = partition(arr, begin, end);
		quickSort(arr,begin,pivot.left-1);
		quickSort(arr,pivot.right+1,end);
	}
	
	static Partition partition(int arr[],int begin,int end) {
		int lt = begin,current = begin,gt = end;
		int pivot = arr[begin];
		while(current <= gt) {
			int compareCurrent = compare(arr[current] - pivot);
			switch(compareCurrent) {
				case -1:
					swap(arr, current++, lt++);
					break;
				case 0:
					current++;
					break;
				case 1:
					swap(arr, current, gt--);
					break;
			}
		}
		
		return new Partition(lt,gt);
	}
	
	static int compare(int value) {
		if(value == 0)
			return 0;
		return value > 0 ?1:-1;
	}
	
	static void swap(int arr[],int i,int j) {
		if(i != j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
}
