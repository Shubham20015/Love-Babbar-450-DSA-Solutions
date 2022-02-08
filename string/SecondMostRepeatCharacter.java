package internship.string;

import java.util.*;

public class SecondMostRepeatCharacter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String arr[] = new String[N];
		
		for(int i=0;i<N;i++) {
			arr[i] = sc.next();
		}
		
		HashMap<String,Integer> map = new HashMap<>();
        
        for(int i=0;i<N;i++){
            map.put(arr[i],map.getOrDefault(arr[i],1)+1);
        }
        
        int max = 0,secondMax = 0;
        
        for(Map.Entry<String,Integer> val: map.entrySet()){
            int value = val.getValue();
            if(value > max){
                secondMax = max;
                max = value;
            }
            else if (value > secondMax && value != max)
                secondMax = value;
        }

        String ans = "";
        
        for(Map.Entry<String,Integer> val: map.entrySet()){
            if(val.getValue()  == secondMax){
                ans = val.getKey();
            }
        }
        
        System.out.println(ans);
		
		sc.close();
	}

}
