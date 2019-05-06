package com.chy.webchatserver.entity;


import java.io.Serializable;

/**
 * @Author chy
 * @Date 2019/4/29
 * @Email 1625640688@qq.com
 */

public class Role implements Serializable {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
