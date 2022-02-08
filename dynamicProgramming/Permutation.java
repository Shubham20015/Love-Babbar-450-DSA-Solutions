package internship.dynamicProgramming;

import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		System.out.println(nPk(n,k));
		System.out.println(nPkShort(n,k));
		sc.close();
	}
	
//	TC: O(n) , SC: O(n)
	static int nPk(int n,int k) {
		int fact[] = new int[n+1];
		fact[0] = 1;
		for(int i=1;i<=n;i++) {
			fact[i] = fact[i-1] * i;
		}
		
		return fact[n]/fact[n-k];
	}
	
//	TC: O(n) , SC: O(1)
	static int nPkShort(int n,int k) {
		int fact = 1,factK = 0;
		for(int i=1;i<=n;i++) {
			fact *= i;
			if(i == n-k)
				factK = fact;
		}
		
		return fact/factK;
	}

}
