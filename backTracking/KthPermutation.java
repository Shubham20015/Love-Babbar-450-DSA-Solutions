package internship.backTracking;

import java.util.*;

public class KthPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(k + "th Permutation: " + getPermutation(n,k));
		
		sc.close();
	}
//	TC: O(N*N) , SC:O(N)
	static String getPermutation(int n,int k) {
		int fact = 1;
		List<Integer> nums = new ArrayList<>();
		for(int i=1;i<n;i++) {
			fact *= i;
			nums.add(i);
		}
		
		nums.add(n);
		k--; // 0 based indexing consider
		String ans ="";
		while(true) {
			ans += nums.remove(k / fact);
			int len = nums.size();
			if(len == 0) break;
			
			k = k % fact;
			fact /= len;
		}
		
		return ans;
	}

}
