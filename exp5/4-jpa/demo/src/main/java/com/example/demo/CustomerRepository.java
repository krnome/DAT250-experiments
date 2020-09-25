package com.example.demo;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


//MERK trenger ikke å faktisk implementere interface
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
    Customer findById(long id);
}
