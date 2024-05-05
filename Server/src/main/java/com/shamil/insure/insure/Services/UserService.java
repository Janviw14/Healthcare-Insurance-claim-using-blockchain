package com.shamil.insure.insure.Services;

import com.shamil.insure.insure.Models.User;
import com.shamil.insure.insure.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        return userRepository.findById(id).orElse(null);
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }

    public User getUserByPID(String id) {
        return userRepository.findBypID(id);
    }

    public User getUserByInsID(String id) {
        return userRepository.findByInsID(id);
    }
}
