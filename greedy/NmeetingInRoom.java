package internship.greedy;

import java.util.*;

public class NmeetingInRoom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int start[] = new int[n];
		int end[] = new int[n];
		
		for(int i=0;i<n;i++) {
			start[i] = sc.nextInt();
		}
		
		for(int i=0;i<n;i++) {
			end[i] = sc.nextInt();
		}
		
		System.out.println(maxMeetings(start,end,n));
		
		sc.close();
	}
	
	static class Pair{
        int arrival;
        int departure;
        Pair(int a,int d){
            arrival = a;
            departure = d;
        }
    }
   
    public static int maxMeetings(int start[], int end[], int n)
    {
        Pair meetings[] = new Pair[n];
        for(int i=0;i<n;i++){
            meetings[i] = new Pair(start[i],end[i]);
        }
        Arrays.sort(meetings,(Pair a,Pair b) -> a.departure - b.departure);
        
        int i=0,j=1,count = 1;
        while(j<n){
            if(meetings[i].departure < meetings[j].arrival){
                i = j;
                count++;
            }
            j++;
        }
        return count;
    }

}
