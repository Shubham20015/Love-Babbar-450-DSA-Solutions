package internship.searchingSorting;

import java.util.Scanner;

public class FindRepeatingAndMissing {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int miss = 0,repeat = 0;
        
        for(int i=0;i<n;i++){
            if(arr[Math.abs(arr[i])-1] > 0){
                arr[Math.abs(arr[i])-1] = -arr[Math.abs(arr[i])-1];
            }else{
                repeat = Math.abs(arr[i]);
            }
        }
        
        for(int i=0;i<n;i++){
            if(arr[i] > 0)
                miss = i+1;
        }
        int ans[] = {repeat,miss};
        
        for(int val: ans) {
        	System.out.print(val + " ");
        }
		
		sc.close();

	}

}
