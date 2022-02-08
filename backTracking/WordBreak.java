package internship.backTracking;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		List<String> dict = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			dict.add(sc.next());
		}
		sc.nextLine();
		String str = sc.next();
		
		wordBreak(n, dict, str);
		
		for(String ans : res) {
			System.out.print("( " + ans + " ) ");
		}
		
		sc.close();
	}
	
//	TC: O((lengthOfString^2)*sizeOfDictionary) , SC: O(lengthOfString^2)
	static List<String> res = new ArrayList<>();
    static List<String> wordBreak(int n, List<String> dict, String s)
    {
        res.clear();
        solve(n,dict,s,"");
        return res;
    }
    
    static void solve(int n, List<String> dict, String s,String ans)
    {
        int strLen = s.length();
        if(strLen == 0){
            int len = ans.length();
            ans = ans.substring(0,len-1);
            res.add(ans);
            return ;
        }
        
        for(int i=0;i<strLen;i++){
            String left = s.substring(0,i+1);
            if(isDictContain(n,left,dict) == 1){
                String right = s.substring(i+1);
                solve(n,dict,right,ans + left + " ");
            }
        }
    }
    
    static int isDictContain(int n,String word,List<String> dict){
        for(int i=0;i<n;i++){
            if(dict.get(i).equals(word))
                return 1;
        }
        return 0;
    }

}
