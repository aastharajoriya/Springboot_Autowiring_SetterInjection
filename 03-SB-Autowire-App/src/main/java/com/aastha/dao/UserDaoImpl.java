package com.aastha.dao;

import org.springframework.stereotype.Component;

@Component
public record UserDaoImpl() implements UserDao {
    @Override
    public boolean saveUser(String name, String email,String pwd){
        //db logic

        System.out.println("Record Inserted in db ");
        return true;
    }
}
