package com.hibernate.mappings.repository;

import com.hibernate.mappings.entity.OrdersTable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderRepo extends JpaRepository<OrdersTable, Long> {

}
