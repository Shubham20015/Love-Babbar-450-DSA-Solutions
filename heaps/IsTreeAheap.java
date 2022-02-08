package internship.heaps;

import java.util.*;

public class IsTreeAheap {
	
	static class Node {
		int data;
		Node left, right;
		Node(int item)   {
			data = item;
			left = right = null;
		}
	}
		public static Node buildTree(String str) {
			
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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		Node root = buildTree(str);
		System.out.println(isHeap(root));
		
		sc.close();
	}
	
	static boolean isHeap(Node tree) {
        if(tree == null)
            return true;
        
        Queue<Node> q = new LinkedList<>();
        q.add(tree);
        
        int flag = 0;
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            if(curr.left != null){
                if(flag == 1)
                    return false;
                q.add(curr.left);
                if(curr.data <= curr.left.data)
                    return false;
            }else{
                flag = 1;
            }
            
            if(curr.right != null){
                if(flag == 1)
                    return false;
                q.add(curr.right);
                if(curr.data <= curr.right.data)
                    return false;
            }else{
                flag = 1;
            }
        }
        
        return true;
    }

}
