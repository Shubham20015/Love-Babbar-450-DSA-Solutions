package internship.searchingSorting;

import java.util.*;

public class KthSmallestAgain {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-->0) {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			long arr[][] = new long[N][2]; 
			
			for(int i=0;i<N;i++) {
				arr[i][0] = sc.nextLong();
				arr[i][1] = sc.nextLong();
			}
			
			Arrays.sort(arr, (first,second) -> (int)(first[0] - second[0]));
			
			ArrayList<long[]> ans = new ArrayList<>();
			
			long prev[] = arr[0];
			
			for(int i=1;i<N;i++) {
				long curr[] = arr[i];
				if(curr[0] > prev[1]) {
					ans.add(curr);
					prev = curr;
				}else {
					prev[1] = Math.max(prev[1], curr[1]);
				}
			}
			
			ans.add(prev);
			
			long res[][] = new long[ans.size()][2];
			
			for(int i=0;i<ans.size();i++) {
				res[i][0] = ans.get(i)[0];
				res[i][1] = ans.get(i)[1];
			}
			
			while(Q-->0) {
				long k = sc.nextInt();
				boolean isFound = false;
				for(int i=0;i<ans.size();i++) {
					long diff = arr[i][1] - arr[i][0];
					if(diff+1 >= k) {
						 System.out.println(arr[i][0] + (k-1));
				         isFound = true;
				         break;
					}else {
						 k = k - diff-1;
					}
				}
				
				if(!isFound){
				     System.out.println(-1);
				}
			}
		}
		
		sc.close();
	}

}
