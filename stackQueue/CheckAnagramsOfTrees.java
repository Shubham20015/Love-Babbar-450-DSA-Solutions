package internship.stackQueue;

import java.util.*;
import java.util.Queue;

public class CheckAnagramsOfTrees {

	public static void main(String[] args) {
		Node root1 = new Node(1);
        root1.left = new Node(3);
        root1.right = new Node(2);
        root1.right.left = new Node(5);
        root1.right.right = new Node(4);
      
        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);
        root2.left.left = new Node(4);
        root2.left.right = new Node(5);
      
         
        System.out.println(anagram(root1, root2) ? "Yes" : "No");

	}
	
	static class Node
    {
        Node left, right;
        int data;
        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
	
	static boolean anagram(Node root1,Node root2) {
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if(root1 == null || root2 == null) {
			return false;
		}
		
		Queue<Node> q1 = new LinkedList<>();
		Queue<Node> q2 = new LinkedList<>();
		
		q1.add(root1);
		q2.add(root2);
		
		while(true) {
			int len1 = q1.size(),len2 = q2.size();
			
			if(len1 != len2)
				return false;
			if(len1 == 0)
				break;
			
			ArrayList<Integer> currLevel1 = new ArrayList<>();
			ArrayList<Integer> currLevel2 = new ArrayList<>();
			
			while(len1 != 0) {
				Node temp1 = q1.poll();
				if(temp1.left != null) {
					q1.add(temp1.left);
				}
				if(temp1.right != null) {
					q1.add(temp1.right);
				}
				
				len1--;
				
				Node temp2 = q2.poll();
				if(temp2.left != null) {
					q2.add(temp2.left);
				}
				if(temp2.right != null) {
					q2.add(temp2.right);
				}
				
				currLevel1.add(temp1.data);
				currLevel2.add(temp2.data);
			}
			
			Collections.sort(currLevel1);
			Collections.sort(currLevel2);
			
			if(!currLevel1.equals(currLevel2))
				return false;
		}
		
		return true;
	}

}
