package internship.binaryTree;

import java.util.Scanner;

public class SumFromRootToLeaf {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		BinaryTree tree = new BinaryTree();
		Node root = tree.buildTree(str);
		
		System.out.println(sumOfLongRootToLeafPath(root));
		
		sc.close();
	}
	
	static int ans = Integer.MIN_VALUE,maxlevel = 0;
	
    static public int sumOfLongRootToLeafPath(Node root)
    {
        sumTree(root,1,0);
        return ans;
    }
    
    static void sumTree(Node root,int level,int sum){
        if(root == null) return ;
        sum += root.data;
        if(level > maxlevel){
            ans = sum;
            maxlevel = level;
        }
        if(level == maxlevel){
            ans = Math.max(ans,sum);
        }
        sumTree(root.left,level+1,sum);
        sumTree(root.right,level+1,sum);
    }

}
