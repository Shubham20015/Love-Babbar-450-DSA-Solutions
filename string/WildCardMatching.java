package internship.string;

import java.util.Scanner;

public class WildCardMatching {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String wild = sc.nextLine();
		String pattern = sc.nextLine();
		
		System.out.println(match(wild,pattern));
		
		sc.close();

	}
	
	static boolean match(String text,String pattern) {
		return false;
	}

}
