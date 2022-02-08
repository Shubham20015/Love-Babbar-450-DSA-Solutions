package internship.string;

import java.util.*;

public class AnagramsTogether {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str_list[] = new String[n];
		
		for(int i=0;i<n;i++) {
			str_list[i] = sc.next();
		}
		
		HashMap<String,List<String>> map = new HashMap<>();
        
        for(String str : str_list){
            char arr[] = str.toCharArray();
            Arrays.sort(arr);
            String temp = String.valueOf(arr);
            
            if(!map.containsKey(temp))
                map.put(temp,new ArrayList<>());
            
            map.get(temp).add(str);
        }
        
        List<List<String>> ans = new ArrayList<>(map.values());
		
		for(int i=0;i<ans.size();i++) {
			for(int j=0;j<ans.get(0).size();j++) {
				System.out.print(ans.get(i).get(j) + " ");
			}
			System.out.println();
		}
		
		sc.close();

	}

}
