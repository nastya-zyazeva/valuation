package com.zyazeva.valuation.service.implementation;

import com.zyazeva.HibernateFactory;
import com.zyazeva.valuation.model.Project;
import com.zyazeva.valuation.service.ProjectService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ProjectServiceImplementation implements ProjectService{

    @Override
    public void createProject(Project project) {
    //SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Project readProject(int projectId) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Project project;
        project = (Project) session.get(Project.class, projectId);
        session.close();

        return project;
    }

    @Override
    public void updateProject(Project project) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteProject(Project project) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(project);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List getAllProjects() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List projectsList = session.createCriteria(Project.class).list();
        session.close();

        return projectsList;
    }
    
    @Override
    public List getAllProjectsByUserId(Integer userId){
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List projectsList = session.createCriteria(Project.class).list();
        session.close();
        
        List userProjectsList = new ArrayList();
        for (int i = 0; i < projectsList.size(); i++){
            Project project = (Project) projectsList.get(i);
            if (project != null){
                if (project.getUserId() == userId){
                    userProjectsList.add(project);
                }    
            }
            
        }

        return userProjectsList;
    }
    
    @Override
    public Project getProjectByName(String name) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List projectsList = session.createCriteria(Project.class).list();
        session.close();
        
        Project resultProject = null;
        for (int i = 0; i < projectsList.size(); i++){
            Project project = (Project) projectsList.get(i);
            if (project.getName().equals(name)){
                resultProject = project;
            }
        }

        return resultProject;
    }
    
}
