package internship.binaryTree;

import java.util.*;

public class PrintKSumPaths {

	public static void main(String[] args) {
		Node root = new Node(1);
        root.left = new Node(3);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.left.right.left = new Node(1);
        root.right = new Node(-1);
        root.right.left = new Node(4);
        root.right.left.left = new Node(1);
        root.right.left.right = new Node(2);
        root.right.right = new Node(5);
        root.right.right.right = new Node(2);
        
        printKpaths(root,5);
	}
	
	static class Node{
		int data;
		Node left,right;
		Node(int data){
			this.data = data;
			left = right = null;
		}
	}
	
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void printKpaths(Node root,int k) {
		if(root == null) return ;
		list.add(root.data);
		printKpaths(root.left,k);
		printKpaths(root.right,k);
		
		int sum = 0,n = list.size();
		for(int i=n-1;i>=0;i--) {
			sum += list.get(i);
			
			if(k == sum) {
				for(int j=i;j<n;j++) {
					System.out.print(list.get(j) + " ");
				}
				System.out.println();
			}
		}
		
		list.remove(n-1);
	}

}
