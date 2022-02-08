package internship.binaryTree;

import java.util.*;

class Node {
	int data;
	Node left, right;
	Node(int item)    {
		data = item;
		left = right = null;
	}
}

public class BinaryTree {
	public Node buildTree(String str) {
		
		 if(str.length()==0 || str.charAt(0)=='N'){
	            return null;
	     }
	        
	     String ip[] = str.split(" ");
	        
	     Node root = new Node(Integer.parseInt(ip[0]));
	     
	     Queue<Node> queue = new LinkedList<>(); 
	        
	     queue.add(root);
	        
	     int i = 1;
	     while(queue.size() > 0 && i < ip.length) {
	            
	            Node currNode = queue.peek();
	            queue.remove();
	                
	            String currVal = ip[i];
	                
	            // If the left child is not null
	            if(!currVal.equals("N")) {
	                currNode.left = new Node(Integer.parseInt(currVal));
	                queue.add(currNode.left);
	            }
	                
	            // For the right child
	            i++;
	            if(i >= ip.length)
	                break;
	                
	            currVal = ip[i];
	                
	            // If the right child is not null
	            if(!currVal.equals("N")) {
	                currNode.right = new Node(Integer.parseInt(currVal));
	                queue.add(currNode.right);
	            }
	            
	            i++;
	        }
	        
	        return root;
	}
}
