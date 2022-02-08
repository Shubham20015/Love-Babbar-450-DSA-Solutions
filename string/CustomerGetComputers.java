package internship.string;

import java.util.Scanner;

public class CustomerGetComputers {
	
	// seen[i] = 0, indicates that customer 'i' is not in cafe
    // seen[1] = 1, indicates that customer 'i' is in cafe but computer is not assigned yet.
    // seen[2] = 2, indicates that customer 'i' is in cafe and has occupied a computer.

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int numOfComputers = sc.nextInt();
		String customers = sc.next();
		
		char arr[] = customers.toCharArray();
		
		char seen[] = new char[26];
		
		int occupied = 0,res = 0;
		
		for(int i=0;i<arr.length;i++) {
			int index = arr[i] - 'A';
			
			if(seen[index] == 0) {
				seen[index] = 1;
				
				if(occupied < numOfComputers) {
					occupied++;
					seen[index] = 2;
				}else {
					res++;
				}
			}
			
			else {
				if(seen[index] == 2) {
					occupied--;
				}
				
				seen[index] = 0;
			}
		}
		
		System.out.println(res);
		
		sc.close();
	}

}
