package com.gentleni.spring.autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void add() {
        System.out.println("UserService Add");
        userRepository.add();
    }
}
