package com.chy.webchatserver.entity;

import javax.persistence.*;

/**
 * @Author chy
 * @Date 2019/4/29
 * @Email 1625640688@qq.com
 */
@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    @Column
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
