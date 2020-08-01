package api07_system;

import java.util.Properties;
import java.util.Set;

public class SystemProperty {
	public static void main(String[] args) {
		
		String osName = System.getProperty("os.name");
		System.out.println(osName);
		System.out.println(System.getProperty("java.version"));
		System.out.println(System.getProperty("java.home"));
		System.out.println(System.getProperty("user.name"));
		System.out.println(System.getProperty("user.home"));
		
		System.out.println(System.getProperty("user.dir"));
		System.out.println(System.getProperty("file.separator"));
		System.out.println(System.getProperty("file.encoding"));
		
		System.out.println("===========================");
		//  Properties type : key value 형태로가져온다. map형태
		Properties props = System.getProperties();
		
		Set set = props.keySet();
		for(Object s : set) {
			String k = (String)s;
			System.out.println(k);
		}
	}
}
