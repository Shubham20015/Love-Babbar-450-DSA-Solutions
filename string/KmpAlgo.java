package internship.string;

import java.util.Scanner;

public class KmpAlgo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		
		searchPattern(text,pattern);
		
		sc.close();
	}
	
	public static void searchPattern(String text,String pattern) {
		int M = pattern.length();
		int N = text.length();
		
		int lps[] = new int[M];
		int j = 0;
		
		computeLPSArray(pattern,M,lps);
		
		int i = 0;
		while(i<N) {
			if (pattern.charAt(j) == text.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "+ "at index " + (i - j));
                j = lps[j - 1];
            }
            else if(i<N && pattern.charAt(j) != text.charAt(i)) {
            	if(j != 0) {
            		j = lps[j - 1];
            	}else {
            		i++;
            	}
            }
		}
	}
	
	public static void computeLPSArray(String pattern,int M,int lps[]) {
		int len = 0;
		int i = 1;
		lps[0] = 0;
		
		while(i<M) {
			if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else 
                {
                    lps[i] = len;
                    i++;
                }
            }
		}
	}

}
