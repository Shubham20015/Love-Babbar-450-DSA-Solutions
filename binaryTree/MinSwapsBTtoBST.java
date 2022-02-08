package internship.binaryTree;

import java.util.*;

public class MinSwapsBTtoBST {
	
	static class Pair{
		int first,second;
		Pair(int a,int b){
			first = a;
			second = b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int arr[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i] = sc.nextInt();
		}
		
		inorder(arr,n,0);
		
		System.out.print(maxSwaps());
		
		sc.close();
	}
	
	static ArrayList<Integer> list = new ArrayList<>();
	
	static void inorder(int arr[],int n,int index) {
		if(index >= n) return;
		inorder(arr,n,2*index+1);
		list.add(arr[index]);
		inorder(arr,n,2*index+2);
	}
	
	static int maxSwaps() {
		int n = list.size();
		ArrayList <Pair> arrpos = new ArrayList <Pair> ();
		for(int i=0;i<n;i++) {
			arrpos.add(new Pair(list.get(i),i));
		}
		
		arrpos.sort((Pair o1,Pair o2) -> o1.first - o2.first);
		
		Boolean[] visited = new Boolean[n];
        Arrays.fill(visited, false);
        int ans = 0;
        
        for(int i=0;i<n;i++) {
        	if(visited[i] || arrpos.get(i).first == i) continue;
        	
        	int cycle_size = 0;
        	int j = i;
        	
        	while(!visited[j]) {
        		visited[j] = true;
        		j = arrpos.get(j).second;
        		cycle_size++;
        	}
        	
        	if(cycle_size > 0) {
        		ans += (cycle_size - 1); 
        	}
        }
        
        return ans;
	}
}
