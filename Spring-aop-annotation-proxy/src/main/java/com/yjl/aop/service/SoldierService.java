package com.yjl.aop.service;

/**
 * @author yujiale
 * @Classname SoldierService
 * @Description TOO
 * @Date 2021/9/26 下午9:56
 * @Created by yujiale
 */
public interface SoldierService {
    int saveSoldier(String soldierName);

    int removeSoldier(Integer soldierId);

    int updateSoldier(Integer soldierId, String soldierName);

    String getSoldierNameById(Integer soldierId);
}
