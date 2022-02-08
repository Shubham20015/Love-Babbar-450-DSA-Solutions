package internship.binarySearchTree;

import java.util.*;

public class KthLargestElement {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		BinarySearchTree tree = new BinarySearchTree();
    	
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			tree.insert(sc.nextInt());
		}
		
        tree.inorder();
        System.out.println(kthLargest(tree.root,k));
        
		sc.close();
	}
    
//  TC: O(N) SC:O(N)
    static int kthLargestNum(Node root,int k)
    {
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        if(k > arr.size()) return -1;
        return arr.get(arr.size()-k);
    }
    
    static void inorder(Node root,ArrayList<Integer> arr){
        if(root == null) return;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }
    
    static int x = 1;
//  TC: O(H+K) SC:O(1)
  static int kthLargest(Node root,int k)
  {
      if(root == null) return -1;
      int ans = -1;
      ans = kthLargest(root.right,k);
      if(ans != -1) return ans;
      if(x == k){
          return root.data;
      }else{
          x++;
      }
      ans = kthLargest(root.left,k);
      if(ans != -1) return ans;
      return -1;
  }
}
