package javanetwork.multiecho.lec;

import java.io.PrintWriter;
import java.util.ArrayList;

public class MySharedObj implements Runnable{

	// Singleton 형태의 공용 객체 생성.
	private static MySharedObj obj = new MySharedObj();
	// 객체 안에서 사용할 자료구조 : ArrayList<Runnable>
	private ArrayList<Runnable> tList = new ArrayList<Runnable>();
	private ArrayList<PrintWriter> prList = new ArrayList<PrintWriter>();
	
	private MySharedObj() {
		
	}
	
	public static MySharedObj getObj() {
		return obj;
	}
	
	public void put(Runnable r) {
		tList.add(r);
	}
	
	public void put(PrintWriter pr) {
		prList.add(pr);
	}
	
	public ArrayList<PrintWriter> get() {
		return this.prList;
	}
	@Override
	public void run() {
		
		for(int i=0; i<prList.size(); i++) {
			prList.get(i);
		}
		
		
	}
	
}
