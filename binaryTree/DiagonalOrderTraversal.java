package internship.binaryTree;

import java.util.*;

public class DiagonalOrderTraversal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<ArrayList<Integer>> ans = traversal(root);
		
		for(ArrayList<Integer> val: ans) {
			for(int element : val) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static ArrayList<ArrayList<Integer>> traversal(Node root) {
		
		ArrayDeque<Node> queue = new ArrayDeque<>();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			ArrayList<Integer> comp = new ArrayList<>();
			
			while(size -- > 0) {
				Node temp = queue.peek();
				queue.poll();
				while(temp != null) {
					comp.add(temp.data);
					if(temp.left != null) queue.add(temp.left);
					temp = temp.right;
				}
			}
			arr.add(comp);
		}
		
		return arr;
	}

}
