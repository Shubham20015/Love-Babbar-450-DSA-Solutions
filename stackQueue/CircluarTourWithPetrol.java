package internship.stackQueue;

import java.util.Scanner;

public class CircluarTourWithPetrol {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int petrol[] = new int[n];
		int distance[] = new int[n];
		
		for(int i=0;i<n;i++) {
			petrol[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			distance[i] = sc.nextInt();
		}
		
		System.out.println(tour(petrol,distance));
		
		sc.close();
	}
	
	static int tour(int petrol[], int distance[])
    {
        int n = petrol.length;
        int loan = 0,bal = 0;
        int front = 0;
	    for(int i=0;i<n;i++){
	        bal += petrol[i] - distance[i];
	        if(bal < 0){
	            front = i+1;
	            loan += bal;
	            bal = 0;
	        }
	    }
	    if(loan + bal >= 0) return front;
	    return -1;
    }

}
