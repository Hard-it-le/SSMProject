package com.yjl.proxy.service;

/**
 * @author yujiale
 * @Classname SoldierService
 * @Description TOO
 * @Date 2021/9/26 下午7:55
 * @Created by yujiale
 */
public interface SoldierService {

    int saveSoldier(String soldierName);

    int removeSoldier(Integer soldierId);

    int updateSoldier(Integer soldierId, String soldierName);

    String getSoldierNameById(Integer soldierId);
}
