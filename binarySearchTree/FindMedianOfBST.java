package internship.binarySearchTree;

import java.util.Scanner;

public class FindMedianOfBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		BinarySearchTree tree = new BinarySearchTree();
		
		for(int i=0;i<n;i++) {
			int x = sc.nextInt();
			tree.insert(x);
		}
		
		tree.inorder();
		Node node = tree.root;
		System.out.println("\nMedian of all node values: " + median(node));
		
		sc.close();
	}
	
	static int countNodes(Node root) {
		Node curr = root;
		int count = 0;
		
		if (root == null) 
	        return count; 
		
		while(curr != null) {
			if(curr.left == null) {
				count++;
				curr = curr.right;
			}
			else {
				Node prev = curr.left;
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = curr;
                    curr = curr.left;
				}else {
					prev.right = null;
					count++;
					curr = curr.right;
				}
			}
		}
		
		return count;
	}
	
	static int median(Node root) {
		
		if (root == null) 
	        return 0;
		
		Node curr = root,prevNode = null;
		int count = countNodes(root);
		int currCount = 0;
		
		while(curr != null) {
			if(curr.left == null) {
				currCount++;
				
//				odd case
				if(count % 2 != 0 && currCount == (count+1)/2) {
					return prevNode.data;
				}
//				even case
				if(count % 2 == 0 && currCount == (count/2)+1) {
					return (prevNode.data + curr.data)/2;
				}
				
				prevNode = curr;
				curr = curr.right;
			}
			else {
				Node prev = curr.left;
				while(prev.right != null && prev.right != curr) {
					prev = prev.right;
				}
				if(prev.right == null) {
					prev.right = curr;
                    curr = curr.left;
				}else {
					prev.right = null;
					prevNode = prev;
					currCount++;
					
//					odd case
					if(count % 2 != 0 && currCount == (count+1)/2) {
						return curr.data;
					}
//					even case
					if(count % 2 == 0 && currCount == (count/2)+1) {
						return (prevNode.data + curr.data)/2;
					}
					prevNode = curr;
					curr = curr.right;
				}
			}
		}
		
		return -1;
	}

}
