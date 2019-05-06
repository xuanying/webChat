package com.chy.webchatserver.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @Author chy
 * @Date 2019/4/29
 * @Email 1625640688@qq.com
 */
public class Menu implements Serializable {

    private Long id;
    private String url;
    private List<Role> roles;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
