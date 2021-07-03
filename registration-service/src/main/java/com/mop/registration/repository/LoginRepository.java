package com.mop.registration.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mop.registration.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
}
