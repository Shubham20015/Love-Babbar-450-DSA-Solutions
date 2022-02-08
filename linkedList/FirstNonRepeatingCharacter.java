package internship.linkedList;

import java.util.*;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		String ans = FirstNonRepeating(str);
		System.out.println(ans);
		
		sc.close();

	}
	
	static String FirstNonRepeating(String A)
    {
       StringBuilder ret = new StringBuilder();
       int isRepeated[] = new int[26];
       Deque<Character> queue = new ArrayDeque<>();
       for(int i=0;i<A.length();i++){
           char ch = A.charAt(i);
           if(isRepeated[ch - 'a'] == 0)
                queue.add(ch);
           
           isRepeated[ch - 'a']++;
           while(!queue.isEmpty() && isRepeated[queue.peek() - 'a'] != 1){
               queue.poll();
           } 
            //   str += queue.isEmpty() ? '#' : queue.peek(); -> this line gives TLE but stringbuilder line doesn't find reason
               ret.append(queue.isEmpty() ? '#' : queue.peek());
       }
       
       return ret.toString();
    }

}
