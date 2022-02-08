package internship.searchingSorting;

import java.util.Scanner;

public class MiddleOfThree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		System.out.println(searchMiddle(a,b,c));
		
		sc.close();

	}
	
	static int searchMiddle(int A,int B,int C) {
		 if(A<B){
	           if(B<C)
	               return B;
	           else if(C<A)
	               return A;
	           else return C;
	         }
	          else{     
	           if(A<C)
	               return A;
	           else if(C<B)
	               return B;
	           else return C;
	       }
	}

}
