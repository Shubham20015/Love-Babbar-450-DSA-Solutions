package internship.trie;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortestPrefix {
	
	static class Trie{
		private Trie links[] = new Trie[26];
		private int countPrefix = 0;
		
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
		
		void decreasePrefix() {
			countPrefix--;
		}
		
		int getPrefix() {
			return countPrefix;
		}
		
	}
	
	static Trie root;
	
	static void insert(String word) {
		Trie curr = root;
		int len = word.length();
		
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if(!curr.containsKey(ch)) {
				curr.put(ch, new Trie());
			}
			curr = curr.get(ch);
			curr.increasePrefix();
		}
	}
	
	static String prefixFinder(String word) {
		Trie curr = root;
		int len = word.length();
		String ans = "";
		for(int i=0;i<len;i++) {
			char ch = word.charAt(i);
			if(curr.getPrefix() == 1) {
				break;
			}
			ans += ch;
			curr = curr.get(ch);
		}
		return ans;
	}
	
	static ArrayList<String> solve(String arr[],int n,ArrayList<String> res){
		
		for(int i=0;i<n;i++) {
			insert(arr[i]);
		}
		
		for(int i=0;i<n;i++) {
			res.add(prefixFinder(arr[i]));
		}
		
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		root = new Trie();
		int n = sc.nextInt();
		String wordArr[] = new String[n];
		
		for(int i=0;i<n;i++) {
			wordArr[i] = sc.next();
		}
		
		ArrayList<String> res = solve(wordArr,n,new ArrayList<>());
		
		for(String str : res) {
			System.out.print(str + " ");
		}
		
		sc.close();
	}

}
