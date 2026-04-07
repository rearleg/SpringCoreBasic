package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.jspecify.annotations.NonNull;

public class AppConfig {

    // 멤버 서비스
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    // 멤버 저장소
    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    // 주문 서비스
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    // 할인 정책
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }

}
