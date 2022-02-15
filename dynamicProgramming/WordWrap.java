package internship.dynamicProgramming;

import java.util.*;

public class WordWrap {
	
	static int solveWordWrap (int[] words, int k)
    {
       int[] dp = new int[words.length];
       Arrays.fill(dp,-1);
       return wordWrap(words,0,dp,k);
    }
    
    static int wordWrap(int[] nums,int index,int dp[],int maxWidth){
        if(index >= nums.length-1) return 0;
        if(dp[index] != -1) return dp[index];
        int min = Integer.MAX_VALUE,currLen = 0;
        
        for(int i=index;i<nums.length;i++){
            currLen += nums[i];
            if(currLen <= maxWidth){
                int result = (maxWidth - currLen)*(maxWidth - currLen) + wordWrap(nums,i+1,dp,maxWidth);
                if(i == nums.length - 1) return 0;
                currLen += 1;
                min = Math.min(min,result);
            }else{
                break;
            }
        }

        return dp[index] = min;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int words[] = new int[n];
		
		for(int i=0;i<n;i++) {
			words[i] = sc.nextInt();
		}
		
		System.out.println("Minimize sum of cost of all lines: " + solveWordWrap(words, k));
		
		sc.close();
	}

}
