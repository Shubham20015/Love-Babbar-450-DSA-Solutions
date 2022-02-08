package internship.string;

import java.util.Scanner;

public class RabinKarpAlgo {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String patt = sc.nextLine();
		String txt = sc.nextLine();
		
		searchPattern(patt,txt,101);
		
		
		sc.close();
	}
	
	static final int d = 256;
	
	public static void searchPattern(String s,String t, int q) {
		int S = s.length(),T = t.length();
		int pattern = 0; // hash value for pattern
        int text = 0; // hash value for given string
        int hash = 1;
        int i = 0 ,j = 0;
        
        for(i=0;i<S-1;i++) {
        	hash = (hash*d)%q;
        }
        
        for(i=0;i<S;i++) {
        	pattern = (d*pattern + s.charAt(i))%q;
        	text = (d*text + t.charAt(i))%q;
        }
		
        for (i = 0; i <= T - S; i++)
        {
            if ( pattern == text )
            {
                for (j = 0; j < S; j++)
                {
                    if (t.charAt(i+j) != s.charAt(j))
                        break;
                }
     
                if (j == S)
                    System.out.println("Pattern found at index " + i);
            }
            
            if(i < T-S) {
            	
            	text = (d*(text - t.charAt(i)*hash) + t.charAt(i+S))%q;
            	
            	if (text < 0)
                    text = (text + q);
            }
        }
	}

}
