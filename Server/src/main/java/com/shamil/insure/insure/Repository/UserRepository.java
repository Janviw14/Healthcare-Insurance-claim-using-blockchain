package com.shamil.insure.insure.Repository;

import com.shamil.insure.insure.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByInsID(String id);
    User findBypID(String _id);
}
