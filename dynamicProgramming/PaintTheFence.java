package internship.dynamicProgramming;

import java.util.Scanner;

public class PaintTheFence {
	
	static long countWays(int n,int k)
    {
        long mod = (long)1e9+7;
        
        if(n == 1)
            return (long)k;
            
        long same = k*1;
        long diff = k*(k-1);
        long total = same + diff;
        
        for(int i=3;i<=n;i++){
            same = (diff*1)%mod;
            diff = (total*(k-1))%mod;
            total = same + diff;
        }
        
        return total%mod;
    }

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println("Number of ways of painting fence with not atmost two consecutive fences having same color: " + countWays(n,k));
		
		sc.close();
	}

}
