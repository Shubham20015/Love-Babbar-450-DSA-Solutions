package internship;

import java.util.HashSet;
import java.util.Scanner;

public class SubSetOrNot {

	public static void main(String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
		HashSet<Integer> set = new HashSet<>();
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		int subset[] = new int[m];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
			set.add(arr[i]);
		}
		
		String result = "Yes";
		
		for(int i=0;i<m;i++) {
			subset[i] = sc.nextInt();
			if(!set.contains(subset[i])) {
				result = "No";
			}
		}
		
		System.out.println(result);
		
		sc.close();
	}

}
