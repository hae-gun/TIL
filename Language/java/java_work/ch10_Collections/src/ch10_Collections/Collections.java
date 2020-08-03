package ch10_Collections;

/*
 * List
 * 객체를 일렬로 늘어놓는 구조
 * 인덱스로 관리
 * 자동 인덱스 부여: 인덱스로 객체를 검색, 삭제
 * null 도 저장가능
 * 
 * 배열과 다른점
 * 생성할 때 타입 지정 하지 않음 - Object - Generics를 사용하여 타입 지정
 * 크기가 자동으로 관리
 * 
 * ArrayList : 하나의 객체가 추가, 삭제될 때 나머지 요소들 전체의 인덱스에 영향
 * LinkedList : 각 객체는 앞뒤 요소의 인덱스를 갖는다. 삽입, 삭제될 떄 앞뒤 요소에만 영향. 
 * 				삽입, 삭제가 빈번한 데이터에 활용
 * Vector :	ArrayList 와 같으나 Thread Safe, 자동 싱크로: 한 스레드가 접근하는 동안 다른 스레드의 접근 차단.
 * 
 * 
 * */

public class Collections {

}
