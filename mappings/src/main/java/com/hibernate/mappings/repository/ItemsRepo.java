package com.hibernate.mappings.repository;

import java.util.List;

import com.hibernate.mappings.entity.Items;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ItemsRepo extends JpaRepository<Items, Long> {
	public List<Items> findByCategory(String name);	
}
