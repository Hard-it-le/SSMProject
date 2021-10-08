package com.yjl.annotation.service.Impl;

import com.yjl.annotation.mapper.SoldierMapper;
import com.yjl.annotation.service.SoldierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yujiale
 * @Classname SoldierServiceImpl
 * @Description TOO
 * @Date 2021/9/25 下午9:54
 * @Created by yujiale
 */
@Service
public class SoldierServiceImpl implements SoldierService {

    @Autowired
    private SoldierMapper soldierMapper;

    @Override
    public void getTest() {
        soldierMapper.getTest();
    }
}
