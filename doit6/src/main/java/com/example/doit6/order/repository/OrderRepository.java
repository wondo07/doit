package com.example.doit6.order.repository;

import com.example.doit6.order.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order,Long> {

    @Query(value = "select * from Order where member_id=:memberid",nativeQuery = true)
    List<Order> findByAriticleId(Long memberid);


}
