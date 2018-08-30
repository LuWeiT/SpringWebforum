package Dao;

import Entity.PostTable;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository

@Scope(value = "prototype")


public class ContentDao {
    @Autowired
    SessionFactory sessionFactory;
    public List<PostTable> selectAllPost() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from  PostTable ");
        List<PostTable> list =query.list();
        Hibernate.initialize(list);
        //System.out.print(list.get(0).getContent());
        return list;
    }
   /* @Test
    public void select() {

        Session  session = HibernateUtils.getCurrentSession();
        Transaction tx =session.beginTransaction();
        Query query = session.createQuery("from  PostTable ");
        System.out.print(query.list());
        tx.commit();
    }*/
}
