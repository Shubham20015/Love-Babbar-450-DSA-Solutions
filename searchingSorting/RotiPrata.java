package internship.searchingSorting;

import java.util.*;

public class RotiPrata {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int parta = sc.nextInt();
			int chefs = sc.nextInt();
			int ranks[] = new int[chefs];
			
			for(int i=0;i<chefs;i++) {
				ranks[i] = sc.nextInt();
			}
			
			Arrays.sort(ranks);
			
			long low = 0,high = (long) (ranks[chefs-1]*parta*(parta+1)/2);
			long ans = 0;
			
			while(low <= high) {
				long mid = (low + high) / 2;
				if(makeInTime(ranks,chefs,parta,mid)) {
					ans = mid;
					high = mid - 1;
				}else {
					low = mid + 1;
				}
			}
			
			System.out.println(ans);
		}
			
			sc.close();
		}
		
		static boolean makeInTime(int arr[],int n,int prata,long given) {
			int prantha = 0;
			int time = 0;
			for(int i=0;i<n;i++) {
				time = arr[i];
				int j = 2;
				while(time <= given) {
					prantha++;
					time += (arr[i]*j);
					j++;
				}
//				prantha += rotiHelper(time,given);
				if(prantha >= prata) return true;
			}
			
			return false;
		}
		
		static int rotiHelper(long R, long T)
		{
    		long temp = -R + (long)Math.sqrt(R * R + 8 * R * T);
    		return (int)(temp / (2 * R));
		}
}
