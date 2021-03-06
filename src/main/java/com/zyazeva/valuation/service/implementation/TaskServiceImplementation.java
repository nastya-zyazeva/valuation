package com.zyazeva.valuation.service.implementation;

import com.zyazeva.HibernateFactory;

import com.zyazeva.valuation.model.Task;
import com.zyazeva.valuation.service.TaskService;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TaskServiceImplementation implements TaskService {

    @Override
    public void createTask(Task task) {
        //SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Task readTask(int tasktId) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Task task = (Task) session.get(Task.class, tasktId);
        session.close();

        return task;
    }

    @Override
    public void updateTask(Task task) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteTask(Task task) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(task);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List getAllTasks() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List tasksList = session.createCriteria(Task.class).list();
        session.close();

        return tasksList;
    }

    @Override
    public Task getTasktByName(String name) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List tasksList = session.createCriteria(Task.class).list();
        session.close();

        Task resultTask = null;
        for (int i = 0; i < tasksList.size(); i++) {
            Task task = (Task) tasksList.get(i);
            if (task.getName().equals(name)) {
                resultTask = task;
            }
        }

        return resultTask;
    }

}