package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Nodes {
	class Node {

		int first;
		int second;
		boolean Check;

		Node(int first, int second) {
			this.first = first;
			this.second = second;
		}

	}
	Queue<Node> queue = new LinkedList<Node>();
	
	
}

public class Virus {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int node = br.read();
		int line = br.read();

		int[][] graph = new int[node][node];

//		Queue<Node> queue = new LinkedList<Node>();

		for (int i = 0; i < line; i++) {
			String[] s = br.readLine().split(" ");
			int first = Integer.valueOf(s[0]);
			int second = Integer.valueOf(s[1]);
//			queue.add(new Node(first, second));
			graph[first][second] = 1;
			graph[second][first] = 1;

		}

		bfs(graph, line);

	}

	static void bfs(int[][] graph, int line) {

	}
}
