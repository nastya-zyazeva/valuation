package com.zyazeva.valuation.service;

import com.zyazeva.valuation.model.Task;
import java.util.List;

public interface TaskService {

    void createTask(Task task);

    Task readTask(int tasktId);

    void updateTask(Task task);

    void deleteTask(Task task);

    List getAllTasks();

    Task getTasktByName(String name);
}
