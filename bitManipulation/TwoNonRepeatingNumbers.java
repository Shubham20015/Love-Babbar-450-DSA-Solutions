package internship.bitManipulation;

import java.util.Scanner;

public class TwoNonRepeatingNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int ans[] = repeat(arr);
		
		System.out.println(ans[0] + " & " + ans[1]);
		
		sc.close();

	}
	
	static int[] repeat(int nums[]) {
		int n = nums.length;
        int res = nums[0];
        for(int i=1;i<n;i++){
            res ^= nums[i]; 
        }
        
        int temp = res;
        int mask = temp&(-temp); // calculate rightmost set bit
        
        for(int i=0;i<n;i++){
            if((nums[i]&mask) == mask){ // xor between one group with mask which gives one number 
                temp ^= nums[i]; 
            }else{
                res ^= nums[i]; // xor between another group without mask which gives another number
            }
        }
        
        int a[] = new int[2];
        
        a[0] = Math.min(temp , res);
        a[1] = Math.max(temp , res);
        
        return a;
	}

}
