package internship.string;

import java.util.Scanner;

public class FlipsBinaryAlternate {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		
		int count0 = 0,count1 = 0,n = S.length();
        for(int i=0;i<n;i++){
            if(i%2 == 0 && S.charAt(i) == '1' || i%2 != 0 && S.charAt(i) == '0')
                count0++;
            else if(i%2 == 0 && S.charAt(i) == '0' || i%2 != 0 && S.charAt(i) == '1')
                count1++;
        }
        
        System.out.println(Math.min(count0,count1));
		
		sc.close();
	}

}
