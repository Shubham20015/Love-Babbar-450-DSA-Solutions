package internship.backTracking;

import java.util.*;

public class PossiblePalidromePartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		ArrayList<ArrayList<String>> res = allPartitions(str);
		
		for(ArrayList<String> temp : res) {
			for(String val : temp) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static ArrayList<ArrayList<String>> allPartitions(String str){
		int n = str.length();
		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		Deque<String> currPart = new LinkedList<>();
		allPartitionsUtil(ans,currPart,0,n,str);
		return ans;
	}
	
	static void allPartitionsUtil(ArrayList<ArrayList<String>> ans,Deque<String> currPart,int start,int n, String str) {
		if(start >= n) {
			ans.add(new ArrayList<>(currPart));
			return ;
		}
		
		for(int i=start;i<n;i++) {
			if(isPalindrome(str,start,i)) {
				currPart.add(str.substring(start, i+1));
				allPartitionsUtil(ans,currPart,i+1,n,str);
				currPart.removeLast();
			}
		}
	}

	static boolean isPalindrome(String input,int start,int end) {
		while(start < end) {
			if(input.charAt(start++) != input.charAt(end--))
				return false;
		}
		return true;
	}
}
