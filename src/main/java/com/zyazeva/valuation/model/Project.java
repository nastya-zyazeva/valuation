package com.zyazeva.valuation.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PROJECT")
public class Project {

    public static final String DEFAULT_NAME = "default name";
    public static final String DEFAULT_STATUS = "default status";

    private int id;
    private String name;
    private Date date;
    private String status;
    private int userId;

    public Project() {
        id = 0;
        name = DEFAULT_NAME;
        date = new Date();
        status = DEFAULT_STATUS;
        userId = 0;
    }

    public Project(String name, String status, Integer userId) {
        id = 0;
        this.name = name;
        date = new Date();
        this.status = status;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "NAME")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "DATE")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Column(name = "STATUS")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
}
