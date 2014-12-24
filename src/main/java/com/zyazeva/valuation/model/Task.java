package com.zyazeva.valuation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TASK")
public class Task {
    
    public static final String DEFAULT_NAME = "default name";
    public static final String DEFAULT_DESCRIPTION = "default description";
    
    private int id;
    private String name;
    private String description;
    private int hours;
    private int men;
    private int balance;
    private int userId;
    
    public Task() {
        id = 0;
        name = DEFAULT_NAME;
        description = DEFAULT_DESCRIPTION;
        hours = 0;
        men = 0;
        balance = 0;
        userId = 0;
    }
    
    public Task(String name, String description, int hours, int men, int balance, int userId) {
        id = 0;
        this.name = name;
        this.description = description;
        this.hours = hours;
        this.men = men;
        this.balance = balance;
        this.userId = userId;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "ID")    
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

    @Column(name = "DESCRIPTION")    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "HOURS")    
    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Column(name = "MEN")     
    public int getMen() {
        return men;
    }

    public void setMen(int men) {
        this.men = men;
    }
    
    @Column(name = "BALANCE")    
    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Column(name = "USER_ID")    
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}