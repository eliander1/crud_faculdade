package com.portfolio.crud_faculdade.services;


import com.portfolio.crud_faculdade.entities.User;
import com.portfolio.crud_faculdade.repositories.UserRepository;
import com.portfolio.crud_faculdade.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
        return user;
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("Unable to delete user with id: " + id);
        }
    }

    @Override
    public User update(Long id, User user) {
        try {
            User entity = userRepository.getOne(id);
            updateData(entity, user);
            return userRepository.save(entity);
        } catch (Exception e) {
            throw new ResourceNotFoundException("User not found with id: " + id);
        }
    }

    private void updateData(User entity, User user) {
        entity.setNome(user.getNome());
        entity.setEmail(user.getEmail());
        entity.setTelefone(user.getTelefone());
        entity.setPassword(user.getPassword());
    }
}
