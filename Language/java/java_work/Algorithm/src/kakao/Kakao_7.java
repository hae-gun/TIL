package kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Kakao_7 {
	public static void main(String[] args) {

//		int[] sales = { 14, 17, 15, 18, 19, 14, 13, 16, 28, 17 };
		int[] sales = {5, 6, 5, 3, 4};
		
//		int[][] links = { { 10, 8 }, { 1, 9 }, { 9, 7 }, { 5, 4 }, { 1, 5 }, { 5, 10 }, { 10, 6 }, { 1, 3 },
//				{ 10, 2 } };

		int[][] links = {{2,3}, {1,4}, {2,5}, {1,2}};
		int a = solution(sales, links);
		System.out.println(a);

	}
//	static final int LEAP = 654321;

	public static int solution(int[] sales, int[][] links) {
		int answer = 0;

		boolean[] attempt = new boolean[sales.length + 1];

		TreeNode[] trees = new TreeNode[sales.length + 1];
		trees[0] = new TreeNode();

		// 노드별 하루평균 매출액 주입
		for (int i = 1; i < sales.length + 1; i++) {
			trees[i] = new TreeNode(i, sales[i - 1]);
		}

		// 트리 만들기
		for (int[] tr : links) {
			trees[tr[0]].tail.add(tr[1]);
			trees[tr[1]].head = tr[0];

		}

		// 팀장설정. 각 노드에서 tail이 있으면 팀장이다
		// idx는 팀갯수
		int idx = 1;
		for (TreeNode t : trees) {
			// 자식 노드가 있는 경우
			if (t.tail.size() > 0) {
				t.depart.add(idx);
				for (int treeIdx : t.tail) {
					// 자식 노드에게도 팀 부여
					trees[treeIdx].depart.add(idx);
				}
				idx++;
			}
		}

		HashMap<Integer, ArrayList<TreeNode>> departments = new HashMap<Integer, ArrayList<TreeNode>>();
		// 팀별 셀러리 해쉬맵 설정
		for (TreeNode t : trees) {
			for (int teamNumber : t.depart) {
				if (departments.containsKey(teamNumber)) {
					departments.get(teamNumber).add(t);
				} else {
					ArrayList<TreeNode> team = new ArrayList<TreeNode>();
					team.add(t);
					departments.put(teamNumber, team);
				}
			}

		}

		for (int i = 1; i <= departments.size(); i++) {
//			int minSal = 987654321;
//			int minIdx = 0;
//			System.out.println(i + "번 부서 최저시급");

//			System.out.println(departments.get(i));

			// sal 순으로 정
			Object[] obj = departments.get(i).stream().sorted().toArray();
//			System.out.println("-----");

			LinkedList<TreeNode> ttmp = new LinkedList<TreeNode>();
			
			for (Object sss : obj) {
				ttmp.addLast((TreeNode) sss);
			}
			int[] member = new int[ttmp.size()];
//			System.out.println(ttmp);
			
			for (int j = 0; j < member.length; j++) {
				member[j] = ttmp.get(j).num;
//				System.out.println(member[j]);
			}
//			System.out.println("----");
			
			
			boolean flag = true;
			
			for (int m : member) {
				if (attempt[m]) {
					flag = false;
					break;
				}
			}

//			for(boolean b: attempt) {
////				System.out.print(b+" ");
//			}
//			System.out.println("\n"+flag);
			
			
			if (flag) {
				TreeNode tmp = ttmp.removeFirst();
				attempt[tmp.num] = true;
			}
			
//			while(!ttmp.isEmpty()) {
//				if(!attempt[tmp.num]) {
//					attempt[tmp.num] = true;
//					break;
//				}else {
//					
//				}				
//			}
			for(boolean b: attempt) {
				System.out.print(b+" ");
			}
			System.out.println("\n-------");
			
		}
//        int 
		
		
		
		
//		for (TreeNode t : trees) {
//			System.out.println(t);
//		}
		answer = 0;
		for (int i = 0; i < attempt.length; i++) {
			if (attempt[i]) {
				answer += trees[i].sal;
			}
		}
		
		HashMap<Integer,TreeNode> tttmap = new HashMap<Integer, TreeNode>();
		int ifSum = 0;
		for(TreeNode t: trees) {
			System.out.println(t);
			if(t.depart.size()>=2) {
				tttmap.put(t.num,t);
			}
		}
		for(TreeNode t: tttmap.values()) {
			ifSum += t.sal;
		}
		
//		System.out.println(ifSum);
//		System.out.println(tttmap);
		
		answer = Math.min(answer, ifSum);
		
//		System.out.println(answer);
		return answer;
	}
}

class TreeNode implements Comparable<TreeNode> {
	// head = 0 .. 사장 root
	int head = 0;

	// tail = 654321 .. leap
//	int tail = 654321;
	ArrayList<Integer> tail = new ArrayList<Integer>();
	int num;

	ArrayList<Integer> depart = new ArrayList<Integer>();
	int sal;

	public TreeNode() {
	}

	public TreeNode(int num, int sal) {
		this.num = num;
		this.sal = sal;
	}

	public int getSal() {
		return this.sal;
	}

	@Override
	public int compareTo(TreeNode o) {
		// TODO Auto-generated method stub
		return Integer.compare(this.sal, o.sal);
	}

	@Override
	public String toString() {
		return "TreeNode [head=" + head + ", tail=" + tail + ", num=" + num + ", depart=" + depart + ", sal=" + sal
				+ "]";
	}
}