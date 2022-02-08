package internship.graph;

import java.util.*;

public class CloneGraph {
	class Node {
	    public int val;
	    public List<Node> neighbors;
	    public Node() {
	        val = 0;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val) {
	        val = _val;
	        neighbors = new ArrayList<Node>();
	    }
	    public Node(int _val, ArrayList<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	}
	
	public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        
        Node visited[] = new Node[101];
        Node copy = new Node(node.val);
        dfs(node,copy,visited);
        return copy;
    }
    
    private void dfs(Node node,Node copy,Node visited[]){
        visited[copy.val] = copy;
        
        for(Node temp: node.neighbors){
            if(visited[temp.val] == null){
                Node newNode = new Node(temp.val);
                copy.neighbors.add(newNode);
                dfs(temp,newNode,visited);
            }else{
                copy.neighbors.add(visited[temp.val]);
            }
        }
    }
}
