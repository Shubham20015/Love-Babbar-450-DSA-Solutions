package internship.backTracking;

import java.util.Scanner;

public class SudokoSolver {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int grid[][] = new int[9][9];
		
		for(int i=0;i<9;i++) {
			for(int j =0;j<9;j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		if(SolveSudoku(grid)) {
			for(int i=0;i<9;i++){
	            for(int j=0;j<9;j++) {
	                System.out.print(grid[i][j] + " ");
	            }
	            System.out.println();
	        }
		}else {
			System.out.println("Impossible to solve this sudoku");
		}
		
		sc.close();
	}
	
//	TC: O(9^(N*N)) , SC: O(N*N)
	static boolean SolveSudoku(int grid[][])
    {
        int row = -1,col = -1;
        boolean isEmpty = true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(grid[i][j] == 0){
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if(!isEmpty){
                break;
            }
        }
        
        if(isEmpty){
            return true;
        }
        
        for(int num=1;num<=9;num++){
           if(isSafe(grid,row,col,num)){
               grid[row][col] = num;
               if(SolveSudoku(grid)) return true;
               grid[row][col] = 0;
            } 
        }
        
        return false;
    }
    
    static boolean isSafe(int grid[][],int row,int col,int num){
        for(int i=0;i<9;i++){
            if(grid[row][i] == num && i != col  || grid[i][col] == num && i != row)
                return false;
        }
        
        int RStart = row - (row%3);
        int CStart = col - (col%3);
        
        for(int r=RStart;r<RStart+3;r++){
            for(int c=CStart;c<CStart+3;c++){
                if(grid[r][c] == num)
                    return false;
            }  
        }
        
        return true;
    }

}
