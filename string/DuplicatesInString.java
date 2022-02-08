package internship.string;

import java.util.*;

public class DuplicatesInString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		HashMap<Character,Integer> map = new HashMap<>();
		
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			map.put(ch,map.getOrDefault(ch, 0)+1);
		}
		
		for(Map.Entry<Character, Integer> val: map.entrySet()) {
			if(val.getValue() > 1) {
				System.out.println(val.getKey() +" -> "+ val.getValue());
			}
		}
		
		sc.close();

	}

}
