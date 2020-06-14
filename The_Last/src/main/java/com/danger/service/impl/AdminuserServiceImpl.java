package com.danger.service.impl;

import com.danger.dao.AdminuserDao;
import com.danger.domain.Adminuser;
import com.danger.service.AdminuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminuserServiceImpl implements AdminuserService {

    @Autowired
    private AdminuserDao adminuserDao;

    @Override
    public Adminuser findOne(String username, String password) {
        return adminuserDao.findOne(username, password);
    }
}
