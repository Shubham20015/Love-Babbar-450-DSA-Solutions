package internship.string;

import java.util.Scanner;

public class TransformAtoB {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String A = sc.nextLine();
		String B = sc.nextLine();
		
		System.out.println(convertor(A,B));
		
		sc.close();
	}
	
	static int convertor(String A,String B) {
		if(A.length() != B.length())
			return -1;
		
		int count[] = new int[256];
		int n = A.length();
		
		for(int i=0;i<n;i++) {
			count[A.charAt(i)]++;
			count[B.charAt(i)]--;
		}
		
		for(int i=0;i<256;i++) {
			if(count[i] != 0)
				return -1;
		}
		
		int i = A.length() -1;
		int j = B.length() -1;
		int res = 0;
		
		while(i >= 0) {
			if(A.charAt(i) != B.charAt(j)) {
				res++;
			}else {
				j--;
			}
			i--;
		}
		
		return res;
	}

}
