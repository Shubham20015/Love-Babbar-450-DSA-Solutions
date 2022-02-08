package internship;

import java.util.*;

public class CountPairs {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		HashMap<Integer,Integer> map = new HashMap<>();
		
	
		for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            if(!map.containsKey(arr[i]))
                map.put(arr[i],0);
                
            map.put(arr[i], map.get(arr[i])+1);
        }
		
        int answer = 0;
        
        for (int i = 0; i < n; i++)
        {
        	if(map.containsKey(k-arr[i])) {
        		if (arr[i] == k - arr[i]) {
        			answer += map.get(k-arr[i])-1;
        		}else {
        			answer += map.get(k-arr[i]);
        		}
        		
        	}
        }
        
		System.out.println(answer/2);
		sc.close();
	}

}
