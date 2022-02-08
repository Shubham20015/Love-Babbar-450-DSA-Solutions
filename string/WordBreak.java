package internship.string;

import java.util.*;

public class WordBreak {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int n = sc.nextInt();
		ArrayList<String> arr = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			arr.add(sc.next());
		}
		
		boolean dp[] = new boolean[n+1];
		
		Arrays.fill(dp, false);
		dp[0] = true;
		
		int maxLen = 0;
        
        for(String word: arr){
            maxLen = Math.max(maxLen, word.length());
        }
		
		for(int i=1;i<=n;i++) {
			for(int j=i-1;j>=0;j--) {
				if(i-j > maxLen) continue;
				if(dp[j] == true && arr.contains(str.substring(j,i))){
			           dp[i] = true;
			           break;
			    }
			}
		}
		
		System.out.println(dp[n]);
		
		sc.close();
	}

}
