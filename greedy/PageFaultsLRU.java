package internship.greedy;

import java.util.*;

public class PageFaultsLRU {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int capacity = sc.nextInt();
		int pages[] = new int[n];
		
		for(int i=0;i<n;i++) {
			pages[i] = sc.nextInt();
		}
		
		System.out.println(pageFaults(n,capacity,pages));
		
		sc.close();
	}
	
	static int pageFaults(int N, int C, int pages[]){
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i=0;i<N;i++){
            if(q.size() < C || q.contains(pages[i])){
                if(!q.contains(pages[i]))
                    count++;
                else
                    q.remove(pages[i]);
            }
            else{
                count++;
                q.poll();
            }
            q.add(pages[i]);
        }
        
        return count;
    }
}
