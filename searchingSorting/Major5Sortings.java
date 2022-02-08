package internship.searchingSorting;

import java.util.*;

public class Major5Sortings {

	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        
	        int n = sc.nextInt();
	        int arr[] = new int[n];
	        
	        for(int i=0;i<n;i++){
	            arr[i] = sc.nextInt();
	        }
	        
	        quickSort(arr,0,n-1);
	        
	        for(int i=0;i<n;i++){
	            System.out.print(arr[i] + " ");
	        }
	        
	        sc.close();
	    }
	    
	    static void selectSort(int arr[]){
	        int n = arr.length;
	        for(int i=0;i<n-1;i++){
	            int k = i;
	            for(int j=i+1;j<n;j++){
	                if(arr[j] < arr[k]){
	                    k = j;
	                }
	            }
	            if(i != k){
	                int temp = arr[i];
	                arr[i] = arr[k];
	                arr[k] = temp;
	            }
	        }
	    }
	    
	    static void insertSort(int arr[]){
	        int n = arr.length;
	        for(int i=1;i<n;i++){
	            for(int j=i;j>0;j--){
	                if(arr[j] < arr[j-1]){
	                    int temp = arr[j];
	                    arr[j] = arr[j-1];
	                    arr[j-1] = temp;
	                }
	            }
	        }
	    }
	    
	    static void bubbleSort(int arr[]){
	        int n = arr.length;
	        for(int i=0;i<n-1;i++){
	            boolean swap = false;
	            for(int j=0;j<(n-i-1);j++){
	                if(arr[j] > arr[j+1]){
	                    
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                    
	                    swap = true;
	                }
	            }
	                if(!swap)
	                    break;
	        }
	    }
	    
	    static void mergeSort(int arr[],int start,int end){
	        if(start < end){
	            int mid = start + (end-start)/2;
	            mergeSort(arr,start,mid);
	            mergeSort(arr,mid+1,end);
	            merge(arr,start,mid,end);
	        }
	    }
	    
	    static void merge(int arr[],int start,int mid,int end){
	        int temp[] = new int[end - start + 1];
	        
	        int i=start,j=mid+1;
	        int k = 0;
	        
	        while(i <= mid && j <= end){
	            if(arr[i] < arr[j]){
	                temp[k++] = arr[i];
	                i++;
	            }else{
	                temp[k++] = arr[j];
	                j++;
	            }
	        }
	        
	        while(i <= mid){
	            temp[k++] = arr[i];
	            i++;
	        }
	        
	         while(i <= mid && j <= end){
	            temp[k++] = arr[j];
	            j++;
	        }
	        
	        for(i = start; i <= end; i++) {
			    arr[i] = temp[i - start];
		    }
	    }
	    
	    static void quickSort(int arr[],int start,int end){
	        if(start < end){
	            int pi = partition(arr,start,end);
	            quickSort(arr,start,pi-1);
	            quickSort(arr,pi+1,end);
	        }
	    }
	    
	    static int partition(int arr[],int low,int high){
	        int pivot = arr[high];
	        int i = low - 1;
	        
	        for(int j=low;j<high;j++){
	            if(arr[j] < pivot){
	                i++;
	                int temp = arr[i];
	                arr[i] = arr[j];
	                arr[j] = temp;
	            }
	        }
	        
	        int temp = arr[i+1]; 
			arr[i+1] = arr[high]; 
			arr[high] = temp;
			
			return i+1;
	    }
}
