package internship.binarySearchTree;

import java.util.*;

public class ReplaceWithLeastGreater {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
//		replace(arr,n);
		
//		for(int i=0;i<n;i++) {
//			System.out.print(arr[i] + " ");
//		}
		
		ArrayList<Integer> ans = replaceGreater(arr,n);
		
		for(int val : ans) {
			System.out.print(val + " ");
		}
		
		sc.close();
	}
	
//	TC: O(N^2) SC: O(1)
	static Node root,succ;
	
	static void replace(int arr[],int n) {
		for(int i=n-1;i>=0;i--) {
			succ = null;
			root = insert(root,arr[i]);
			
			if(succ != null) arr[i] = succ.data;
			else arr[i] = -1;
		}
	}
	
	static Node insert(Node node,int data) {
		if(node == null) return new Node(data);
		
		if(data < node.data) {
			succ = node;
			node.left = insert(root.left,data);
		}else if(data > node.data) {
			node.right = insert(root.right,data);
		}
		
		return node;
	}
	
	static class Pair{
		int first,second;
		Pair(int first,int second){
			this.first = first;
			this.second = second;
		}
	}
	
//	TC: O(NlogN) SC: O(N)
	static ArrayList<Pair> array = new ArrayList<>();
	
	static ArrayList<Integer> replaceGreater(int arr[],int n) {
		for(int i=0;i<n;i++) {
			array.add(new Pair(arr[i], i));
		}
		
		Collections.sort(array,(Pair o1,Pair o2) -> o1.first - o2.first);
		
		ArrayList<Integer> indexes = nextGreaterIndex(array);
		ArrayList<Integer> res = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			res.add(-1);
		}
		
		for(int i=0;i<n;i++) {
			int x = indexes.get(array.get(i).second);
			if(x != -1) {
				res.set((array.get(i).second),arr[x]);
			}
		}
		
		return res;
	}
	
	static ArrayList<Integer> nextGreaterIndex(ArrayList<Pair> arr){
		int n = arr.size();
		Stack<Integer> stack = new Stack<>();
		ArrayList<Integer> ans = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			ans.add(-1);
		}
		
		for(int i=0;i<n;i++) {
			if(stack.isEmpty() || arr.get(i).second < stack.peek()) {
				stack.add(arr.get(i).second);
			}else {
				while(!stack.isEmpty() && arr.get(i).second > stack.peek()) {
					ans.set(stack.peek(), arr.get(i).second);
					stack.pop();
				}
				stack.add(arr.get(i).second);
			}
		}
		return ans;
	}
}
