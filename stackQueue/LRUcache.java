package internship.stackQueue;

import java.util.*;

public class LRUcache {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int capacity = sc.nextInt();
        int queries = sc.nextInt();
        LRUcache cache = new LRUcache(capacity);
        
        String s = sc.next();
        String str[] = s.trim().split(" ");
        int len = str.length;
        int itr = 0;

        for (int i = 0; (i < queries) && (itr < len); i++) {
            String queryType = str[itr++];
            if (queryType.equals("SET")) {
                int key = Integer.parseInt(str[itr++]);
                int value = Integer.parseInt(str[itr++]);
                cache.set(key, value);
            }
            if (queryType.equals("GET")) {
                int key = Integer.parseInt(str[itr++]);
                System.out.println(cache.get(key) + " ");
            }
        }

        sc.close();
	}
	
	private Map<Integer,Integer> map;
    private int capacity;
   
    LRUcache(int cap)
    {
        map = new LinkedHashMap<>();
        capacity = cap;
    }

    public int get(int key)
    {
        if(!map.containsKey(key))
            return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key,value);
        return value;
    }

    public void set(int key, int value)
    {
        if(map.containsKey(key)){
            map.remove(key);
            map.put(key,value);
            return ;
        }else if(map.size() == capacity){
            Map.Entry<Integer,Integer> e = map.entrySet().iterator().next();
            int k = e.getKey();
            map.remove(k);
            map.put(key,value);
        }
        map.put(key,value);
    }

}
