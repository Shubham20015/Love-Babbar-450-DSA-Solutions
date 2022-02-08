package internship.greedy;

import java.util.*;

public class MaxTrainsWhichStop {
	
	static class Train{
		int arrival;
		int departure;
		Train(int a,int d){
			arrival = a;
			departure = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int n = sc.nextInt(); // Platforms
		int m = sc.nextInt(); // Trains
		int arr[][] = new int[m][3];
		
		for(int i=0;i<m;i++) {
			int arrivalTime = sc.nextInt();
			int departureTime = sc.nextInt();
			int platform = sc.nextInt();
			arr[i][0] = arrivalTime;
			arr[i][1] = departureTime;
			arr[i][2] = platform;
		}
		
		System.out.println(maxTrainsStop(arr,n,m));
		
		sc.close();
	}
	
	@SuppressWarnings("unchecked")
	static int maxTrainsStop(int arr[][],int n,int m) {
		ArrayList<Train> record[] = new ArrayList[n+1];
		
		for (int i = 0; i < m; i++) {
			record[arr[i][2]] = new ArrayList<Train>();
        }
		
		for(int i=0;i<m;i++) {
			record[arr[i][2]].add(new Train(arr[i][0],arr[i][1]));
		}
		
		for(int i=1;i<=n;i++) {
			Collections.sort(record[i],(Train a,Train b) -> a.departure - b.departure);
		}
		
		int count = 0;
		
		for(int i=1;i<=n;i++) {
//			if(record[i].size() == 0)
//				continue;
			int x = 0;
			count++;
			for(int j=1;j<record[i].size();j++) {
				if(record[i].get(j).departure >= record[i].get(x).arrival) {
					x = j;
					count++;
				}
			}
		}
		
		return count;
	}
	

}
