package graph;

import java.util.ArrayList;

class MyGraph{
	private ArrayList<ArrayList<Integer>> listGraph;
	
	// 그래프 초기화
	public MyGraph(int initSize) {
		this.listGraph = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<initSize; i++) {
			listGraph.add(new ArrayList<Integer>());
		}
		
	}
	
	
	
	
}

