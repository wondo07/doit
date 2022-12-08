package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceimpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceimpl;
import org.springframework.boot.web.reactive.context.AnnotationConfigReactiveWebApplicationContext;
import org.springframework.context.ApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();
//        MemberService memberService=new MemberServiceimpl();
//        OrderService orderService=new OrderServiceimpl();

        ApplicationContext applicationContext=new AnnotationConfigReactiveWebApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId=1L;
        Member member =new Member(memberId,"membera", Grade.VIP);
        memberService.join(member);

        Order order=orderService.createOrder(memberId,"itema",20000);
        System.out.println("order = "+ order);
        System.out.println("calculator price = "+ order.calculatePrice());

    }


}
