package internship.string;

import java.util.Scanner;

public class RomanToDecimal {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
        int sum = 0,i = 0;
        
        for(i=0;i<str.length()-1;i++){
            if(value(str.charAt(i)) >= value(str.charAt(i+1)))
                sum += value(str.charAt(i));
            else
                sum -= value(str.charAt(i));
        }
        sum += value(str.charAt(i));
        
        System.out.println(sum);
		
		sc.close();
	}
	
	public static int value(char ch){
        int val = 0;
        
        switch(ch){
            case 'I': val=1;
                    break;
            case 'V': val=5;
                    break;
            case 'X': val=10;
                    break;
            case 'L': val=50;
                    break;
            case 'C': val=100;
                    break;
            case 'D': val=500;
                    break;
            case 'M': val=1000;
                    break;        
        }
        
        return val;
    }

}
