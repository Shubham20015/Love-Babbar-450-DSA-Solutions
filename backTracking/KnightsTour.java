package internship.backTracking;

import java.util.Scanner;

public class KnightsTour {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
		 
		 int n = sc.nextInt();
		 tour(n);
		 
		 sc.close();
	}
	
	static boolean tour(int n) {
		int sol[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				sol[i][j] = -1;
			}
		}
		
		sol[0][0] = 0;
		
		int move_x[] = {-2,-1,1,2,2,1,-1,-2};
		int move_y[] = {1,2,2,1,-1,-2,-2,-1};
		
		if(!solve(0,0,1,sol,move_x,move_y,n)){
			System.out.println("Impossible for knight to travel every cell of board");
			return false;
		}else {
			printSolution(sol);
			return true;
		}
	}
	
	static void printSolution(int sol[][])
    {
		int n = sol.length;
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++)
                System.out.print(sol[x][y] + " ");
            System.out.println();
        }
    }
	
	static boolean solve(int i,int j,int move_i,int sol[][],int move_x[],int move_y[],int n) {
		
		if(move_i == n*n)
			return true;
		
		for(int k=0;k<8;k++) {
			int x = i + move_x[k];
			int y = j + move_y[k];
			
			if(isSafe(x,y,sol,n)) {
				sol[x][y] = move_i;
				if(solve(x,y,move_i+1,sol,move_x,move_y,n)) return true;
				sol[x][y] = -1;
			}
		}
		
		return false;
	}
	
	static boolean isSafe(int x,int y,int sol[][],int n) {
		return (x >= 0 && y >= 0 && x < n && y < n && sol[x][y] == -1);
	}

}
