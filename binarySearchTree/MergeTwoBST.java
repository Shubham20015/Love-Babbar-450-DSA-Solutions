package internship.binarySearchTree;

import java.util.*;

public class MergeTwoBST {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		BinarySearchTree tree1 = new BinarySearchTree();
		BinarySearchTree tree2 = new BinarySearchTree();
		BinarySearchTree tree = new BinarySearchTree();
		
		for(int i=0;i<n;i++) {
			tree1.insert(sc.nextInt());
		}
		
		for(int i=0;i<m;i++) {
			tree2.insert(sc.nextInt());
		}
		
		ArrayList<Integer> ans1 = merge(tree1.root,tree2.root);
		
		for(int val : ans1) {
			tree.insert(val);
		}
		
		tree.inorder();
		ArrayList<Integer> ans2 = merge(tree1.root,tree2.root);
		
		for(int val : ans2) {
			System.out.print(val + " ");
		}
		
		
		sc.close();
	}
	
//	TC: O(m+n) , SC: O(h1+h2)
	static void utility(Node root,Stack<Node> stack) {
		Node curr = root;
		while(curr != null) {
			stack.add(curr);
			curr = curr.left;
		}
	}
	
	static List<Integer> mergeBST(Node root1,Node root2){
		List<Integer> arr = new ArrayList<>(); 
		Stack<Node> stack1 = new Stack<>();
		Stack<Node> stack2 = new Stack<>();
		utility(root1,stack1);
		utility(root2,stack2);
		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			Node curr1 = stack1.peek();
			Node curr2 = stack2.peek();
			if(curr1.data < curr2.data) {
				arr.add(curr1.data);
				stack1.pop();
				utility(curr1.right,stack1);
			}else if(curr1.data > curr2.data) {
				arr.add(curr2.data);
				stack2.pop();
				utility(curr2.right,stack2);
			}else {
				arr.add(curr1.data);
				stack1.pop();
				stack2.pop();
				utility(curr1.right,stack1);
				utility(curr2.right,stack2);
			}
		}
		
		while(!stack1.isEmpty()) {
			Node curr = stack1.peek();
			arr.add(curr.data);
			stack1.pop();
			utility(curr.right,stack1);
		}
		
		while(!stack2.isEmpty()) {
			Node curr = stack2.peek();
			arr.add(curr.data);
			stack2.pop();
			utility(curr.right,stack2);
		}
		return arr;
	}
	
//	TC: O(m+n) , SC: O(m+n)
	static ArrayList<Integer> merge(Node root1,Node root2)
    {
        ArrayList<Integer> arr1 = inorderStore(root1);
        ArrayList<Integer> arr2 = inorderStore(root2);
        ArrayList<Integer> ans = merge(arr1,arr2);
        return ans;
    }
    
    static ArrayList<Integer> merge(ArrayList<Integer> arr1,ArrayList<Integer> arr2){
        ArrayList<Integer> arr3 = new ArrayList<>();
        int i = 0,j = 0;
        int n = arr1.size(),m = arr2.size();
        while(i < n && j < m){
            if(arr1.get(i) < arr2.get(j)){
                arr3.add(arr1.get(i));
                i++;
            }else{
                arr3.add(arr2.get(j));
                j++;
            }
        }
        
        while(i < n){
            arr3.add(arr1.get(i));
            i++;
        }
        
        while(j < m){
            arr3.add(arr2.get(j));
            j++;
        }
        
        return arr3;
    }
    
    static ArrayList<Integer> inorderStore(Node root){
        ArrayList<Integer> arr = new ArrayList<>();
        inorder(root,arr);
        return arr;
    }
    
    static void inorder(Node root,ArrayList<Integer> arr){
        if(root == null) return ;
        inorder(root.left,arr);
        arr.add(root.data);
        inorder(root.right,arr);
    }

}
