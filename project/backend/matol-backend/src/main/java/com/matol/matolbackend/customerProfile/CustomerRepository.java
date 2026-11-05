package com.matol.matolbackend.customerProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Optional<Customer> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Customer c " +
            "SET c.enabled = TRUE WHERE c.email = ?1")
    int enableCustomer(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Customer c " +
            "SET c.customerProfileImageLink  = ?1" +
            " WHERE c.email = ?2")
    int updateCustomerProfileImageLink(String link, String email);
}
