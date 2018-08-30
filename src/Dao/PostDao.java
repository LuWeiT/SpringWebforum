package Dao;

import Entity.PostTable;
import Entity.UserTable;

import com.opensymphony.xwork2.ActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;

@Repository

@Scope(value = "prototype")
public class PostDao {
    @Autowired
    SessionFactory sessionFactory;
    public void savePost(PostTable post) {
        Session session = sessionFactory.getCurrentSession();
        UserTable user = (UserTable) ActionContext.getContext().getSession().get("user");
        post.setUsername(user.getName());
        post.setUserId(user.getUserId());
        post.setReplayNumber(0);
        post.setTime((new Timestamp(new Date().getTime())));
        session.save(post);
    }

    public PostTable getPostById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from PostTable where id = :id");
        query.setParameter("id",id);
        return (PostTable) query.uniqueResult();
    }
}
