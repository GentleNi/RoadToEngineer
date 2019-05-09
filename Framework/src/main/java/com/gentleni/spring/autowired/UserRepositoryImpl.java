package com.gentleni.spring.autowired;

import org.springframework.stereotype.Repository;

/**
 * Created by GentleNi
 * Date 2019/1/30.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    @Override
    public void add() {
        System.out.println("UserRepository Add");
    }
}
