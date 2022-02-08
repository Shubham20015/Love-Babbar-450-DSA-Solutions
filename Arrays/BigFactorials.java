package internship;

import java.util.*;

public class BigFactorials {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<Integer> arr = new ArrayList<>();
		
		int n = sc.nextInt();
		arr.add(1);
		for(int i=2;i<=n;i++) {
			int carry = 0;
			for(int j=arr.size()-1;j>=0;j--) {
				int value = arr.get(j)*i + carry;
				arr.set(j,value%10);
				carry = value/10;
			}
			
			while(carry != 0) {
				arr.add(0,carry%10);
				carry /= 10;
			}
		}
		
		for(Integer val: arr) {
			System.out.print(val);
		}
		
		sc.close();

	}

}
