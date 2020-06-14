package com.danger.dao;

import com.danger.domain.Adminuser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminuserDao {

    /**
     * 根据用户名和密码查询一个
     * @param username
     * @param password
     * @return
     */
    @Select("select * from adminuser where username = #{username} and password = #{password}")
    public Adminuser findOne(@Param("username")String username, @Param("password")String password);
}
