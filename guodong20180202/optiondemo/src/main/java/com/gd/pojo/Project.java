package com.gd.pojo;

import javax.persistence.*;
import java.util.Date;


/**
 * Created by 郭 on 2018/1/31.
 */
@Entity
@Table(name ="project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer x_id;

    private String x_name;
    private String x_address;
    private String x_department;
    private String x_year;
    private Double x_rental;
    private String x_begin;
    private String x_stop;

    public Integer getX_id() {
        return x_id;
    }

    public void setX_id(Integer x_id) {
        this.x_id = x_id;
    }

    public String getX_name() {
        return x_name;
    }

    public void setX_name(String x_name) {
        this.x_name = x_name;
    }

    public String getX_address() {
        return x_address;
    }

    public void setX_address(String x_address) {
        this.x_address = x_address;
    }

    public String getX_department() {
        return x_department;
    }

    public void setX_department(String x_department) {
        this.x_department = x_department;
    }

    public String getX_year() {
        return x_year;
    }

    public void setX_year(String x_year) {
        this.x_year = x_year;
    }

    public Double getX_rental() {
        return x_rental;
    }

    public void setX_rental(Double x_rental) {
        this.x_rental = x_rental;
    }

    public String getX_begin() {
        return x_begin;
    }

    public void setX_begin(String x_begin) {
        this.x_begin = x_begin;
    }

    public String getX_stop() {
        return x_stop;
    }

    public void setX_stop(String x_stop) {
        this.x_stop = x_stop;
    }
}
