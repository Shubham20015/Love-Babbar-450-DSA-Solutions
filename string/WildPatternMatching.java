package internship.string;

import java.util.Scanner;

public class WildPatternMatching {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String pattern = sc.next();
		String str = sc.next();
		
		int ans = wildCard(pattern,str);
		System.out.println(ans);
		
		
		
		if (strmatch(str.toCharArray(), pattern.toCharArray(), str.length(),pattern.length()))
			System.out.println(1);
		else
			System.out.println(0);
		
		sc.close();

	}
	
//	Time Complexity: O(m*n)  Space Complexity: O(m*n)
	static int wildCard(String pattern, String str)
    {
        int n = str.length();
        int m = pattern.length();
        
        boolean dp[][] = new boolean[n+1][m+1];
        dp[0][0] = true;
        for(int i=1;i<=n;i++){
            dp[i][0] = false;
        }
        for(int j=1;j<=m;j++){
            dp[0][j] = pattern.charAt(j-1) == '*' ? dp[0][j-1]:false;
        }
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(str.charAt(i-1) == pattern.charAt(j-1) || pattern.charAt(j-1) == '?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = false;
                }
            }
        }
        
        return dp[n][m] ? 1:0;
    }
	
//	Time Complexity: O(m + n)  Space Complexity: O(1)
	 static boolean strmatch(char txt[], char pat[],int n, int m)
		{
			if (m == 0)
			return (n == 0);
			
			int i = 0, j = 0, index_txt = -1,
			index_pat = -1;
			
			while (i < n)
			{
			
				if (j < m && txt[i] == pat[j])
				{
					i++;
					j++;
				}
				
				else if (j < m && pat[j] == '?')
	            {
	                i++;
	                j++;
	            }
				
				else if (j < m && pat[j] == '*')
				{
					index_txt = i;
					index_pat = j;
					j++;
				}
				
				else if (index_pat != -1)
				{
					j = index_pat + 1;
					i = index_txt + 1;
					index_txt++;
				}
			
				else return false;
			}
			
			while (j < m && pat[j] == '*')
			{
				j++;
			}
			
			return j == m;
		}
}
