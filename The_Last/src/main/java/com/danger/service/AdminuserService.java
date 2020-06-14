package com.danger.service;

import com.danger.domain.Adminuser;


public interface AdminuserService {

    /**
     * 根据用户名和密码查询一个
     * @param username
     * @param password
     * @return
     */
    public Adminuser findOne(String username, String password);
}
