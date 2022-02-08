package internship.binarySearchTree;

import java.util.Scanner;

public class CheckIfPreorderIsValid {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(canRepresentBST(arr, n));
		
		sc.close();

	}
	
	static int preIndex = 0;
    
    static int canRepresentBST(int arr[], int n) {
        constructTree(arr,n,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return preIndex == n ? 1:0;
    }
    
    static void constructTree(int arr[],int n,int min,int max){
        if(preIndex >= n) return ;
        
        if(min <= arr[preIndex] && arr[preIndex] <= max){
            int rootData = arr[preIndex];
            preIndex++;
            
            constructTree(arr,n,min,rootData);
            constructTree(arr,n,rootData,max);
        }
    }
}
