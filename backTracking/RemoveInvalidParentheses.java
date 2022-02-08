package internship.backTracking;

import java.util.*;

public class RemoveInvalidParentheses {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		int mr = getMin(str);
		removeParentheses(str,mr,new HashSet<String>());
		
		for(String s : list) {
			System.out.print(s + " ");
		}
		
		System.out.println();
		
		List<String> res = removeInvalidParentheses(str);
		
		for(String s : res) {
			System.out.print(s + " ");
		}
		
		sc.close();
	}
	
	static List<String> list = new ArrayList<>();
	
	static void removeParentheses(String str,int minRemoveAllowed,HashSet<String> ans) {
		if(minRemoveAllowed == 0) {
			int latestMRA = getMin(str);
			if(latestMRA == 0) {
				if(!ans.contains(str)) {
					list.add(str);
					ans.add(str);
				}
			}
			return ;
		}
		
		int n = str.length();
		for(int i=0;i<n;i++) {
			if(Character.isLetter(str.charAt(i)))
                continue;
			String temp = str.substring(0,i) + str.substring(i+1);
			removeParentheses(temp,minRemoveAllowed-1,ans);
		}
	}
	
	static int getMin(String str) {
		Stack<Character> stack = new Stack<>();
		int n = str.length();
		for(int i=0;i<n;i++) {
			char ch = str.charAt(i);
			
			if(ch == '(') {
				stack.push(ch);
			}else if(ch == ')') {
				if(stack.isEmpty() || stack.peek() == ')') {
					stack.push(ch);
				}else {
					stack.pop();
				}
			}
		}
		
		return stack.size();
	}
	
	 static boolean isValid(String exp){
	        int n = exp.length();
	        int count = 0;
	        
	        for(int i=0;i<n;i++){
	            char ch = exp.charAt(i);
	            
	            if(ch == '(')
	                count++;
	            else if(ch == ')')
	                count--;
	            if(count < 0)
	                return false;
	        }
	        
	        return count == 0;
	 }
	 
	 static List<String> removeInvalidParentheses(String s) {
	        HashSet<String> set = new HashSet<>();
	        List<String> ans = new ArrayList<>();
	        
	        if(s.isEmpty())
	            return ans;
	        
	        Queue<String> queue = new LinkedList<>();
	        
	        boolean level = false;
	        
	        queue.add(s);
	        set.add(s);
	        
	        while(!queue.isEmpty()){
	            s = queue.poll();
	            
	            if(isValid(s)){
	                ans.add(s);
	                level = true;
	            }
	            
	            if(level)
	                continue;
	                
	                int n = s.length();
	                for(int i=0;i<n;i++){
	                    char ch = s.charAt(i);
	                    if(Character.isLetter(ch))
	                        continue;
	                    String temp = s.substring(0,i) + s.substring(i+1);

	                    if(!set.contains(temp)){
	                        set.add(temp);
	                        queue.add(temp);
	                    }
	                }
	        }
	        
	        return ans;
	    }
}
