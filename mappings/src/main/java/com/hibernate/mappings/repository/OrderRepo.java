package com.hibernate.mappings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.mappings.dto.OrdersTable;
@Repository
public interface OrderRepo extends JpaRepository<OrdersTable, Long> {

}
