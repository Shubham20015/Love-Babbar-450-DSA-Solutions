package internship.trie;

import java.util.Scanner;

class Node{
	Node links[] = new Node[26];
	boolean flag = false;
	
	boolean containsKey(char ch) {
		return links[ch-'a'] != null;
	}
	
	Node get(char ch) {
		return links[ch-'a'];
	}
	
	void put(char ch,Node node) {
		links[ch-'a'] = node;
	}
	
	void setEnd() {
		flag = true;
	}
	
	boolean isEnd() {
		return flag;
	}
}

public class Trie {
	private Node root;
	
	Trie(){
		root = new Node();
	}
	
	public void insert(String word) {
		Node newNode = root;
		int n = word.length(); 
		for(int i=0;i<n;i++) {
			char ch = word.charAt(i);
			if(!newNode.containsKey(ch)) {
				newNode.put(ch, new Node());
			}
			newNode = newNode.get(ch);
		}
		
		newNode.setEnd();
	}
	
	public boolean search(String word) {
		Node temp = root;
		int n = word.length(); 
		for(int i=0;i<n;i++) {
			char ch = word.charAt(i);
			if(!temp.containsKey(ch)) {
				return false;
			}
			temp = temp.get(ch);
		}
		
		return temp.isEnd();
	}
	
	public boolean startsWith(String prefix) {
		Node temp = root;
		int n = prefix.length(); 
		for(int i=0;i<n;i++) {
			char ch = prefix.charAt(i);
			if(!temp.containsKey(ch)) {
				return false;
			}
			temp = temp.get(ch);
		}
		
		return true;
	}
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Trie root = new Trie();
		int queries = sc.nextInt();
		
		while(queries-->0) {
			int x = sc.nextInt();
			String word = sc.next();
			if(x == 1) {
				root.insert(word);
				System.out.println("Successfully inserted");
			}else if(x == 2) {
				boolean present = root.search(word);
				if(present) {
					System.out.println(word + " is present in trie");
				}else {
					System.out.println(word + " is not present in trie");
				}
			}else if(x == 3) {
				boolean starts = root.startsWith(word);
				if(starts) {
					System.out.println("Few Words starts with this prefix " + word);
				}else {
					System.out.println("No Word starts with this prefix " + word);
				}
			}else {
				System.exit(0);
			}
		}
		
		sc.close();
	}

}
