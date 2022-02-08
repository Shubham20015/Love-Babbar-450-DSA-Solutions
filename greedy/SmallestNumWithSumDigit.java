package internship.greedy;

import java.util.Scanner;

public class SmallestNumWithSumDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = sc.nextInt();
		int digit = sc.nextInt();
		
		System.out.println(smallestNumber(sum,digit));
		
		sc.close();
	}
	
	static String smallestNumber(int S, int D){
        
        if(9*D < S) return "-1";
        
        StringBuilder res = new StringBuilder();
        while(S >= 0 && D >= 0){
            if(S > 9){
                res.append("9");
                S -= 9;
                D--;
            }
            else if(S > 0){
                if(D > 1){
                    res.append(Integer.toString(S-1));
                    S = 1;
                    D--;
                }else if(D == 1){
                    res.append(Integer.toString(S));
                    S = 0;
                    D = 0;
                }
            }
        }
        res = res.reverse();
        return res.toString();
    }

}
