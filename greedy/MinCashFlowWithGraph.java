package internship.greedy;

import java.util.Scanner;

public class MinCashFlowWithGraph {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = 3; // no. of presons in graph present
		
		// graph[i][j] indicates the amount
        // that person i needs to pay person j
		int graph[][] = {{0,1000,2000},
						 {0,0,3000},
						 {0,0,0}};
		
		int amount[] = new int[n];
		
		for(int p=0;p<n;p++)
			for(int i=0;i<n;i++)
				amount[p] += (graph[i][p] - graph[p][i]);
		
		minCashFlow(amount);
		
		sc.close();
	}
	
	static void minCashFlow(int amount[]) {
		int maxCredit = getMax(amount),maxDebit = getMin(amount);
		System.out.println(maxCredit + " " + maxDebit);
		if(amount[maxCredit] == 0 && amount[maxDebit] == 0)
			return ;
		
		int min = minof2(amount[maxCredit],-amount[maxDebit]);
		amount[maxCredit] -= min;
		amount[maxDebit] += min;
		
		System.out.println("Person " + maxDebit + " pays " + min + " to " + "Person " + maxCredit);
		
		minCashFlow(amount);
	}
	
	static int minof2(int x,int y) {
		return x < y ? x:y;
	}
	
	static int getMax(int arr[]) {
		int maxIndex = 0;
		int n = arr.length;
		for(int i=1;i<n;i++) {
			if(arr[i] > arr[maxIndex])
				maxIndex = i;
		}
		return maxIndex;
	}
	
	static int getMin(int arr[]) {
		int minIndex = 0;
		int n = arr.length;
		for(int i=1;i<n;i++) {
			if(arr[i] < arr[minIndex])
				minIndex = i;
		}
		return minIndex;
	}

}
