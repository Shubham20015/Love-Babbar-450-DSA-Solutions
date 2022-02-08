package internship.string;

import java.util.*;

public class ValidIPAddresses {
	
//	Time complexity : O(1) as pow(2,32) constant ip addresses in IPV4
//	Space complexity : O(1) same logic

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<>();
		int path[] = new int[4];
		
		String str = sc.next();
		
		validIP(list,str,0,path,0);
		
		for(String element : list) {
			System.out.println(element);
		}
		
		sc.close();
	}
	
	static void validIP(ArrayList<String> ips,String str,int builderIndex,int path[],int segment) {
		int n = str.length();
		
		if(segment == 4 && builderIndex == n) {
			ips.add(path[0] + "." + path[1] + "." + path[2] + "." + path[3]);
			return;
		}else if(segment == 4 || builderIndex == n) {
			return;
		}
		
		for(int len=1;len<=3 && builderIndex + len <= n;len++) {
			String snapshot = str.substring(builderIndex,builderIndex+len);
			int value = Integer.parseInt(snapshot);
			if(value > 255 || len >= 2 && str.charAt(builderIndex) == '0') {
				break;
			}
			path[segment] = value;
			validIP(ips,str,builderIndex+len,path,segment+1);
			path[segment] = -1;
		}
	}
}
