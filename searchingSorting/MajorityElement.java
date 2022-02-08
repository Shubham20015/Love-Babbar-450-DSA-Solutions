package internship.searchingSorting;

import java.util.Scanner;

public class MajorityElement {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int a[] = new int[n];
		
		for(int i=0;i<n;i++) {
			a[i] = sc.nextInt();
		}
		
		int x = a[0];
        int count = 1;
        
        for(int i=1;i<n;i++){
        	
            if(a[i] == x){
                count++;
            }else{
                count--;
            }
            
            if(count == 0){
                count = 1;
                x = a[i];
            }
        }
        
        count = 0;
        
        for(int i=0;i<n;i++){
            if(a[i] == x)
                count++;
        }
		
		System.out.println(count>(n/2) ? x:-1);
		
		sc.close();

	}

}
