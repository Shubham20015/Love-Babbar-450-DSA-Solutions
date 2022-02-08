package internship.string;

import java.util.Scanner;

public class MinSwapsBalancedBrackets {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		int open = 0,close = 0;
		int n = S.length(),swaps = 0;
        
        for(int i=0;i<n;i++){
            if(S.charAt(i) == '['){
                if(close >= open){
                    swaps += (close-open);
                }
                open++;
            }
            if(S.charAt(i) == ']'){
                close++;
            }
        }
        
        System.out.println(swaps);
		
		sc.close();

	}

}
