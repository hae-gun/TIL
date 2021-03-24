package normal;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Json {
	public static void main(String[] args) {
		String str = "{\"abc\":\"aaa\",\"aaa\":[{\"aaa\":[{\"aaa\":{\"aaa\":{\"x\":1,\"y\":12},\"aa\":{\"g\":2,\"a\":2},\"sa\":{\"type\":\"aaa\",\"aaa\":[[[[2],[13],[1],[1],[1],[1],[1]]]]},\"aaa\":[[9]]},\"aaaa\":\"aaa\",\"aaa\":\"aaa\",\"aaa\":\"aaa\",\"siDo\":\"aaa\",\"aaa\":\"aaa\",\"aaa\":\"aaa-5\",\"aaa\":false,\"aaa\":false,\"fullAddress\":\"ggomjae\",\"aaa\":\"aaa\",\"aaa\":\"부산진구\"}],\"aaa\":[]}]}";
//		str = str.replaceAll("\"", "'");
//		System.out.println(str);
//		System.out.println(str);
		JSONParser parser = new JSONParser();
		try {
//			JSONArray jsonArr = (JSONArray) parser.parse(str);
			JSONObject obj =  (JSONObject) parser.parse(str);
			System.out.println(obj);
//			System.out.println(jsonArr.get(index));
		}catch(Exception e) {
			System.out.println(e);
		}
		
		
	}
}
