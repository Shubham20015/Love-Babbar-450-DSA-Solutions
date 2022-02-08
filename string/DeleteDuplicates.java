package internship.string;

import java.util.Scanner;

public class DeleteDuplicates {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);
		
		 String S = sc.next();
		
		 int i=1;
	     while(i<S.length()){
	         if(S.charAt(i-1) == S.charAt(i)){
	              S = S.substring(0,i-1) + S.substring(i);
	         }else{
	              i++;
	         }
	     }
	        
	     System.out.println(S);
		
		 sc.close();

	}

}
