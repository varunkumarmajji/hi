package com.hibernate.mappings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hibernate.mappings.dto.Address;
@Repository
public interface AddressRepo extends JpaRepository<Address, Long> {

}
