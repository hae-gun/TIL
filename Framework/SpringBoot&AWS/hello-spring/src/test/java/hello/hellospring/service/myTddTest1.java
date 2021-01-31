package hello.hellospring.service;

import hello.hellospring.domain.Attendees;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.JdbcTemplateMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;
import org.junit.jupiter.api.*;
import org.unitils.reflectionassert.ReflectionComparatorMode;

//@SpringBootTest
public class myTddTest1 {

    @Autowired
    DataSource dataSource;
    DataSource emptyData = new DataSource() {
        @Override
        public Connection getConnection() throws SQLException {
            return null;
        }

        @Override
        public Connection getConnection(String username, String password) throws SQLException {
            return null;
        }

        @Override
        public PrintWriter getLogWriter() throws SQLException {
            return null;
        }

        @Override
        public void setLogWriter(PrintWriter out) throws SQLException {

        }

        @Override
        public void setLoginTimeout(int seconds) throws SQLException {

        }

        @Override
        public int getLoginTimeout() throws SQLException {
            return 0;
        }

        @Override
        public <T> T unwrap(Class<T> iface) throws SQLException {
            return null;
        }

        @Override
        public boolean isWrapperFor(Class<?> iface) throws SQLException {
            return false;
        }

        @Override
        public Logger getParentLogger() throws SQLFeatureNotSupportedException {
            return null;
        }
    };
// 일반 객체
    @Test
    public void member객체생성(){
        Member member = new Member(); //??
    }

    @Test
    public void myTddTest1() throws SQLException {
        JdbcTemplateMemberRepository repository = new JdbcTemplateMemberRepository(dataSource);
//        JdbcTemplateMemberRepository repository = new JdbcTemplateMemberRepository(emptyData);
        assertTrue(repository.isConnected());
    }

//  DTO 스타일 객체 -> getter, setter로 이루어짐. 테스트 작성하지 않는다.

// 닭 달걀 테스트 -> 실패하는 테스트 케이스를 만들어 작업하기. 또는 DbUnit 같은 안정성 권장된 모듈등..? 리플랙션방법도 있지만 비추천.
    @Test
    public void addMember() throws Exception{
        Attendees attendees = new Attendees();
        attendees.add("근3");
        assertEquals("근3근",attendees.get("근3"));
    }

    @Test
    public void getMember() throws Exception{
        Attendees attendees = new Attendees();
        attendees.add("근3");
        assertEquals("근3근3",attendees.get("근33"));
    }
    @Test
    public void testReflection() throws Exception{
        Attendees attendees = new Attendees();
        attendees.add("근3");

        Field attendeeList = attendees.getClass().getDeclaredField("attendee");
        attendeeList.setAccessible(true);
        assertEquals("근3근3",((Map<String,String>)attendeeList.get(attendees)).get("근3"));
    }
//    배열테스트
    @Test
    public void testArrayEquals(){
        String[] arrayA = new String[] {"a","b","c"};
        String[] arrayB = new String[] {"b","c","a"};
        assertArrayEquals(arrayA,arrayB);
    }
    @Test
    public void testArrayEquals_NotSorted(){
        String[] arrayA = new String[] {"a","b","c"};
        String[] arrayB = new String[] {"a","c","b"};
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        assertArrayEquals(arrayA,arrayB);
    }
    @Test
    public void testArrayEquals_NotSorted_Unitils(){
        String[] arrayA = new String[] {"a","b","c"};
        String[] arrayB = new String[] {"a","c","b"};
        assertReflectionEquals(arrayA,arrayB, ReflectionComparatorMode.LENIENT_ORDER);
//        assertEquals(Arrays.asList(arrayA),Arrays.asList(arrayB)); jUnit3인경우.
    }


//    동일성 동치성 테스트
    @Test
    public void testEquals_case1(){
        Member member1 = new Member(1l,"11");
        Member member2 = member1;
        assertEquals(member1,member2);
    }
    @Test
    public void testEquals_case2(){
        Member member1 = new Member(1l,"11");
        Member member2 = new Member(1l,"11");
        assertEquals(member1,member2);
    }
//    내부값 꺼내서 직접 비교
    @Test
    public void testEquals_case3(){
        Member member1 = new Member(1l,"11");
        Member member2 = new Member(1l,"11");
        assertEquals(member1.getId(),member2.getId());
        assertEquals(member1.getName(),member2.getName());
    }
//    toString 으로 구현
    @Test
    public void testEquals_case4(){
        Member member1 = new Member(1l,"11");
        Member member2 = new Member(1l,"11");
        assertEquals(member1.toString(),member2.toString());
    }

    @Test
    public void testEquals_caseEquals(){
        Member member1 = new Member(1l,"11");
        Member member2 = new Member(1l,"11");
        assertEquals(member1,member2);
    }

    // 가장 확실한 방법 : Equals 메소드 구현하여 비교하기.
    // Unitils 의 assertReflectionEquals 이용
    @Test
    public void testEquals_case5(){
        Member member1 = new Member(1l,"11");
        Member member2 = new Member(1l,"11");
        assertReflectionEquals(member1,member2);
    }
//    Collection 테스트
    //1. primitive type 인 경우
    @Test
    public void testListEquals_Primitive(){
        List<String> listA = new ArrayList<>();
        listA.add("1");
        listA.add("2");

        List<String> listB = new ArrayList<>();
        listB.add("1");
        listB.add("2");

        assertEquals(listA,listB);
    }
    //2. Object 인 경우
    @Test
    public void testListEquals_Object(){
        List<Member> listA = new ArrayList<>();
        listA.add(new Member(1L,"11"));
        listA.add(new Member(2L,"22"));

        List<Member> listB = new ArrayList<>();
        listB.add(new Member(1L,"11"));
        listB.add(new Member(2L,"22"));

        assertEquals(listA,listB);
//        assertEquals(listA.toString(),listB.toString());
    }



}
