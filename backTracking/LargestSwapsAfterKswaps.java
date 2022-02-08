package internship.backTracking;

import java.util.Scanner;

public class LargestSwapsAfterKswaps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		int k = sc.nextInt();
		
		System.out.println(findMaximumNum(str, k));
		
		sc.close();
	}
	
	static String max;
    
    static String findMaximumNum(String str, int k)
    {
        max = str;
        solve(str.toCharArray(),k);
        return max;
    }
    
    static void solve(char arr[],int k){
        
        if(k == 0)
            return;
            
        int n = arr.length;    
        
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(arr[j] > arr[i]){
                    char ch = arr[i];
                    arr[i] = arr[j];
                    arr[j] = ch;
                    
                    if (String.valueOf(arr).compareTo(max) > 0)
                            max = String.valueOf(arr);
                            
                    solve(arr,k-1);        
                            
                    ch = arr[i];
                    arr[i] = arr[j];
                    arr[j] = ch;        
                }
            }
        }   
    }

}
