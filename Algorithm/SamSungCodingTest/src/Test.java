import java.util.HashMap;
import java.util.LinkedList;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			String s1 = "abcd efg";
			
			LinkedList<String> s= new LinkedList<String>();
			s.addFirst(s1);
			System.out.println(s1.contains("abcd"));
			
			HashMap<String[],String[]> set = new HashMap<String[], String[]>();
			String[] b1 = {"ab","cd"};
			String[] b2 = {"11","22"};
			set.put(b1, b2);
			
			
			System.out.println(set.containsKey("ab"));
			
			
 			
	}

}
