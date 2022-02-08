package internship;

import java.util.*;

public class SubarrayZeroSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		HashSet<Integer> set = new HashSet<>();
		
		int sum = 0;
		boolean flag = false;
		
        for(int i=0;i<n;i++){
            sum += sc.nextInt();
            if(sum == 0 || set.contains(sum))
            	flag = true;
            set.add(sum);    
        }
        
        System.out.println(flag);
        
        sc.close();
	}

}
