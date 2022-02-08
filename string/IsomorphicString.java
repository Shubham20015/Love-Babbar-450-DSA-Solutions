package internship.string;

import java.util.*;

public class IsomorphicString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		
		System.out.println(isomorphic(str1,str2) ? 1:0);
		
		sc.close();
	}
	
	static boolean isomorphic(String str1,String str2) {
		int n = str1.length();
        int m = str2.length();
        
        if(n != m)
            return false;
            
        HashMap<Character,Character> map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            if(map.containsKey(str1.charAt(i))){
                if(map.get(str1.charAt(i)) != str2.charAt(i)){
                    return false;
                }
            }else if(map.containsValue(str2.charAt(i))){
                return false;
            }
            map.put(str1.charAt(i),str2.charAt(i));
        }
        
        return true;
	}
}
