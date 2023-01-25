package com.springbootcrudwebservicesapp.springbootcrudwebservicesapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springbootcrudwebservicesapp.springbootcrudwebservicesapp.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
