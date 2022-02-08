package internship.backTracking;

import java.util.*;

public class Nqueen {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> result = nQueen(n);
		for(ArrayList<Integer> arr : result) {
			System.out.print("[ ");
			for(int val : arr) {
				System.out.print(val + " ");
			}
			System.out.println("]");
		}
		
		sc.close();

	}
	
	static ArrayList<ArrayList<Integer>> nQueen(int n) {
        int board[][] = new int[n][n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        printNQueens(board,n,0,new ArrayList<Integer>(),ans);
        return ans;
    }
    
    static void printNQueens(int board[][],int n,int row,ArrayList<Integer> ds,ArrayList<ArrayList<Integer>> ans){
        if(row == board.length){
            ans.add(new ArrayList<Integer>(ds));
            return;
        }
        
        for(int col=0;col<board.length;col++){
            if(isSafePlace(board,row,col)){
                board[row][col] = 1;
                ds.add(col+1);
                printNQueens(board,n,row+1,ds,ans);
                board[row][col] = 0;
                ds.remove(ds.size()-1);
            }
        }
    }
    
    static boolean isSafePlace(int board[][],int row,int col){
        for(int i=row-1,j=col;i>=0;i--)
            if(board[i][j] == 1) return false;
        
        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--)
            if(board[i][j] == 1) return false;
            
        for(int i=row-1,j=col+1;i>=0 && j<board.length;i--,j++)
            if(board[i][j] == 1) return false;    
        return true;    
    }

}
