package com.chy.webchatserver.entity;

import javax.persistence.*;
import java.util.List;

/**
 * @Author chy
 * @Date 2019/4/29
 * @Email 1625640688@qq.com
 */
@Entity
@Table(name = "menu")
public class Menu {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String url;
    @OneToMany
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
