package internship.greedy;

import java.io.*;
import java.util.*;

public class ArrangeAmplifiers {
	
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
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int n = sc.nextInt();
			long arr[] = new long[n];
			int count1 = 0,count = 0,j = 0;
			
			for(int i=0;i<n;i++) {
				long x = sc.nextLong();
				if(x == 1)
					count1++;
				else {
					arr[j++] = x;
					count++;
				}
			}

			Arrays.sort(arr);
			
			for (int i=0;i<count1; i++)
				System.out.print("1 ");
	        if (count==2 && arr[0]==2 && arr[1]==3)
	        	System.out.print(2 + " " + 3);
	        else {
	        	for (int i=count-1;i>=0;i--)
	        		System.out.print(arr[i] + " ");
	        }
			System.out.println();
		}
	}
}
