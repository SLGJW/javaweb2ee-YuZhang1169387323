package com.danger.domain;

import java.io.Serializable;

public class Dept  implements Serializable {
    private Integer id;
    private String dname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }
}
