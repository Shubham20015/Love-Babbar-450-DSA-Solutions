package internship.string;

import java.util.*;

public class SmallestWindowSubstring {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();
		
		System.out.println(window(s1,s2));
		
		sc.close();
	}
	
	static String window(String s1,String s2) {
		HashMap<Character,Integer> map2 = new HashMap<>();
		int n = s2.length();
		
		for(int i=0;i<n;i++) {
			char ch = s2.charAt(i);
			map2.put(ch,map2.getOrDefault(ch, 0) + 1);
		}
		
		HashMap<Character,Integer> map1 = new HashMap<>();
		int i= -1,j = -1;
		
		int mcnt = 0,dmcnt = n;
		String ans = "";
		
		while(true) {
			
			boolean flag1 = false;
			boolean flag2 = false;
			
			while(i < s1.length()-1 && mcnt < dmcnt) {
				i++;
				char ch = s1.charAt(i);
				map1.put(ch,map1.getOrDefault(ch, 0) + 1);
				
				if(map1.getOrDefault(ch, 0) <= map2.getOrDefault(ch, 0)) {
					mcnt++;
				}
				
				flag1 = true;
			}
			
			while(j < i && mcnt == dmcnt) {
				String path = s1.substring(j+1,i+1);
				if(ans.length() == 0 || path.length() < ans.length()) {
					ans = path;
				}
				
				j++;
				char ch = s1.charAt(j);
				
				if(map1.get(ch) == 1) {
					map1.remove(ch);
				}else {
					map1.put(ch,map1.get(ch) - 1);
				}
				
				if(map1.getOrDefault(ch, 0) < map2.getOrDefault(ch, 0)) {
					mcnt--;
				}
				
				flag2 = true;
			}
			
			if(flag1 == false && flag2 == false) {
				break;
			}
		}
		
		return ans;
	}

}
