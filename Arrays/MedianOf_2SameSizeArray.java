package internship;

import java.util.*;

public class MedianOf_2SameSizeArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[m];
		
		for(int i=0;i<n;i++) {
			arr1[i] = sc.nextInt();
		}
		
		for(int i=0;i<m;i++) {
			arr2[i] = sc.nextInt();
		}
		
		int i = 0,j = 0;
		int m1 = -1,m2 = -1;
		
		for(int count = 0;count<=n;count++) {
			
			m1 = m2;
			
			if(i == n) {
				m2 = arr2[0];
				break;
			}
			else if(j == n) {
				m2 = arr1[0];
				break;
			}
			if (arr1[i] <= arr2[j])
            {   
                m2 = arr1[i];
                i++;
            }
            else
            {
                m2 = arr2[j];
                j++;
            }
		}
		
		System.out.println((m1+m2)/2);
		
		sc.close();
	}

}
