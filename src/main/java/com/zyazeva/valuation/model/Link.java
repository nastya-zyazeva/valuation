package com.zyazeva.valuation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name = "LINK")
public class Link {
    
    private int id;
    private int projectId;
    private int taskId;
    private int userId;
    
    public Link() {
        id = 0;
        projectId = 0;
        taskId = 0;
        userId = 0;
    }
    
    public Link(int projectId, int taskId, int userId){
        id = 0;
        this.projectId = projectId;
        this.taskId = taskId;
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

    @Column(name = "PROJECT_ID") 
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    @Column(name = "TASK_ID") 
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    @Column(name = "USER_ID") 
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
}