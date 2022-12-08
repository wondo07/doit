package com.example.code2.order;


import com.example.code2.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;


@Getter
@Setter
@Table(schema = "ORDERS")

public class Order {

    @Id
    private Long orderId;
    private AggregateReference<Member, Long> memberId;

    @MappedCollection(idColumn = "ORDER_ID", keyColumn = "ORDER_COFFEE_ID")
    private Set<CoffeeRef> orderCoffees=new LinkedHashSet<>();
    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST;
    private LocalDateTime createdAt = LocalDateTime.now();

    public enum OrderStatus{
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");
        @Getter
        private int stepNumber;
        @Getter
        private String stepDescription;
        OrderStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }

}
