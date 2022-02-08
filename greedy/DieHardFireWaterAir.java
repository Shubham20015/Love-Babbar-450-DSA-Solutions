package internship.greedy;

import java.util.Scanner;

public class DieHardFireWaterAir {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-->0) {
			int h = sc.nextInt();
			int a = sc.nextInt();
			
			System.out.println(diehard(h, a));
		}
		
		sc.close();

	}
	
	static long diehard(int health,int armor) {
		long time = 0;
		while(true) {
			if(time%2 == 0) {
				health += 3;
				armor += 2;
			}else {
				if(armor > 10) {
					health -= 5; 
					armor -= 10;
				}else {
					health -= 20; 
					armor += 5;
				}
			}
			
			if(health > 0 && armor > 0)
				time++;
			else
				break;
		}
		return time;
	}
}
