package internship.stackQueue;

import java.util.Stack;
import java.util.Scanner;

// Question description states that everybody knows celebrity but celebrity does not know anyone to recognise as celebrity 
// and doesn't compulsory that there is any celebrity in party

public class CelebrityProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int M[][] = new int[n][n];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
//				if(i == j)
//					M[i][j] = 0;
//				else
				M[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(celebrity(M,n) == -1 ? -1:1);
		System.out.println(findcelebrity(M,n) == -1 ? -1:1);
		
		sc.close();
	}
	
//  TC: O(n) , SC:O(n)
	static int celebrity(int M[][], int n)
    {
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<n;i++){
            stack.push(i);
        }
        
        while(stack.size() > 1){
            int i = stack.pop();
            int j = stack.pop();
            
            if(M[i][j] == 1){
                stack.push(j); // here i knows j so i is not celebrity
            }else{
                stack.push(i); // here i doesn't knows j so j is not celebrity
            }
        }
        int pot = stack.pop(); // potential candidate
        
        for(int i=0;i<n;i++){
            if(i != pot && M[i][pot] == 0 || M[pot][i] == 1) // checks condition if i doesn't know potential candidate or if potential candidate know i
                return -1;
        }
        return pot;
    }
    
//  TC: O(n) , SC:O(1)
    static int findcelebrity(int M[][], int n)
    {
        int s = 0;
        int e = n-1;
        
        while(s<e){ //check for 1 means celebrity(i.e if everybody know this celebrity) in rows and if dont get then change person(i.e if anyone is 1) in columns
            if(M[s][e] == 1){ 
                s++;
            }else{
                e--;
            }
        }
        
        for(int i=0;i<n;i++){
            if(i != s && M[i][s] == 0 || M[s][i] == 1)
                return -1;
        }
        return s;
    }

}
