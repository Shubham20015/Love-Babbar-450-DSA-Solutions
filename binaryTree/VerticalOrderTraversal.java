package internship.binaryTree;

import java.util.*;

public class VerticalOrderTraversal {
	
	static class Pair{
		Node node;
		int data;
		Pair(Node temp,int data){
			this.node = temp;
			this.data = data;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		verticalTraversal(root);
		
		sc.close();

	}
	
	static void verticalTraversal(Node root) {
		if(root == null) return ;
		HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
		int hd = 0;
		
		ArrayDeque<Pair> queue = new ArrayDeque<>();
	    queue.offer(new Pair(root, hd));
	    
	    int min = 0,max = 0;
	    while(!queue.isEmpty()) {
	    	Pair temp = queue.peek();
	        queue.poll();
	        Node x = temp.node;
	        hd = temp.data;
	        
	        if(!map.containsKey(hd)){
	        	ArrayList<Integer> arr = new ArrayList<>();
                arr.add(x.data);
                map.put(hd,arr);
	        }
	        else{
	            ArrayList<Integer> arr = map.get(hd);
                arr.add(x.data);
                map.put(hd,arr);
	        }
	        
	        if(x.left != null) queue.offer(new Pair(x.left ,hd-1));
	        if(x.right != null) queue.offer(new Pair(x.right ,hd+1));
	        
	        if(min > hd)
	            min = hd;
	        else if(max < hd)
	            max = hd;
	    }
	    
	    for(int i=min;i<=max;i++) {
	    	ArrayList<Integer> ans = map.get(i);
	    	for(int val : ans) {
	    		System.out.print(val + " ");
	    	}
	    	System.out.println();
	    }
	    
//	    Top view of tree
	    for(int i=min;i<=max;i++) {
	    	int ans = map.get(i).get(0);
	    	System.out.print(ans + " ");
	    }
	    
//	    Bottom view of tree
	    for(int i=min;i<=max;i++) {
	    	ArrayList<Integer> arr = map.get(i);
	    	System.out.print(arr.get(arr.size()-1) + " ");
	    }
	}

}
