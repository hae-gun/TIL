package properties;

import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesEx {
	public static void main(String[] args) throws Exception {

		Properties props = new Properties();
		props.setProperty("아침", "갈비탕");
		props.setProperty("점심", "도미회");
		props.setProperty("저녁", "티본스테이크");
		props.setProperty("야식", "지중해식 셀러드");
		System.out.println(props); // map 이랑 동일. 단지 메소드만 다름.

		try {
			props.store(new FileWriter("menu.properties"), "오늘메뉴");
			props.storeToXML(new FileOutputStream("menu.xml"), "오늘메뉴");

		} catch (IOException e) {
			e.printStackTrace();
		}

		Properties db = new Properties();
		String path = PropertiesEx.class.getResource("database.properties").getPath();

		path = URLDecoder.decode(path, "utf-8");
		db.load(new FileReader(path));

		String driver = db.getProperty("driver");
		String url = db.getProperty("url");
		String username = db.getProperty("username");
		String password = db.getProperty("password");

		System.out.println("driver: " + driver);
		System.out.println("url: " + url);
		System.out.println("username: " + username);
		System.out.println("password: " + password);

	}

}
