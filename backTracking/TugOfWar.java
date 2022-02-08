package internship.backTracking;

import java.util.*;

public class TugOfWar {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
//		tugPartition(arr,n);
		solve(arr,0,new ArrayList<>(),new ArrayList<>(),0,0);
		System.out.println(ans);
		sc.close();
	}
	
	static int min_diff = Integer.MAX_VALUE;
	
	static void tugPartition(int arr[],int n) {
		boolean curr_elements[] = new  boolean[n];
		boolean sol[] = new boolean[n];
		int sum = 0;
		
		for(int i=0;i<n;i++) {
			sum += arr[i];
			curr_elements[i] = sol[i] = false;
		}
		
		tugUtil(arr,curr_elements,sol,sum,n,0,0,0);
		
		System.out.print("First Subset: ");
		for(int i=0;i<n;i++) {
			if(sol[i]) {
				System.out.print(arr[i] + " ");
			}
		}
		
		System.out.println();
		
		System.out.print("Second Subset: ");
		for(int i=0;i<n;i++) {
			if(!sol[i]) {
				System.out.print(arr[i] + " ");
			}
		}
	}
	
	static void tugUtil(int arr[],boolean curr_elements[],boolean sol[],int sum,int n,int noOfSelectedCand,int curr_sum,int curr_position) {
		if(curr_position == n) {
			return ;
		}
		
		if((curr_position - noOfSelectedCand) > n/2)
			return ;
		
		tugUtil(arr,curr_elements,sol,sum,n,noOfSelectedCand,curr_sum,curr_position+1);
		
		noOfSelectedCand++;
		curr_sum += arr[curr_position];
		curr_elements[curr_position] = true;
		
		if(noOfSelectedCand == n/2) {
			if(Math.abs(sum/2 - curr_sum) < min_diff) {
				min_diff = Math.abs(sum/2 - curr_sum);
				for (int i = 0; i < n; i++)
                    sol[i] = curr_elements[i];
			}
		}else {
			tugUtil(arr,curr_elements,sol,sum,n,noOfSelectedCand,curr_sum,curr_position+1);
		}
		
		curr_elements[curr_position] = false;
	}
	
	static String ans = "";
	
	static void solve(int arr[],int vidx,ArrayList<Integer> set1,ArrayList<Integer> set2,int setsum1,int setsum2) {
		
		int n = arr.length;
		if(vidx == n) {
			int diff = Math.abs(setsum1 - setsum2);
			if(diff < min_diff) {
				min_diff = diff;
				ans = set1 + "\n" + set2;
			}
			return ;
		}
		
		if(set1.size() < (n+1) / 2) {
			set1.add(arr[vidx]);
			solve(arr,vidx+1,set1,set2,setsum1+arr[vidx],setsum2);
			set1.remove(set1.size()-1);
		}
		
		if(set2.size() < (n+1) / 2) {
			set2.add(arr[vidx]);
			solve(arr,vidx+1,set1,set2,setsum1,setsum2+arr[vidx]);
			set2.remove(set2.size()-1);
		}
	}

}
