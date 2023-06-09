package com.hibernate.mappings.repository;

import com.hibernate.mappings.entity.Orderitemjoin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface OrderItemRepo extends JpaRepository<Orderitemjoin, String> {

}
