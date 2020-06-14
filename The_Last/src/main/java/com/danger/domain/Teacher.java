package com.danger.domain;

import com.danger.utils.DateUtil;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 教师实体类
 */
public class Teacher implements Serializable {

    private Integer id;
    private String password;
    private String tname;
    private String tsubject;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date tdate;
    private String tdateStr;
    private Integer status;
    private String statusStr;

    public String getStatusStr() {
        if (status == 0) {
            statusStr = "正常";
        } else if (status == 1) {
            statusStr = "黑名单";
        }
        return statusStr;
    }

    public void setStatusStr(String statusStr) {
        this.statusStr = statusStr;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsubject() {
        return tsubject;
    }

    public void setTsubject(String tsubject) {
        this.tsubject = tsubject;
    }

    public Date getTdate() {
        return tdate;
    }

    public void setTdate(Date tdate) {
        this.tdate = tdate;
    }

    public String getTdateStr() {
        if (tdate != null) {
            tdateStr = DateUtil.DateToString(tdate, "yyyy-MM-dd");
        }
        return tdateStr;
    }

    public void setTdateStr(String tdateStr) {
        this.tdateStr = tdateStr;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }
}
