package com.base.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
