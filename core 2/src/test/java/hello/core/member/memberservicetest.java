package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class memberservicetest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join(){
        //given
        Member member= new Member(1L,"membera",Grade.VIP);
        // when
        memberService.join(member);
        Member findmember=memberService.findbyid(1L);
        // then
        Assertions.assertThat(member).isEqualTo(findmember);
    }
}
