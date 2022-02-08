package internship.searchingSorting;

import java.util.Scanner;

public class ArithmeticNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		if(C == 0){
            System.out.println(A == B ? 1:0);
        }
		
        int n = (B-A)/C + 1;
        
        System.out.println((B-A)%C == 0 && n>0 ? 1:0);
		
		sc.close();
	}

}
