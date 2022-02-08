package internship.greedy;

import java.util.*;

public class HuffmanEncoding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int count[] = new int[26];
		int n = str.length();
		
		for(int i=0;i<n;i++)
			count[str.charAt(i) - 'a']++;
		
		ArrayList<String> codes =  huffmanCodes(str, count, n);
		
		for(String ans : codes) {
			System.out.print(ans + " ");
		}
		
		sc.close();
	}
	
	static class Node{
        int freq;
        Node left,right;
        Node(int freq){
            this.freq = freq;
            left = right = null;
        }
    }
    
    static ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue <Node> pq = new PriorityQueue<>(new Comparator<Node> (){
            public int compare(Node n1, Node n2) {
                if (n1.freq == n2.freq) // remember this condtion
                    return 1;
                return Integer.compare(n1.freq, n2.freq);
            }
        });
        
        for(int i=0;i<N;i++){
            pq.add(new Node(f[i]));
        }
        
        while(pq.size() != 1){
            Node l = pq.poll();
            Node r = pq.poll();
            Node result = new Node(l.freq + r.freq);
            result.left = l;
            result.right = r;
            pq.add(result);
        }
        
        ArrayList<String> codes = new ArrayList<>();
        Node root = pq.poll();
        preOrder(root,"",codes);
        return codes;
    }
    
    public static void preOrder(Node root, String s,ArrayList<String> codes){
        if(root == null)
            return;
        if(root.left == null && root.right == null)
            codes.add(s);
        preOrder(root.left,s+"0",codes);
        preOrder(root.right,s+"1",codes);
    }

}
