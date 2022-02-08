package internship.searchingSorting;

import java.util.*;

public class ZeroSumSubArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		long sum = 0;
        int count =  0;
        HashMap<Long,Integer> map = new HashMap<>();
        map.put((long)0,1);
        
        for(int i=0;i<n;i++){
            sum += arr[i];
            if(map.containsKey(sum)){
                count += map.get(sum);
                map.put(sum, map.get(sum)+1);
            }
            else{
                 map.put(sum,1);
            }       
        }
        
        System.out.println(count);
		
		sc.close();

	}

}
