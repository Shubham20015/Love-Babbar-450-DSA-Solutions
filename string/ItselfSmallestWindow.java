package internship.string;

import java.util.*;

public class ItselfSmallestWindow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		System.out.println(window(str));
		
		sc.close();

	}
	
	static int window(String s1) {
		 HashSet<Character> hash = new HashSet<>();
	        for(int i=0;i<s1.length();i++){
	            hash.add(s1.charAt(i));
	        }
	        
	        HashMap<Character,Integer> map = new HashMap<>();
	        int i= -1,j = -1;
			
			int len = Integer.MAX_VALUE;
			
			while(true) {
				
				boolean flag1 = false;
				boolean flag2 = false;
				
				while(i < s1.length()-1 && map.size() < hash.size()) {
					i++;
					char ch = s1.charAt(i);
					map.put(ch,map.getOrDefault(ch, 0) + 1);
					
					flag1 = true;
				}
				
				while(j < i && map.size() == hash.size()) {
					int pathlen = i-j;
					if(pathlen < len) {
						len = pathlen;
					}
					
					j++;
					char ch = s1.charAt(j);
					
					if(map.get(ch) == 1) {
						map.remove(ch);
					}else {
						map.put(ch,map.get(ch) - 1);
					}
					
					flag2 = true;
				}
				
				if(flag1 == false && flag2 == false) {
					break;
				}
			}
			
			return len;
	}

}
