package internship;

import java.util.*;

public class AppearMoreThanN_K {
	public static void main(String args[]) {
		
		Scanner sc= new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		int x = n/k;
		HashMap<Integer,Integer> map = new HashMap<>();
		
		for(int i=0;i<n;i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) +1);
		}
		
		for(Map.Entry<Integer, Integer> val : map.entrySet()){
			if(val.getValue() > x) {
				System.out.print(val.getKey() + " ");
			}
		}
		
		
		sc.close();
	}
}
