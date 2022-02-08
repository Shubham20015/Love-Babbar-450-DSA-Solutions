package internship.string;

import java.util.*;

public class CountStringIn2DArray {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		char[][] stringArray = new char[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				stringArray[i][j] = sc.next().charAt(0);
			}
		}
		
		String str = sc.next();
		
		System.out.println(searchString(str,stringArray,n,m));
		
		sc.close();
	}
	
	public static int searchString(String str,char arr[][],int rows,int cols) {
		int ans = 0;
		
		for(int i=0;i<rows;i++) {
			for(int j=0;j<cols;j++) {
				ans += researchChar(str,arr,i,j,rows,cols,0);
			}
		}
		
		return ans;
	}
	
	public static int researchChar(String str,char arr[][],int i,int j,int rows,int cols,int k) {
		int found = 0;
		if(i<rows && j<cols && i>=0 && j>=0 && arr[i][j] == str.charAt(k)) {
			char temp = str.charAt(k);
			arr[i][j] = '0';
			k++;
			if(k == str.length()) {
				found = 1;
			}
			else {
				found += researchChar(str,arr,i+1,j,rows,cols,k);
				found += researchChar(str,arr,i-1,j,rows,cols,k);
				found += researchChar(str,arr,i,j+1,rows,cols,k);
				found += researchChar(str,arr,i,j-1,rows,cols,k);
			}
			arr[i][j] = temp;
		}
		return found;
	}
}
