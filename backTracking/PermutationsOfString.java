package internship.backTracking;

import java.util.*;

public class PermutationsOfString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		
		List<String> res = find_permutation(str);
		
		for(String val : res) {
			System.out.print(val + " ");
		}
		
		sc.close();

	}
	
	static List<String> find_permutation(String S) {
        List<String> list = new ArrayList<>();
        solve(S,0,S.length()-1,list);
        Collections.sort(list);
        return list;
    }
    
    static void solve(String S,int low,int high,List<String> list){
        if(low == high){
            list.add(S);
            return ;
        }
        for(int i=low;i<=high;i++){
            solve(swap(S,low,i),low + 1,high,list);
        }    
    }
    
    static String swap(String S,int i,int j){
        char arr[] = S.toCharArray();
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return String.valueOf(arr);
    }

}
