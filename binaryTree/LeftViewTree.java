package internship.binaryTree;

import java.util.*;

public class LeftViewTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<Integer> ans = leftView(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static ArrayList<Integer> leftView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      leftview(root,ans,0);
      return ans;
    }
    
    static void leftview(Node root,ArrayList<Integer> ans,int level){
        if(root == null) return;
        if(ans.size() <= level){
            ans.add(root.data);
        }
        leftview(root.left,ans,level+1);
        leftview(root.right,ans,level+1);
    }
    
    static ArrayList<Integer> leftViewIterative(Node root,ArrayList<Integer> ans)
    {
      Queue<Node> q = new LinkedList<>();
      if(root == null)  return ans;
      q.add(root);
      while(!q.isEmpty()){
          int size = q.size();
          for(int i=1;i<=size;i++){
              Node curr = q.peek();
              q.poll();
              if(i == 1) ans.add(curr.data);
              if(curr.left != null) q.add(curr.left);
              if(curr.right != null) q.add(curr.right);
          }
      }
      
      return ans;
    }

}
