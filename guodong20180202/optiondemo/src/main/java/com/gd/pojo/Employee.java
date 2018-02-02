package com.gd.pojo;

import javax.persistence.*;

/**
 * Created by 郭 on 2018/2/2.
 */
@Entity
@Table(name="employee")
public class Employee {
    @Id
    @Column(name ="e_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name ="e_leader_id")
    private Integer pId;
    @Column(name ="e_name")
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
