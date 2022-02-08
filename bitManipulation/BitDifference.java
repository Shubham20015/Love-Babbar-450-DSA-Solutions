package internship.bitManipulation;

import java.util.Scanner;

public class BitDifference {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		int n = a^b;
        int count = 0;
        while(n > 0){
            count++;
            n = n&(n-1);
        }
        
        System.out.println(count);
		
		sc.close();

	}

}
