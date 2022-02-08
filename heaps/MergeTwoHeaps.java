package internship.heaps;

import java.util.Scanner;

public class MergeTwoHeaps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		int b[] = new int[m];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			b[i] = sc.nextInt();
		}
		
		int ans[] = mergeHeaps(a, b, n, m);
		
		for(int val : ans) {
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
    
    static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        int ans[] = new int[n+m];
        int cnt = 0;
        for(int i=0;i<n;i++){
            ans[cnt++] = a[i];
        }
        for(int i=0;i<m;i++){
            ans[cnt++] = b[i];
        }
        
        n += m;
        for(int i=n/2-1;i>=0;i--) {
			maxheapify(ans,n,i);
		}
        
        return ans;
    }

}
