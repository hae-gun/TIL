package class04_static;

class Document {
	static int count = 0;
	static int totalCount = 0;

	String title;

	public Document() {
		this("제목없음 " + ++count);
	}

	public Document(String title) {
		totalCount++;
		this.title = title;
		System.out.println("문서: " + this.title + "이 생성되었음.");
	}
}

public class DocumentEx {
	public static void main(String[] args) {
		Document doc1 = new Document();
		Document doc2 = new Document("java.txt");
		Document doc3 = new Document();
		Document doc5 = new Document("jsp.txt");
		
		System.out.println("총 출력 문서수: "+Document.totalCount);
	}
}
