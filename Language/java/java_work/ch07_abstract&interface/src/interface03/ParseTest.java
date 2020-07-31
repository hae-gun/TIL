package interface03;

interface Parseable {
	void parse(String fileName);
}

class ParserManager {
	static Parseable getParser(String type) {
		if (type.equals("XML")) {
			return new XMLParser();
		} else {
			return new JSONParser();
		}
	}
}

class XMLParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.printf("%s - XML 문서 읽기 완료\n",fileName);
	}

}

class JSONParser implements Parseable {

	@Override
	public void parse(String fileName) {
		System.out.printf("%s - JSON 문서 읽기 완료\n",fileName);
	}

}

public class ParseTest {
	public static void main(String[] args) {
		Parseable ps = ParserManager.getParser("XML");
		System.out.println(ps);
		ps.parse("doc.XML");
	}
}


