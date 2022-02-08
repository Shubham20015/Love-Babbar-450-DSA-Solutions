package internship.binaryTree;

import java.util.*;

public class PrintAllKSumPaths {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		String str = sc.next();
//		BinaryTree tree = new BinaryTree();
//		Node root = tree.buildTree(str);
		
		int k = sc.nextInt();
		
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
		
		sumPaths(root,k);
		
		sc.close();

	}
	
	static ArrayList<Integer> list = new ArrayList<>();
	static int sum = 0;
	
	static void sumPaths(Node root,int k) {
		if(root == null) return;
		
		list.add(root.data);
		
		sumPaths(root.left,k);
		sumPaths(root.right,k);
		
		int sum = 0;
		for(int i=list.size()-1;i>=0;i--) {
			sum += list.get(i);
			if(sum == k) {
				for(int j = i;j<list.size();j++) {
					System.out.print(list.get(j) + " ");
				}
				System.out.println();
			}
		}
		
			
		list.remove(list.size() - 1);	
	}
}
