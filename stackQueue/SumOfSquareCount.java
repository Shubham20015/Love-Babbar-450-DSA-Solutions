package internship.stackQueue;

import java.util.*;

public class SumOfSquareCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int k = sc.nextInt();
		
		System.out.println(minValue(str,k));
		
		sc.close();
	}
	
	static int minValue(String s, int k){
        int alpha[] = new int[26];
        int len = s.length();
        
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            alpha[ch-'a']++;
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<26;i++){
            if(alpha[i] != 0)
                pq.add(alpha[i]);
        }
        
        while(k-->0){
            int temp = pq.poll();
            temp--;
            pq.add(temp);
        }
        
        int count = 0;
        while(!pq.isEmpty()){
            count += pq.peek()*pq.poll();
        }
        
        return count;
    }

}
