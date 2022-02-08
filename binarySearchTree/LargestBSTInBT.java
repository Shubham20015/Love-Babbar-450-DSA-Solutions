package internship.binarySearchTree;

import java.util.Scanner;

public class LargestBSTInBT {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(largestBst(root));
		
		sc.close();

	}
	
	static class NodeValue{
	    int maxNode,minNode,maxSize;
	    NodeValue(int minNode,int maxNode,int maxSize){
	        this.maxNode = maxNode;
	        this.minNode = minNode;
	        this.maxSize = maxSize;
	    }
	}
	
	static int largestBst(Node root)
    {
       return solve(root).maxSize;
    }
    
    static NodeValue solve(Node root){
        if(root == null){
            return new NodeValue(Integer.MAX_VALUE,Integer.MIN_VALUE,0);
        }
        
        NodeValue left = solve(root.left);
        NodeValue right = solve(root.right);
        
        if(root.data > left.maxNode && root.data < right.minNode){
            return new NodeValue(Math.min(root.data, left.minNode),
            Math.max(root.data, right.maxNode),1 + left.maxSize + right.maxSize);
        }
        
        return new NodeValue(Integer.MIN_VALUE,Integer.MAX_VALUE,Math.max(left.maxSize,right.maxSize));
    }

}
