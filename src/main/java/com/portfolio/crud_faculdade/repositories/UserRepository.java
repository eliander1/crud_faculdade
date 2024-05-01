package com.portfolio.crud_faculdade.repositories;

import com.portfolio.crud_faculdade.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
