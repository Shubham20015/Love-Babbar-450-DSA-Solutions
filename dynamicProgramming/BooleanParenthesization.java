package internship.dynamicProgramming;

import java.util.Scanner;

public class BooleanParenthesization {
	
//	TC: O(N^3) , SC: O(N^2)
	static int countWays(int N, String S){
        String str = "",exp = "";
        for(int i=0;i<N;i++){
            char ch = S.charAt(i);
            if(ch == 'T' || ch == 'F'){
                str += ch;
            }else{
                exp += ch;
            }
        }
        
        int n = str.length();
        int mod = 1003;
        
        int dpt[][] = new int[n][n];
        int dpf[][] = new int[n][n];
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;i++,j++){
                if(gap == 0){
                    char ch = str.charAt(i);
                    if(ch == 'T'){
                        dpt[i][j] = 1;
                        dpf[i][j] = 0;
                    }else{
                        dpt[i][j] = 0;
                        dpf[i][j] = 1;
                    }
                }else{
                    for(int k=i;k<j;k++){
                        char opt = exp.charAt(k);
                        
                        int ltc = dpt[i][k];
                        int rtc = dpt[k+1][j];
                        int lfc = dpf[i][k];
                        int rfc = dpf[k+1][j];
                        
                        if(opt == '&'){
                            dpt[i][j] += (ltc*rtc)%mod;
                            dpf[i][j] += ((ltc*rfc)%mod + (lfc*rtc)%mod + (lfc*rfc)%mod)%mod;
                        }else if(opt == '|'){
                            dpt[i][j] += ((ltc*rfc)%mod + (lfc*rtc)%mod + (ltc*rtc)%mod)%mod;
                            dpf[i][j] += (lfc*rfc)%mod;
                        }else{
                            dpt[i][j] += ((rfc*ltc)%mod + (rtc*lfc)%mod)%mod;
                            dpf[i][j] += ((rfc*lfc)%mod + (rtc*ltc)%mod)%mod;
                        }
                    }
                }
            }
        }
        
        return dpt[0][n-1];
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String s = sc.next();
		
		System.out.println("number of ways of parenthesize the expression for which value of expression to be true: " + countWays(n,s));
		
		sc.close();
	}

}
