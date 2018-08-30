package Dao;

import Entity.UserTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;


@Repository

@Scope(value = "prototype")
public class UserDao {
    @Autowired
    SessionFactory sessionFactory;

    public UserTable selectUserByUserName(String name) {

        Session session = sessionFactory.getCurrentSession();
        Query query =session.createQuery("from UserTable  where name = :name");
        query.setParameter("name",name);
        return (UserTable) query.uniqueResult();
    }
    /*@Test
    public  void select(){
        Session session = HibernateUtils.getCurrentSession();
        Transaction tx = session.beginTransaction();
        UserTable u =selectUserByUserName("lu");
        tx.commit();
        System.out.print(u.getPassword());
    }*/

    public void saveUser(UserTable user) {
        sessionFactory.getCurrentSession().save(user);
    }
}
