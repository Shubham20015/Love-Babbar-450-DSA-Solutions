package internship.dynamicProgramming;

import java.util.Scanner;

public class MaxDiffOf0and1InBinary {
	
	static int maxSubstring(String S) {
        int ans = -1,count0 = 0,count1 = 0;
        int n = S.length();
        for(int i=0;i<n;i++){
            char ch = S.charAt(i);
            if(ch == '0')
                count0++;
            if(ch == '1' && count0 > count1)
                count1++;
            if(count0 > count1)
                ans = Math.max(ans,count0-count1);
        }
        
        return ans;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(maxSubstring(str));
		
		sc.close();
	}

}
