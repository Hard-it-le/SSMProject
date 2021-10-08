package com.yjl.component.dao;

import org.springframework.stereotype.Repository;

@Repository
public class HelloDao {

    public String getMessage() {
        return "hello i am dao";
    }

}
