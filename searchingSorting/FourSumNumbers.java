package internship.searchingSorting;

import java.util.*;

public class FourSumNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		ArrayList<ArrayList<Integer>> ans = fourSum(arr,sum);
		
		for(ArrayList<Integer> val : ans) {
			for(int element : val) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	public static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int sum) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n-3;i++){
            if (i != 0 && arr[i] == arr[i - 1]) continue;
            for(int j=i+1;j<n-2;j++){
                 if (j != i + 1 && arr[j] == arr[j - 1]) continue;
                int k = j+1,q = n-1;
                while(k < q){
                    int x = arr[i] + arr[j] + arr[k] + arr[q];
                    if(x == sum){
                        ArrayList<Integer> temp = new ArrayList<>();
                        temp.add(arr[i]);
                        temp.add(arr[j]);
                        temp.add(arr[k]);
                        temp.add(arr[q]);
                        list.add(temp);
                        k++;
                        q--;
                        while (k < q && arr[k] == arr[k - 1]) k++;
                        while (k < q && arr[q] == arr[q + 1]) q--;
                    }else if(x < sum){
                        k++;
                    }else{
                        q--;
                    }
                }
            }
        }
        
        return list;
    }
}
