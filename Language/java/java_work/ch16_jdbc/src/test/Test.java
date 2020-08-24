package test;

import java.util.HashMap;

public class Test {
	public static void main(String[] args) {
		
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = { "stanko", "ana", "mislav"};
		
				
				
		String answer = "";
		
		HashMap<String, Integer> map = new HashMap<>();
        for(String s:participant){
        	map.computeIfPresent(s, (String key, Integer value)->++value);
        	map.computeIfAbsent(s, key->1);
        	
//            if(!map.containsKey(s))
//                map.put(s,1);
//            else
//                map.put(s,map.get(s)+1);
        	
        }
        for(String s:completion){
            if(map.containsKey(s))
               map.put(s,map.get(s)-1);
        }
        for(String s:map.keySet()) {
        	if(map.get(s)!=0) {
        		answer=s;
        	}
        }
	        
	        System.out.println(answer);
	        
		
	}
}
