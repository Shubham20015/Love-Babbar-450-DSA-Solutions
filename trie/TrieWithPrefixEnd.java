package internship.trie;

import java.util.Scanner;

public class TrieWithPrefixEnd {
	
	static class Trie{
		private Trie links[] = new Trie[26];
		private int countPrefix = 0;
		private int countEndWith = 0;
		
		boolean containsKey(char ch) {
			return links[ch-'a'] != null;
		}
		
		Trie get(char ch) {
			return links[ch-'a'];
		}
		
		void put(char ch,Trie node) {
			links[ch-'a'] = node;
		}
		
		void increasePrefix() {
			countPrefix++;
		}
		
		void increaseEnd() {
			countEndWith++;
		}
		
		void decreasePrefix() {
			countPrefix--;
		}
		
		void decreaseEnd() {
			countEndWith--;
		}
		
		int getPrefix() {
			return countPrefix;
		}
		
		int getEnd() {
			return countEndWith;
		}
		
	}
	
	static Trie root;
	
	static void insert(String word) {
		int n = word.length();
		Trie curr = root;
		for(int i=0;i<n;i++) {
			char ch = word.charAt(i);
			if(!curr.containsKey(ch)) {
				curr.put(ch, new Trie());
			}
			curr = curr.get(ch);
			curr.increasePrefix();
		}
		curr.increaseEnd();
	}
	
	static int countWordsEqualTo(String word) {
		int n = word.length();
		Trie curr = root;
		for(int i=0;i<n;i++) {
			char ch = word.charAt(i);
			if(curr.containsKey(ch))
				curr = curr.get(ch);
			else 
				return 0;
		}
		return curr.getEnd();
	}
	
	static int countWordsStartsWith(String word) {
		int n = word.length();
		Trie curr = root;
		for(int i=0;i<n;i++) {
			char ch = word.charAt(i);
			if(curr.containsKey(ch))
				curr = curr.get(ch);
			else 
				return 0;
		}
		return curr.getPrefix();
	}
	
	static void erase(String word) {
		int n = word.length();
		Trie curr = root;
		for(int i=0;i<n;i++) {
			char ch = word.charAt(i);
			if(curr.containsKey(ch)) {
				curr = curr.get(ch);
				curr.decreasePrefix();
			}
			else 
				return ;
		}
		curr.decreaseEnd();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		root = new Trie();
		
		int n = sc.nextInt();
		
		while(n-->0) {
			int x = sc.nextInt();
			String word = sc.next();
			if(x == 1) {
				insert(word);
				System.out.println("Successfully inserted");
			}else if(x == 2) {
				int count = countWordsEqualTo(word);
				if(count == 0) {
					System.out.println(word + " is not present in trie");
				}else {
					System.out.println(count + " words similar to " + word + " present in trie");
				}
			}else if(x == 3) {
				int count = countWordsStartsWith(word);
				if(count == 0) {
					System.out.println(word + " is not present in trie");
				}else {
					System.out.println(count + " words starts with similar to " + word + " present in trie");
				}
			}else {
				System.exit(0);
			}
		}
		
		sc.close();
	}

}
