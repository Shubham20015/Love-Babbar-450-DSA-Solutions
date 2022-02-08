package internship.bitManipulation;

import java.util.*;

public class CopySetBit {
	public static void main(String args[]) {
			
			Scanner sc = new Scanner(System.in);
			
			int x = sc.nextInt();
			int y = sc.nextInt();
			int l = sc.nextInt();
			int r = sc.nextInt();
			
			System.out.println(copyBitByBit(x,y,l,r));
			
			sc.close();
	}
	
	public static int copyBitByBit(int x,int y,int l,int r) {
		if(l<1 || r>32)
			return 0;
		
		for(int i=l;i<=r;i++) {
			int mask = 1<<(i-1);
			x |= mask;
		}
		
		return x;
	}
	
	public static int copyBit(int x,int y,int l,int r) {
		if(l<1 || r>32)
			return 0;
		
		int maskLength = (1<<(r-l+1)) - 1;
		int mask = ((maskLength)<<(l-1)) & y ;
		x = x | mask;
		
		return x;
	}
	
}
