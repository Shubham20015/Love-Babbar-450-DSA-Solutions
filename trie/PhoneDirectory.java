package internship.trie;

import java.util.*;

public class PhoneDirectory {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String contact[] = new String[n];
		
		for(int i=0;i<n;i++) {
			contact[i] = sc.next();
		}
		sc.nextLine();
		String query = sc.next();
		
		ArrayList<ArrayList<String>> res = displayContacts(n, contact, query);
		
		for(ArrayList<String> temp : res) {
			for(String str : temp) {
				System.out.print(str + " ");
			}
			System.out.println();
		}
		
		sc.close();
	} 
	
		static ArrayList<ArrayList<String>> displayContacts(int n, String contact[], String s)
		{
			root = new Trie();
			constructTrie(contact,n);
			return solve(s);
		}
	
		static class Trie{
	       Trie[] links = new Trie[26];
	       ArrayList<String> list = new ArrayList<>();
	       
	       boolean containsKey(char ch){
	           return links[ch-'a'] != null;
	       }
	       
	       void put(char ch,Trie node){
	           links[ch-'a'] = node;
	       }
	       
	       Trie get(char ch){
	           return links[ch-'a'];
	       }
	    }
	    
	    static Trie root;
	    
	    static void insertinTrie(String word){
	        int len = word.length();
	        Trie curr = root;
	        for(int i=0;i<len;i++){
	            char ch = word.charAt(i);
	            if(!curr.containsKey(ch)){
	                curr.put(ch,new Trie());
	            }
	            curr = curr.get(ch);
	            curr.list.add(word);
	        }
	    }
	    
	    static void constructTrie(String contact[],int n){
	        HashSet<String> set = new HashSet<>();
	        for(int i=0;i<n;i++){
	            if(!set.contains(contact[i])){
	                insertinTrie(contact[i]);
	                set.add(contact[i]);
	            }
	        }
	    }
	    
	    static ArrayList<ArrayList<String>> solve(String s){
	        ArrayList<ArrayList<String>> ans = new ArrayList<>();
	        Trie curr = root;
	        int n = s.length();
	        
	        for(int i=0;i<n;i++){
	            char ch = s.charAt(i);
	            if(!curr.containsKey(ch)){
	                while(i++ < n){
	                    ans.add(new ArrayList<String>(Arrays.asList("0")));
	                }
	            }else{
	                curr = curr.get(ch);
	                ArrayList<String> temp = curr.list;
	                Collections.sort(temp);
	                ans.add(temp);
	            }
	        }
	        return ans;
	    }
}
