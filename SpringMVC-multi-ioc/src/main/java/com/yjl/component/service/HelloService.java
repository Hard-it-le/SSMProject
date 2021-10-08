package com.yjl.component.service;

import com.yjl.component.dao.HelloDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

    @Autowired
    private HelloDao helloDao;

    public String getMessage() {
        return helloDao.getMessage();
    }
}
