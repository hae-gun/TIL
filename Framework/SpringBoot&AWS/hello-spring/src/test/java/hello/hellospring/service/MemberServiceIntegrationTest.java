package hello.hellospring.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import hello.hellospring.domain.Member;
import hello.hellospring.repository.*;
import org.assertj.core.api.Assertions;
import org.dbunit.DataSourceDatabaseTester;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.operation.DatabaseOperation;
import org.junit.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.AbstractDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.database.annotations.TestDataSource;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.DbUnitUnitils;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import javax.sql.DataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.unitils.reflectionassert.ReflectionAssert.assertPropertyLenientEquals;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;


@SpringBootTest
class MemberServiceIntegrationTest {

    @Autowired
    private DataSource datasource;

    @Autowired MemberService memberService;
    @Autowired MemberRepository repository;

    @Test
    public void test() throws Exception{
        MemberRepository repository = new JdbcTemplateMemberRepository(datasource);
        //repository.save(new Member(1l,"123"));
        List<Member> members = repository.findAll();
//        MyList list = memberService.findMembers();
        assertTrue(members.size() > 0);
        // 또는 Header 에 해당하는 컬럼이름의 일치 여부 정도를 목표로 적용.
//        assertTrue("[id, name]",list.headers());
    }

    @Before
    void 테이블셋팅(){
        System.out.println("테이블 셋팅");
    }

    @After
    void 테이블정리(){
        System.out.println("테이블 정리");
    }


    @Test
    @Transactional
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("myMember223");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복회원예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));

        //then
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }

    @Test
    public void testFindById() throws Exception{

        JdbcTemplateMemberRepository repository = new JdbcTemplateMemberRepository(datasource);
        Member actualSeller = repository.findById(2L).get();
        assertPropertyLenientEquals("name","spring",actualSeller);
    }

    @Test
    public void 전체조회() throws Exception{
        List<Member> result = memberService.findMembers();
        for(Member mem : result){
            System.out.println(mem.toString());
        }
    }

    @Test
    public void 회원삭제() throws Exception{
//        memberService.deleteByName();
    }

    @Test
    void equalsTest(){
           Member m1 = new Member();
           Member m2 = new Member();

           m1.setName("a");
           m1.setId(null);
           m2.setName("a");
           m2.setId(1l);

//           assertEquals(m1.getName(),m2.getName());
//           assertEquals(m1.getId(),m2.getId());
//        assertReflectionEquals("동일객체",m1,m2);
        assertReflectionEquals(m1,m2, ReflectionComparatorMode.IGNORE_DEFAULTS);
    }

    @Test
    void propertyLenientsEqualsTest(){
        Member member = new Member();
        member.setName("a");
        assertPropertyLenientEquals("name","a",member);
    }

}