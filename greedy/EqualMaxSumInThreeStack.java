package internship.greedy;

import java.util.Scanner;

public class EqualMaxSumInThreeStack {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		
		int stack1[] = new int[n1];
		int stack2[] = new int[n2];
		int stack3[] = new int[n3];
		
		for(int i=0;i<n1;i++)
			stack1[i] = sc.nextInt();
		for(int i=0;i<n2;i++)
			stack2[i] = sc.nextInt();
		for(int i=0;i<n3;i++)
			stack3[i] = sc.nextInt();
		
		System.out.println(maxEqualSum(stack1,stack2,stack3,n1,n2,n3));
		
		sc.close();
	}
	
	static int maxEqualSum(int stack1[],int stack2[],int stack3[],int n1,int n2,int n3) {
		int sum1 = 0,sum2 = 0,sum3 = 0;

		for(int i=0;i<n1;i++)
			sum1 += stack1[i];
		
		for(int i=0;i<n2;i++)
			sum2 += stack2[i];
		
		for(int i=0;i<n3;i++)
			sum3 += stack3[i];
		
		int top1 = 0,top2 = 0,top3 = 0;
		
		while(true) {
			
			if(top1 == n1 || top2 == n2 || top3 == n3)
				return -1;
			
			if(sum1 == sum2 && sum2 == sum3)
				return sum2;
			
			if(sum1 >= sum2 && sum1 >= sum3)
				sum1 -= stack1[top1++];
			
			else if(sum2 >= sum1 && sum2 >= sum3)
				sum2 -= stack2[top2++];
			
			else if(sum3 >= sum1 && sum3 >= sum2)
				sum3 -= stack3[top3++];
		}
	}
}
