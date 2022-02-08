package internship.binarySearchTree;

import java.util.*;

public class CountPairsFromTwoRoots {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt();
		
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		
		for(int i=0;i<n;i++) {
			tree1.insert(sc.nextInt());
		}
		
		for(int i=0;i<m;i++) {
			tree2.insert(sc.nextInt());
		}
		
		System.out.println(countPairs(tree1.root,tree2.root,x));
		
		sc.close();
	}
	
	static int countPairs(Node root1, Node root2, int x)
	{
		ArrayList<Integer> arr1 = new ArrayList<>();
		ArrayList<Integer> arr2 = new ArrayList<>();
		inorder(root1,arr1);
		inorder(root2,arr2);
		int n = arr1.size();
		int m  = arr2.size();
		int i = 0,j = m-1;
		int count = 0;
		while(i < n && j >= 0){
		    if(arr1.get(i) + arr2.get(j) == x){
		        count++;
		        i++;
		        j--;
		    }else if(arr1.get(i) + arr2.get(j) > x){
		        j--;
		    }
		    else{
		        i++;
		    }
		}
		
		return count;
	}
	
	static void inorder(Node root,ArrayList<Integer> arr){
	    if(root == null) return;
	    inorder(root.left,arr);
	    arr.add(root.data);
	    inorder(root.right,arr);
	}

}
