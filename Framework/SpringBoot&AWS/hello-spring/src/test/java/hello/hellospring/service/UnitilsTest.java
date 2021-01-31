package hello.hellospring.service;
import static org.junit.jupiter.api.Assertions.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.*;
import org.junit.runners.model.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.util.Date;

//@SpringBootTest
public class UnitilsTest {

    @Test
    public void 동일성테스트(){
        Member actualMember = new Member(1l,"1");
        Member realMember = actualMember;

        assertEquals(actualMember,realMember);
    }

    @Test
    public void 동치성테스트(){
        Member actualMember = new Member(1l,"1");
        Member realMember = new Member(1l,"1");

        assertEquals(actualMember,realMember);
    }

    @Test
    public void 리플렉션(){
        Member actualMember = new Member(1l,"12");
        Member realMember = new Member(1l,"12");

        assertReflectionEquals("서로 다른 객체입니다.",actualMember,realMember);
    }

    @Test
    public void 리플렉션_LENIENT_ORDER(){
        String[] a = {"1","2","3"};
        String[] b = {"3","1","2"};
//        assertEquals(a,b);
        assertReflectionEquals(a,b,ReflectionComparatorMode.LENIENT_ORDER);
    }

    @Test
    public void 리플렉션_IGNORE_DEFAULTS(){
        //자바 기본형
        // int: 0 Object: null boolean: false
        Member actualMember = new Member(1l,null);
        Member realMember = new Member(1l,"12");

//        assertReflectionEquals(actualMember,realMember,ReflectionComparatorMode.IGNORE_DEFAULTS);
        assertReflectionEquals(realMember,actualMember,ReflectionComparatorMode.IGNORE_DEFAULTS);
    }
    @Test
    public void 리플렉션_LENIENT_DATES(){
        //자바 기본형
        // int: 0 Object: null boolean: false
        TestClass t1 = new TestClass(new Date(System.currentTimeMillis()),"1");
        TestClass t2 = new TestClass(new Date(System.currentTimeMillis()+100),"1");

        assertReflectionEquals(t1,t2,ReflectionComparatorMode.LENIENT_DATES);
    }

    @Test
    public void property단정문(){
        Member member = new Member(1l,"1");
        assertPropertyLenientEquals("id",1L,member);
        assertPropertyLenientEquals("name","1",member);
    }


    class TestClass{
        Date date;
        String name;

        public TestClass(Date date, String name) {
            this.date = date;
            this.name = name;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
