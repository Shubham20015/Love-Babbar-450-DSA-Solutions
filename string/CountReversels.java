package internship.string;

import java.util.Scanner;

public class CountReversels {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int n = str.length();
        int open = 0,close = 0,count = 0;
        
        if(n%2 != 0){
        	System.out.println("-1");
        }
        
        for(int i=0;i<n;i++){
            if(close>open){
                close--;
                open++;
                count++;
            }
            if(str.charAt(i) == '{'){
                open++;
            } else if(str.charAt(i) == '}'){
                close++;
            }
        }
        
        System.out.println(count + (open-close)/2);
		
		sc.close();
	}

}
