package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

public class OrderServiceimpl implements OrderService{

    private final MemberRepository memberRository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceimpl(MemberRepository memberRository, DiscountPolicy discountPolicy) {
        this.memberRository = memberRository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRository.findbyid(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);

    }
}
