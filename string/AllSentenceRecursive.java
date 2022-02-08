package internship.string;

import java.util.Scanner;

public class AllSentenceRecursive {
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		String words[][] = new String[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				words[i][j] = sc.next();
			}
		}
		
		String sent[] = new String[n];
		
		for(int i=0;i<m;i++) {
			if(words[0][i] != "")
				formSentence(words,0,i,sent);
		}
		
		sc.close();
	}
	
	static void formSentence(String arr[][],int len,int n,String res[]) {
		res[len] = arr[len][n];
		
		if(len == arr.length-1) {
			for(int i=0;i<arr.length;i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<arr[0].length;i++)
			if(arr[len+1][i] != "")
				formSentence(arr,len+1,i,res);
	}
}
