package internship.trie;

import java.util.Scanner;

public class WordBreak {
	
	static class Node{
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

	static class Trie {
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
		
		public boolean wordBreak(String query) {
			int size = query.length();
			
			if(size == 0)
				return true;
			
			for(int i=1;i<=size;i++) {
				if(search(query.substring(0, i)) && wordBreak(query.substring(i, size)))
					return true;
			}
			
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Trie trie = new Trie();
		
		int n = sc.nextInt();
		String dict[] = new String[n];
		
		for(int i=0;i<n;i++) {
			dict[i] = sc.next();
			trie.insert(dict[i]);
		}
		
		sc.nextLine();
		
		String query = sc.next();
		
		System.out.println(trie.wordBreak(query) ? "Yes":"No");
		
		sc.close();
	}

}
