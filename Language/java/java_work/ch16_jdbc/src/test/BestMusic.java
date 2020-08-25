package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class BestMusic {

	public static void main(String[] args) {
		String[] genres = { "pop","classic", "pop", "classic", "classic", "pop", "rock", "pop" };
		int[] plays = { 2500,500, 600, 150, 800, 2500, 2000, 2500 };
		int[] result = solution(genres, plays);

		for (int i : result)
			System.out.println(i);
	}

	public static int[] solution(String[] genres, int[] plays) {
		int[] answer = {};
		// 이 코드도 실패함.
		// 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
		// 위 조건을 체크하지 않았다.
		// 타입별 총합을 구하기 위한 맵
		HashMap<String, Integer> totalMap = new HashMap<>();

		// 갯수로 타입을 찾기위한 맵
		HashMap<Integer, String> findType = new HashMap<>();

		// 갯수의 인덱스를 구하기 위한 맵
		HashMap<Integer, Integer> answerMap = new HashMap<>();

		// totalMap,findType 초기화
		for (int i = 0; i < genres.length; i++) {

			String key = genres[i];
			Integer value = plays[i];
			answerMap.put(value, i);
			if (totalMap.containsKey(key)) {
				totalMap.put(key, totalMap.get(key) + value);
			} else {
				totalMap.put(key, value);
			}
		}

		// answerMap 초기화
		for (String key : totalMap.keySet()) {
			findType.put(totalMap.get(key), key);
		}

		System.out.println(totalMap);
		System.out.println(answerMap);

		// 총합 숫자를 정렬하기위한 배열
		int[] countSet = listToArray(totalMap.values());

		// 정렬
		Arrays.sort(countSet);

//		int[] test = {5,4,3,2,1};

		int length = countSet.length;

		// index를 저장할 리스트 구
		List<Integer> indexList = new ArrayList<Integer>();

		for (int index = 1; index <= length; index++) {
			// 일단 가장큰 수의 타입을 가져오기!
			String type = findType.get(countSet[length - index]);

			// 타입별 숫자를 저장할 리스트 구현
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i < genres.length; i++) {
				// 타입의 각 숫자를 가져오기.
				if (type.equals(genres[i])) {
					temp.add(plays[i]);
				}
			}
			
//			temp의 중복을 제거하기!
			HashMap<Integer,Integer> map = new HashMap();
			for(Integer i:temp) {
				map.put(i, 0);
			}
//			temp = (List<Integer>) map.keySet();
			// 가져온 리스트를 배열로 바꿔 정렬
			int[] intTemp = listToArray(map.keySet());
			Arrays.sort(intTemp);
			int arrayLength = intTemp.length;
			boolean flag = true;
			
			// 길이를 체크하여 2개이상이면 상위 2개를 가져오고 아니면 1개만 정답 리스트에 추가하기
			//여기서 문제 발생! 같은 타입은 같은값을 가질수 있어서 동일한 숫자가 두번 추가됨.
			if (arrayLength < 2) {
				indexList.add(answerMap.get(intTemp[0]));
			} else {
//				indexList.add(answerMap.get(intTemp[arrayLength - 1]));
//				indexList.add(answerMap.get(intTemp[arrayLength - 2]));
				for (int j = 1; j < 3; j++) {
					int putNum = 0;
					int compareNum = intTemp[arrayLength - j];
					for (int i = 0; i < plays.length; i++) {
						if (compareNum == plays[i]) {
							
							putNum = i;
							break;
							
						}
					}
					indexList.add(putNum);
				}

			}
			System.out.println(indexList);

		}

		// 리스트를 배열로 반환
		answer = new int[indexList.size()];
		for (int i = 0; i < indexList.size(); i++) {
			answer[i] = indexList.get(i);
		}
		return answer;
	}

	// Integer 리스트를 int 배열로 변환해주는 매서
	private static int[] listToArray(Collection<Integer> collection) {
		Object[] tempList = collection.toArray();
		int[] resultArray = new int[tempList.length];
		for (int i = 0; i < tempList.length; i++) {
			resultArray[i] = (int) tempList[i];
		}
		return resultArray;
	}

}

// 틀린 답 : 총 재생횟수합을 정렬하지 않음.

//int genre_counting = totalMap.size();
//
//Set<String> uniqueGenre = totalMap.keySet();
//Object[] uniqueArray = uniqueGenre.toArray();
//
//List<Integer> list = new ArrayList<Integer>();
//for (int i = 0; i < genre_counting; i++) {
//
//	List<Integer> tempList = new ArrayList<Integer>();
//	String s = String.valueOf(uniqueArray[i]);
//	for (int index = 0; index < genres.length; index++) {
//		if (genres[index].equals(s)) {
//			tempList.add(plays[index]);
//		}
//	}
//
//	Object[] result = tempList.toArray();
//	Arrays.sort(result);
//	int counting = result.length>=2? 2:1;
//	for (int index = 1; index <= counting; index++) {
//		list.add(answerMap.get((Integer) result[result.length - index]));
//	}
//	
//}
//System.out.println(totalMap);
//System.out.println(answerMap);
//answer = new int[list.size()];
//for(int i=0; i<list.size(); i++) {
//	answer[i] = list.get(i);
//}
//
//
