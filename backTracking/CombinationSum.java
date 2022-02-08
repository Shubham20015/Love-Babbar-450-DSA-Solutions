package internship.backTracking;

import java.util.*;

public class CombinationSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int sum = sc.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			A.add(sc.nextInt());
		}
		
		ArrayList<ArrayList<Integer>> res = combinationSum(A, sum);
		
		for(ArrayList<Integer> temp : res) {
			for(int val : temp) {
				System.out.print(val+" ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B)
    {
        HashSet<Integer> hs = new HashSet<>(A);
        A = new ArrayList<Integer>(hs);
        Collections.sort(A);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(A,B,new Stack<Integer>(),ans,0);
        return ans;
    }
    
    static void solve(ArrayList<Integer> A,int B,Stack<Integer> arr,ArrayList<ArrayList<Integer>> ans,int index){
        if(B == 0){
            ans.add(new ArrayList<Integer>(arr));
            return ;
        }
        
        if(index == A.size())
            return ;
        
        if(B - A.get(index) >= 0){
            arr.push(A.get(index));
            solve(A,B-A.get(index),arr,ans,index);
            arr.pop(); // backtracking
        }else{
            solve(A,B,arr,ans,index+1);
        }
    }

}
