package internship.trie;

import java.util.*;

public class AnagramTogether {
	
	static class Trie{
		Trie links[] = new Trie[26];
		LinkedList<Integer> head = new LinkedList<>();
		boolean flag = false;
		
		boolean containsKey(char ch) {
			return links[ch-'a'] != null;
		}
		
		Trie get(char ch) {
			return links[ch-'a'];
		}
		
		void put(char ch,Trie node) {
			links[ch-'a'] = node;
		}
		
		void setEnd() {
			flag = true;
		}
		
		boolean isEnd() {
			return flag;
		}
	}
	
	static Trie root;
	
	static void printAnagrams(String arr[],int n) {
		for(int i=0;i<n;i++) {
			char buffer[] = arr[i].toCharArray();
			Arrays.sort(buffer);
			insert(new String(buffer),i);
		}
		
		printAnagramsUtil(root,arr);
	}
	
	static void insert(String word,int index) {
		int len = word.length();
		Trie curr = root;
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if(!curr.containsKey(ch)) {
				curr.put(ch, new Trie());
			}
			curr = curr.get(ch);
		}
		curr.setEnd();
		curr.head.add(index);
	}
	
	static void printAnagramsUtil(Trie root,String arr[]) {
		if(root == null)
			return ;
		
		if(root.isEnd()) {
			for(int index: root.head)
                System.out.print(arr[index] + " ");
		}
		
		for (int i=0;i<26;i++)
            printAnagramsUtil(root.links[i], arr);
	}
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		root = new Trie();
		
		int n = sc.nextInt();
		String arr[] = new String[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.next();
		}
		
		printAnagrams(arr,n);
		
		sc.close();
	}
}
