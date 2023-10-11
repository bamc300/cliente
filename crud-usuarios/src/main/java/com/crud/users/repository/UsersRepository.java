package com.crud.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.users.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Long> {

}
