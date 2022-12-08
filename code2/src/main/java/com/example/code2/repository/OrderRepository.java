package com.example.code2.repository;

import com.example.code2.order.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

public interface OrderRepository extends CrudRepository<Order,Long> {

}
