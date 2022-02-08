package internship.string;

import java.util.*;

public class AllSubSequences {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
        
		recursionSequence(str,"");
		System.out.println();
		BitwiseSequence(str);
		
		sc.close();
	}
	
	public static void BitwiseSequence(String str) {
		ArrayList<String> arr = new ArrayList<>();
//		Time Complexity:O(pow(2,n)*n)
		int n = str.length();
		for(int i=0;i<(1<<n);i++) {
			String sub = "";
			for(int j=0;j<n;j++) {
				
				if((i&(1<<j)) > 0) {
					sub += str.charAt(j);
				}
			}
			if(sub != "")
			    arr.add(sub);
		}
		
		Collections.sort(arr);
        
		for(String s : arr) {
			System.out.print(s + " ");
		}
	}
	
	public static void recursionSequence(String input,String output) {
//		Time Complexity:O(pow(2,n))
		if(input.length() == 0) {
			System.out.print(output + " ");
			return;
		}
		
		recursionSequence(input.substring(1),output);
		recursionSequence(input.substring(1),output + input.charAt(0));
	}

}
