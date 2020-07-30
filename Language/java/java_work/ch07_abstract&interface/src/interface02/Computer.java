package interface02;

public class Computer implements Searchable {

	@Override
	public void search(String URL) {
		// TODO Auto-generated method stub
		System.out.println("인터넷으로 " + URL + " 검색");
	}

}
