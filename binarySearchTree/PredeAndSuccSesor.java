package internship.binarySearchTree;

import java.util.*;

class Res{
	Node pre = null;
	Node succ = null;
}

public class PredeAndSuccSesor {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Res p = new Res();
		Res s = new Res();
		
		BinarySearchTree tree = new BinarySearchTree();
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			tree.insert(sc.nextInt());
		}
		
        int key = sc.nextInt();
        
        findPreSuc(tree.root,p,s,key);
        
        if(p.pre != null) {
        	System.out.println(p.pre.data + " ");
        }else {
        	System.out.println("-1 ");
        }
        
        if(s.succ != null) {
        	System.out.println(s.succ.data + " ");
        }else {
        	System.out.println("-1 ");
        }
        
		sc.close();
	}
	
	public static void findPreSuc(Node root, Res p, Res s, int key)
    {
       if(root == null) return;
       
       else if(root.data < key){
           p.pre = root;
           findPreSuc(root.right,p,s,key);
       }
       else if(root.data > key){
           s.succ = root;
           findPreSuc(root.left,p,s,key);
       }else{
           if(root.left != null)
                p.pre = pre(root);
           if(root.right != null)
                s.succ = suc(root);        
       }
    }
    
    static Node pre(Node root){
        Node temp = root.left;
        while(temp.right != null){
            temp = temp.right;
        }
        return temp;
    }
    
    static Node suc(Node root){
        Node temp = root.right;
        while(temp.left != null){
            temp = temp.left;
        }
        return temp;
    }

}
