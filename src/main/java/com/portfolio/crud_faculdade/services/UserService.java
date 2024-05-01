package com.portfolio.crud_faculdade.services;

import com.portfolio.crud_faculdade.entities.User;
import com.portfolio.crud_faculdade.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {

    @Autowired
    UserRepository userRepository = null;

    List<User> findAll();

    Optional<User> findById(Long id);

    User insert(User user);

    void delete(Long id);

    User update(Long id, User user);
}
