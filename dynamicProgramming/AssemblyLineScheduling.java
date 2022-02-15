package internship.dynamicProgramming;

public class AssemblyLineScheduling {
	
//	TC: O(N) , SC: O(N)
	static int scheduling(int a[][],int t[][],int entry[],int exit[],int noOfStations) {
		int time1[] = new int[noOfStations];
		int time2[] = new int[noOfStations];
		
		time1[0] = entry[0] + a[0][0];
		time2[0] = entry[1] + a[1][0];
		
		for(int i=1;i<noOfStations;i++) {
			time1[i] = Math.min(time1[i-1] + a[0][i], time2[i-1] + t[1][i] + a[0][i]);
			time2[i] = Math.min(time2[i-1] + a[1][i], time1[i-1] + t[0][i] + a[1][i]);
		}
		
		return Math.min(time1[noOfStations-1] + exit[0], time2[noOfStations-1] + exit[1]);
	}
	
//	TC: O(N) , SC: O(1)
	static int schedulingOP(int a[][],int t[][],int entry[],int exit[],int noOfStations) {
		
		int firstLine = entry[0] + a[0][0];
		int secondLine = entry[1] + a[1][0];
		
		for(int i=1;i<noOfStations;i++) {
			int up = Math.min(firstLine + a[0][i], secondLine + t[1][i] + a[0][i]);
			int down = Math.min(secondLine + a[1][i], firstLine + t[0][i] + a[1][i]);
			
			firstLine = up;
			secondLine = down;
		}
		
		return Math.min(firstLine + exit[0], secondLine + exit[1]);
	}

	public static void main(String[] args) {
	int a[][] = {{4, 5, 3, 2},
                {2, 10, 1, 4}};
    int t[][] = {{0, 7, 4, 5},
                {0, 9, 2, 8}};
    int e[] = {10, 12}, x[] = {18, 7};
    
    System.out.println("Time required to build a car: " + scheduling(a,t,e,x,4));
    System.out.println("Time required to build a car: " + schedulingOP(a,t,e,x,4));
	}

}
