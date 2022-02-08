package internship.binarySearchTree;

import java.util.*;

public class Nconflicts {
	
	static class Interval{
		int low,high;
		Interval(int low,int high){
			this.low = low;
			this.high = high;
		}
	}
	
	static class ITNode{
		Interval i;
		int max;
		ITNode left,right;
	}
	
	static ITNode newNode(Interval i) {
		ITNode temp = new ITNode();
		temp.i = i;
		temp.max = i.high;
		temp.left = temp.right = null;
		return temp;
	}
	
	static ITNode insert(ITNode root,Interval i) {
		if(root == null)
			return newNode(i);
		
		int l = root.i.low;
		
		if(i.low < l) {
			root.left = insert(root.left,i);
		}else {
			root.right = insert(root.right,i);
		}
		
		if(root.max < i.high) {
			root.max = i.high;
		}
		
		return root;
	}
	
	static boolean doOverlap(Interval i1,Interval i2) {
		if(i1.low < i2.high && i2.low < i1.high) {
			return true;
		}
		return false;
	}
	
	static Interval overlapSearch(ITNode root,Interval i) {
		if(root == null) return null;
		
		if(doOverlap(root.i,i)) {
			return root.i;
		}
		
		if(root.left != null && root.left.max >= i.low) {
			return overlapSearch(root.left,i);
		}
		
		return overlapSearch(root.right,i);
	}
	
	static void printConflicts(Interval arr[],int n) {
		ITNode root = null;
		root = insert(root,arr[0]);
		
		for(int i=1;i<n;i++) {
			Interval res = overlapSearch(root, arr[i]);
			
			if(res !=  null) {
				System.out.print("[" + arr[i].low + "," + arr[i].high + "] Conflicts with [" + res.low + "," + res.high + "]\n");
			}
			
			root = insert(root,arr[i]);
		}
	}
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		Interval arr[] = new Interval[n];
		
		for(int i=0;i<n;i++) {
			int low = sc.nextInt();
			int high = sc.nextInt();
			arr[i] = new Interval(low,high);
		}
		
		printConflicts(arr,n);
		
		sc.close();
	}
	
}
