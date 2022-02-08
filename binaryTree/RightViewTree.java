package internship.binaryTree;

import java.util.*;

public class RightViewTree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		ArrayList<Integer> ans = rightView(root);
		
		for(int val: ans) {
			System.out.println(val);
		}
		
		sc.close();

	}
	
	static ArrayList<Integer> rightView(Node root)
    {
      ArrayList<Integer> ans = new ArrayList<>();
      rightview(root,ans,0);
      return ans;
    }
    
    static void rightview(Node root,ArrayList<Integer> ans,int level){
        if(root == null) return;
        if(level == ans.size()){
            ans.add(root.data);
        }
        rightview(root.right,ans,level+1);
        rightview(root.left,ans,level+1);
    }
    
    static ArrayList<Integer> rightView(Node root,ArrayList<Integer> ans)
    {
      Queue<Node> q = new LinkedList<>();
      if(root == null)  return ans;
      q.add(root);
      while(!q.isEmpty()){
          int size = q.size();
          for(int i=1;i<=size;i++){
              Node curr = q.peek();
              q.poll();
              if(i == size) ans.add(curr.data);
              if(curr.left != null) q.add(curr.left);
              if(curr.right != null) q.add(curr.right);
          }
      }
      
      return ans;
    }
}
