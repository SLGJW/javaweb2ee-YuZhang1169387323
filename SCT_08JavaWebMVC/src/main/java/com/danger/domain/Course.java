package com.danger.domain;

import java.io.Serializable;

public class Course implements Serializable {
    Integer id;
    String cname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


}
