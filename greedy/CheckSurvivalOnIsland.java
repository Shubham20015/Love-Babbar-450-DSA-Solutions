package internship.greedy;

import java.util.Scanner;

public class CheckSurvivalOnIsland {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int s = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int ans = survivalOrNot(s,n,m);
		
		System.out.println(ans == 1 ? "No 0" : "Yes " + ans);
		
		sc.close();
	}
	
	static int survivalOrNot(int survivalDays,int totalFood,int reqdEachDay) {
		// If we can not buy at least a week
        // supply of food during the first
        // week OR We can not buy a day supply
        // of food on the first day then we
        // can't survive.
		if((reqdEachDay*7 > totalFood*6) && survivalDays > 6 || reqdEachDay > totalFood)
			return 0;
		int days = (reqdEachDay*survivalDays)/totalFood;
		if((reqdEachDay*survivalDays)%totalFood != 0)
			days++;
		return days;
	}
}
