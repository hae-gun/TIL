package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.unitils.reflectionassert.ReflectionComparatorMode;

import java.util.Optional;
import static org.unitils.reflectionassert.ReflectionAssert.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    public void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

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
//        try{
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
//        }catch (IllegalStateException e){
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        IllegalStateException e = assertThrows(IllegalStateException.class, ()->memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");


        //then
    }

    @Test
    void 전체조회(){

    }

    @Test
    void findOne() {
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