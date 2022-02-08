package internship.searchingSorting;

import java.util.*;

public class DoubleHelix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();
			if(n <= 0) break;
			int a[] = new int[n];
			for(int i=0;i<n;i++) {
				a[i] = sc.nextInt();
			}
			
			int m = sc.nextInt();
			int b[] = new int[m];
			for(int i=0;i<m;i++) {
				b[i] = sc.nextInt();
			}
			
			int sum1 = 0,sum2 = 0;
			int i = 0,j = 0;
			int max = 0;
			
			while(i<n && j<m) {
				if(a[i] < b[j]) {
					sum1 += a[i++];
				}else if(a[i] > b[j]) {
					sum2 += b[j++];
				}else {
					max += Math.max(sum1,sum2) + a[i]; 
					i++;
					j++;
					sum1 = sum2 = 0;
				}
			}
			
			while(i<n) {
				sum1 += a[i++];
			}
			
			while(j<m) {
				sum2 += b[j++];
			}
			
			System.out.println(max + Math.max(sum1, sum2));
		}
		
		sc.close();
	}
}
