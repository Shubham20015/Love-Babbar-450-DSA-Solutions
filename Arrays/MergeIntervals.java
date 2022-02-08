package internship;

import java.util.*;

public class MergeIntervals {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int arr[][] = new int[N][2];
		
		for(int i=0;i<N;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		Arrays.sort(arr, (first,second) -> first[0] - second[0]);
		
		ArrayList<int []> res = new ArrayList<>();
		
		int prev[] = arr[0];
		
		for(int i=1;i<N;i++) {
			int cur[] = arr[i];
			
			if(cur[0] > prev[1]) {
				res.add(prev);
				prev = cur;
			}else {
				prev[1] = Math.max(prev[1], cur[1]);
			}
		}
		
		res.add(prev);
		
		for(int ele[]: res) {
			System.out.print("["+ele[0]+","+ele[1]+"] ");
		}
		
		sc.close();

	}

}
