package internship.greedy;

import java.util.*;

public class DefenseOfKingdom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int width = sc.nextInt();
			int height = sc.nextInt();
			int n = sc.nextInt();
			
			ArrayList<Integer> x = new ArrayList<>();
			ArrayList<Integer> y = new ArrayList<>();
			
			x.add(0);
			y.add(0);
			
			for(int i=0;i<n;i++) {
				int xCord = sc.nextInt();
				int yCord = sc.nextInt();
				x.add(xCord);
				y.add(yCord);
			}
			
			x.add(width+1);
			y.add(height+1);
			
			Collections.sort(x);
			Collections.sort(y);
			
			int maxWidth = 0,maxHeight = 0;
			int len = x.size()-1;
			for(int i=0;i<len;i++) {
				maxWidth = Math.max(maxWidth,x.get(i+1) - x.get(i)-1);
				maxHeight = Math.max(maxHeight,y.get(i+1) - y.get(i)-1);
			}
			
			System.out.println(maxWidth*maxHeight);
		}
		
		sc.close();
	}
}
