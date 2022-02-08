package internship.binarySearchTree;

class Node{
	int data;
	Node left,right;
	Node(int data){
		this.data = data;
		right = left = null;
	}
}

public class BinarySearchTree {
	
	Node root;
	
	BinarySearchTree(){
		root = null;
	}
	
	public void insert(int data) {
		root = insertKey(root,data);
	}
	
	private Node insertKey(Node root,int data) {
		if(root == null)
			return new Node(data);
		if(data < root.data) {
			root.left = insertKey(root.left,data);
		}else if(data > root.data) {
			root.right = insertKey(root.right,data);
		}
		
		return root;
	}
	
	public Node search(Node root,int data) {
		if(root == null || root.data == data)
			return root;
		
		if(root.data < data) {
			return search(root.right,data);
		}
		
		return search(root.left,data);
	}
	
	public void delete(int data) {
		root = deleteKey(root,data);
	}
	
	private Node deleteKey(Node root,int data) {
		if(root == null)
			return root;
		else if(root.data < data) 
			root.right = deleteKey(root.right,data);
		else if(root.data > data) 
			root.left = deleteKey(root.left,data);
		else {
			if(root.right == null) {
				return root.left;
			}
			else if(root.left == null) {
				return root.right;
			}
			else {
				root.data = findMin(root);
				root.right = deleteKey(root.right,root.data);
			}
		}
		return root;
	}
	
	private int findMin(Node root) {
		Node curr = root.right;
		while(curr.left != null) {
			curr = curr.left;
		}
		
		return curr.data;
	}
	
	public void inorder() { 
		Node curr = root;
		inorderRec(curr); 
	}
	 
    
    private void inorderRec(Node root)
    {
    	
        if (root == null) {
        	return ;
        }
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
    }
    
    public static void main(String args[]) {
    	BinarySearchTree tree = new BinarySearchTree();
    	
    	tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        
        tree.inorder();
        Node x = tree.search(tree.root, 50);
        if(x != null) {
        	System.out.println("Element found in tree");
        }else {
        	System.out.println("Element not present in tree");
        }
        
        System.out.println();
        tree.delete(40);
        tree.inorder();
    }
}
