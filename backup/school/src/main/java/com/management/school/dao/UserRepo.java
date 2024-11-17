package com.management.school.dao;

import com.management.school.entity.usertelusko;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<usertelusko, Integer> {

    // You can define custom query methods here if needed, e.g.
    usertelusko findByName(String name);
}
