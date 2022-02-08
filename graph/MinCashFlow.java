package internship.graph;

import java.util.Scanner;

public class MinCashFlow {
	
	private static int getMin(int arr[],int N) {
		int mini = 0;
		for(int i=0;i<N;i++) {
			if(arr[i] < arr[mini])
				mini = i;
		}
		
		return mini;
	}
	
	private static int getMax(int arr[],int N) {
		int maxi = 0;
		for(int i=0;i<N;i++) {
			if(arr[i] > arr[maxi])
				maxi = i;
		}
		
		return maxi;
	}
	
	private static void cashFlowUtil(int netAmount[],int N) {
		int maxDebit = getMin(netAmount,N),maxCredit = getMax(netAmount,N);
		
		if(maxDebit == 0 && maxCredit == 0)
			return ;
		
		int minAmount = Math.min(-netAmount[maxDebit], netAmount[maxCredit]);
		netAmount[maxCredit] -= minAmount;
		netAmount[maxDebit] += minAmount;
		
		System.out.println("Person " + maxDebit + " pays " + minAmount + " to person " + maxCredit);
		
		cashFlowUtil(netAmount,N);
	}
	
	public static void minCash(int graph[][],int N) {
		int netAmount[] = new int[N];
		
		for(int p=0;p<N;p++) {
			for(int i=0;i<N;i++) {
				netAmount[p] += graph[i][p] - graph[p][i]; 
			}
		}
		
		cashFlowUtil(netAmount,N);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int graph[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				graph[i][j] = sc.nextInt();
			}
		}
		
		minCash(graph,n);
		
		sc.close();
	}

}
