package internship.graph;

import java.util.*;

public class WordLadder {
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		List<String> wordList = new ArrayList<>();
		
		int n = sc.nextInt();
		
		for(int i=0;i<n;i++) {
			wordList.add(sc.next());
		}
		
		String beginWord = sc.next();
		String endWord = sc.next();
		
		System.out.println(ladderLength(beginWord, endWord, wordList));
		
		sc.close();
	}
	
//	TC : O((len of wordList(N))*(len of each word)*26) , SC: O(N)
	static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        
        HashSet<String> set = new HashSet<>();
        boolean isPresent = false;
        
        for(String str : wordList){
            
            if(str.equals(endWord)){
                isPresent = true;
            }
            
            set.add(str);
        }
        
        if(!isPresent) return 0;
        
        int level = 0;
        
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            
            while(size -- > 0){
                
                String curr = q.poll();
                int len = curr.length();
                
                for(int i=0;i<len;i++){
                    
                    char[] chars = curr.toCharArray();
                    
                    for(char ch='a';ch<='z';ch++){
                        
                        chars[i] = ch;
                        String temp = new String(chars);
                        
                        if(temp.equals(curr)) continue;
                        
                        if(temp.equals(endWord)) return level+1;
                        
                        if(set.contains(temp)){
                            q.add(temp);
                            set.remove(temp);
                        }
                    }
                }
            }
        }
        
        return 0;
    }
}
