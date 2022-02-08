package internship.greedy;

import java.io.*;
import java.util.*;

public class PickUpChicks {
	
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 

	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int c = sc.nextInt();
		for(int j=1;j<=c;j++) {
			int noOfChicks = sc.nextInt();
			int kchicksReqd = sc.nextInt();
			long barn = sc.nextLong();
			int time = sc.nextInt();
			
			long position[] = new long[noOfChicks];
			int speed[] = new int[noOfChicks];
			
			for(int i=0;i<noOfChicks;i++) {
				position[i] = sc.nextLong();
			}
			for(int i=0;i<noOfChicks;i++) {
				speed[i] = sc.nextInt();
			}
			
			int count = 0,swaps = 0,not_possible = 0;
			for(int i=noOfChicks-1;i>=0;i--) {
				long distance_needed = barn - position[i];
				long distance_possible = speed[i]*time;
				
				if(distance_possible >= distance_needed) {
					count++;
					if(not_possible > 0)
						swaps += not_possible;
				}else {
					not_possible++;
				}
				
				if(count >= kchicksReqd)
					break;
			}
			
			if(count >= kchicksReqd)
				System.out.println("Case #" + j + ": " + swaps);
			else
				System.out.println("Case #" + j + ": " + "IMPOSSIBLE");
		}
	}

}
