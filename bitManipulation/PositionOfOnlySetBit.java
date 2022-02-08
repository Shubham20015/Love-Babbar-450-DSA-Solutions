package internship.bitManipulation;

import java.util.*;

public class PositionOfOnlySetBit {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		if(n == 0) System.out.println("-1");
        int count = 0;
        while(n > 0 && (n&1) == 0){
            count++;
            n = n>>1;
        }
        
        System.out.println(n == 1?count+1:"-1");
		
		sc.close();

	}

}
