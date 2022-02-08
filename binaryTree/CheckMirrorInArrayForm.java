package internship.binaryTree;

import java.util.*;

public class CheckMirrorInArrayForm {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int e = sc.nextInt();
		
		int arr[] = new int[2*e];
		int brr[] = new int[2*e];
		
		for(int i= 0;i<2*e;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i= 0;i<2*e;i++) {
			brr[i] = sc.nextInt();
		}
		
		System.out.println(checkMirrorTree(n,e,arr,brr));
			
		sc.close();
	}
	
	static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        HashMap<Integer,Stack<Integer>> map = new HashMap<>();
        
        for(int i=0;i<A.length;i+=2){
            if(!map.containsKey(A[i])){
                Stack<Integer> stack = new Stack<>();
                stack.add(A[i+1]);
                map.put(A[i],stack);
            }
            else{
                map.get(A[i]).add(A[i+1]);
            }
        }
        
        int flag = 1;
        
        for(int i=0;i<B.length;i+=2){
            if(map.containsKey(B[i])){
                if(B[i+1] == map.get(B[i]).peek()){
                    map.get(B[i]).pop();
                    flag = 1;
                }else{
                    flag = 0;
                    break;
                }
            }
            else{
                flag = 0;
                break;
            }
        }
        
        return flag;
    }
}
