package json;

import org.json.JSONObject;

public class JsonParsing01 {
	public static void main(String[] args) {
		String jsonString = "{\"title\":\"제목1\",\"content\":\"내용1\"}";
		
		JSONObject jObject = new JSONObject(jsonString);
		
		String title = jObject.getString("title");
		String content = jObject.getString("content");
		
		System.out.println("title= "+title);
		System.out.println("content= "+content);
		
//		StringBuffer s = new StringBuffer("asdf");
//		s.append("asdsssf");
//		System.out.println(s.toString());
//		s.insert(0, "zzzzz");
//		System.out.println(s.toString());
	}
}
