package internship.greedy;

import java.util.*;

public class CutBoardInSquares {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int m = sc.nextInt();
			int n = sc.nextInt();
//			Cuts are one less tham board size
			m--;
			n--;
			Integer x[] = new Integer[m];
			Integer y[] = new Integer[n];
			
			for(int i=0;i<m;i++) {
				x[i] = sc.nextInt();
			}
			
			for(int i=0;i<n;i++) {
				y[i] = sc.nextInt();
			}
			
			System.out.println(cutBoardCost(x,y,m,n));
		}
		
		sc.close();

	}
	
	static int cutBoardCost(Integer x[],Integer y[],int m,int n) {
		Arrays.sort(x,Collections.reverseOrder());
		Arrays.sort(y,Collections.reverseOrder());
		
		int res = 0;
		int hrcut = 1,vrcut = 1;
		int i=0,j=0;
		
		while(i < m && j < n) {
			
			if(x[i] > y[j]) {
				res += x[i++]*vrcut;
				hrcut++;
			}else {
				res += y[j++]*hrcut;
				vrcut++;
			}
		}
		
		while(i < m) {
			res += x[i++]*vrcut;
		}
		
		while(j < n) {
			res += y[j++]*hrcut;
		}
		
		return res;
	}

}
