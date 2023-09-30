package com.rs.retailstore.repository;

import com.rs.retailstore.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository //de spring biet duoc la interface nay se tao 1 cai bean la CustomerRepository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    //day la interface extend interface CrudRepository
    List<Customer> findByUsername(String username);


}
