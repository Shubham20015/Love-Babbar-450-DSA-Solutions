package internship.searchingSorting;

import java.util.Scanner;

public class SmallestFactorialTrailingZeroes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int l = 0,h = 5*n;
        
        while(l <= h){
            int m = (l+h)/2;
            if(findZeroes(m,n)){
                h = m-1;
            }else{
                l = m + 1;
            }
        }
        
        System.out.println(l);
        
        sc.close();
	}
	
//	Here we count trailing zeroes in given number/factorial
	
	static boolean findZeroes(int num,int n){
        int count = 0;
        for(int i = 5;num/i>=1;i*=5){
            count += num/i;
        }
        
        return count >= n;
    }

}
