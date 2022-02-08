package internship.binaryTree;

import java.util.*;

public class PrintAllDuplicatesInTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<Node> ans = printAllDups(root);
		
		for(Node head : ans) {
			PreorderTraversal.preOrder(head);
		}
		
		sc.close();
	}
	
	static HashMap<String,Integer> map = new HashMap<>();
    static ArrayList<Node> arr = new ArrayList<>();
    
    static ArrayList<Node> printAllDups(Node root)
    {
       solve(root);   
       return arr;
    }
    
    static String solve(Node root){
        if(root == null) return "*";
        String x = solve(root.left);
        String y = solve(root.right);
        String str = root.data + " " + x + " " + y;
        map.put(str, map.getOrDefault(str, 0)+ 1);
        if(map.get(str) == 2){
            arr.add(root);
        }
        return str;
    }
}
