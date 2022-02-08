package internship.string;

import java.util.*;

public class TextJustification {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String words[] = new String[n];
		int k = sc.nextInt();
		
		for(int i=0;i<k;i++) {
			words[i] = sc.next();
		}
		
		List<String> ans = fullJustify(words,k);
		
		for(String val : ans) {
			System.out.println(val);
		}
		
		sc.close();
	}
	
	static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int i = 0,n = words.length;
        
        while(i < n){
            int wordCount = words[i].length();
            int j = i+1,can = 0;
            
            while(j < n && wordCount + words[j].length()+can+1 <= maxWidth){
                wordCount += words[j].length();
                can++;
                j++;
            }
            
            int vac = maxWidth - wordCount;
            
            int atleastSpace = can == 0 ? 0:vac/can;
            int extraSpace = can == 0 ? 0:vac%can;
            
            if(j == n){
                atleastSpace = 1;
                extraSpace = 0;
            }
            
            StringBuilder s = new StringBuilder();
            
            for(int k=i;k<j;k++){
                s.append(words[k]);
                if(k == j-1) break;
                for(int x=0;x<atleastSpace;x++) s.append(" ");
                if(extraSpace > 0){
                    s.append(" ");
                    extraSpace--;
                }
            }
            
            while(s.length() < maxWidth) s.append(" ");
            
            ans.add(s.toString());
            
            i=j;
        }
        return ans;
    }

}
