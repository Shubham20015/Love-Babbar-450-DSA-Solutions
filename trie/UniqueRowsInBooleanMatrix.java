package internship.trie;

import java.util.*;

public class UniqueRowsInBooleanMatrix {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		int matrix[][] = new int[n][m];
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
//		ArrayList<ArrayList<Integer>> res = uniqueRow(matrix,n,m);
		ArrayList<ArrayList<Integer>> res = uniqueRowInM(matrix,n,m);
		
		for(ArrayList<Integer> list: res) {
			for(int val : list) {
				System.out.print(val + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
	
	static ArrayList<ArrayList<Integer>> uniqueRow(int a[][],int r, int c)
    {
        HashSet<String> set = new HashSet<String>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<r;i++){
            String str = "";
            ArrayList<Integer> list = new ArrayList<>();
            for(int j=0;j<c;j++){
                str += a[i][j];
                list.add(a[i][j]);
            }
            if(set.contains(str))
                continue;
            res.add(list);
            set.add(str);
        }
        
        return res;
    }
	
	static class TrieNode{
		TrieNode links[] = new TrieNode[2];
		int endNode = 0;
		
		boolean containsKey(int x) {
			return links[x] != null;
		}
		
		void put(int x,TrieNode node) {
			links[x] = node;
		}
		
		TrieNode get(int x){
			return links[x];
		}
	}
	
	static TrieNode root;
	
	static void solve(int row,int col,int matrix[][],ArrayList<ArrayList<Integer>> res) {
		ArrayList<Integer> temp = new ArrayList<>();
		TrieNode curr = root;
		for(int i=0;i<col;i++) {
			int val = matrix[row][i];
			temp.add(val);
			if(!curr.containsKey(val)) {
				curr.put(val, new TrieNode());
			}
			curr = curr.get(val);
		}
		curr.endNode++;
		if(curr.endNode == 1) {
			res.add(temp);
		}
	}
	
	static ArrayList<ArrayList<Integer>> uniqueRowInM(int matrix[][],int r, int c)
    {
		root = new TrieNode(); 
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        for(int i=0;i<r;i++) {        	
        	solve(i,c,matrix,res);
        }
        
        return res;
    }

}
