package internship.binaryTree;

import java.util.*;

public class KthAncestor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		sc.nextLine();
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int node = sc.nextInt();
		
		findKthAncestor(root,k,node);
		
		System.out.println(findKthAncestor(root,n,k,node));
		
		sc.close();
	}
	
	static void generateArray(Node root,int ancestors[]) {
		
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		ancestors[root.data] = -1;
		
		while(!queue.isEmpty()) {
			Node temp = queue.peek();
			queue.poll();
			
			if(temp.left != null) {
				ancestors[root.left.data] = root.data;
				queue.add(temp.left);
			}
			
			if(temp.right != null) {
				ancestors[root.right.data] = root.data;
				queue.add(temp.right);
			}
		}
	}
	
//	TC: O(N) , SC: O(N)
	static int findKthAncestor(Node root,int n,int k,int node) {
		int ancestors[] = new int[n+1];
		
		generateArray(root,ancestors);
		
		int count = 0;
		
		while(node != -1) {
			node = ancestors[node];
			count++;
			
			if(count == k) break;
		}
		
		return node;
	}
	
//	TC: O(N) , SC: O(1)
	static Node findKthAncestor(Node root,int k,int node) {
		if(root == null) return null;
		
		if(root.data == node || findKthAncestor(root.left,k,node) != null || findKthAncestor(root.right,k,node) != null) {
			if(k > 0) {				
				k--;
			}
			
			else if(k == 0) {
				System.out.println(root.data);
				return null;
			}
			
			return root;
		}
		
		return null;
	}
}
