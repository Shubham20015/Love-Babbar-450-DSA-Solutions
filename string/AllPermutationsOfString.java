package internship.string;

import java.util.*;

public class AllPermutationsOfString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		List<String> list = new ArrayList<>();
		permute(str,list,0,str.length()-1);
		
		for(String value : list) {
			System.out.println(value);
		}
		
		sc.close();
	}
	
	public static void permute(String str,List<String> list,int low,int high) {
		
		if(low == high) {
			list.add(str);
			return;
		}
		
		for(int i=low;i<=high;i++) {
			permute(swaps(str,low,i),list,low+1,high);
		}
		
	}
	
	public static String swaps(String str,int i,int j) {
		char arr[] = str.toCharArray();
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		return String.valueOf(arr);
	}

}
