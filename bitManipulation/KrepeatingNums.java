package internship.bitManipulation;

import java.util.Scanner;

public class KrepeatingNums {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		int k = sc.nextInt();
		
		System.out.println(repeatKtimes(arr,n,k));
		sc.close();

	}
	
	static int repeatKtimes(int nums[],int n,int k) {
		int count[] = new int[32]; // We take 32 size bcoz 1 byte = 4 bits and 1 int = 8 bytes 
		
		for(int i=0;i<32;i++) {
			for(int j=0;j<n;j++) {
				if((nums[j]&(1<<i)) != 0) {
					count[i]++;
				}
			}
		}
		
		int res = 0;
		
		for(int i=0;i<32;i++) {
			res += (count[i]%k)*(1<<i);
		}
		
		return res;
	}
}
