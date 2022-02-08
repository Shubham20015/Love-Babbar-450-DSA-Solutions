package internship.string;

import java.util.*;

public class BoyerMooreAlgo {

	public static void main(String[] args) {
//		It gives only where you get pattern first
		
		Scanner sc = new Scanner(System.in);
		
		HashMap<Character,Integer> hash = new HashMap<>();
		
		String text = sc.nextLine();
		String pattern = sc.nextLine();
		int n = text.length(),m = pattern.length();
		badTable(hash,pattern);
		int numOfSkips = 0,i = 0;
		for(i=0;i<=n-m;i+=numOfSkips) {
			numOfSkips = 0;
			
			for(int j=m-1;j>=0;j--) {
				if(text.charAt(i+j) != pattern.charAt(j)) {
					numOfSkips = hash.get(text.charAt(i+j)) != null ? hash.get(text.charAt(i+j)):m;
					break;
				}
			}
			
			if(numOfSkips == 0) {
				System.out.println("Found Pattern at "+i);
				numOfSkips = m;
			}
		}
		
		sc.close();
	}
	
	public static void badTable(HashMap<Character,Integer> map,String s) {
		
		int n = s.length();
		
		for(int i=0;i<n;i++) {
			char ch = s.charAt(i);
			int maxShift = Math.max(1, n-i-1);
			map.put(ch,maxShift);
		}
	}

}
