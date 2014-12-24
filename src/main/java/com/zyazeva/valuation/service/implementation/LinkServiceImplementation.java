package com.zyazeva.valuation.service.implementation;

import com.zyazeva.HibernateFactory;
import com.zyazeva.valuation.model.Link;
import com.zyazeva.valuation.model.Project;
import com.zyazeva.valuation.model.Task;
import com.zyazeva.valuation.service.LinkService;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LinkServiceImplementation implements LinkService{

    @Override
    public void createLink(Link link) {
        //SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(link);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Link readLink(int linkId) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Link link = (Link) session.get(Link.class, linkId);
        session.close();

        return link;
    }

    @Override
    public void updateLink(Link link) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(link);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void deleteLink(Link link) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(link);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List getAllLinks() {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List linksList = session.createCriteria(Link.class).list();
        session.close();

        return linksList;
    }

    @Override
    public List getAllLinksByProjectId(Integer projectId) {
        SessionFactory sessionFactory = HibernateFactory.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List linksList = session.createCriteria(Link.class).list();
        session.close();
        
        List projectLinksList = new ArrayList();
        for (int i = 0; i < linksList.size(); i++){
            Link link = (Link) linksList.get(i);
            if (link != null){
                if (link.getProjectId() == projectId){
                    projectLinksList.add(link);
                }    
            }
            
        }

        return projectLinksList;
    }
    
}
