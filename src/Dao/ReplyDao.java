package Dao;

import Entity.PostTable;
import Entity.ReplyTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Repository

@Scope(value = "prototype")
public class ReplyDao {
    @Autowired
    SessionFactory sessionFactory;
    public List<ReplyTable> getReplyById(long id) {
        Session session =sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ReplyTable where postId = :id");
        query.setParameter("id",id);
        return query.list();
    }

    public void addReply(ReplyTable reply) {

        reply.setTime(new Timestamp(new Date().getTime()));

        sessionFactory.getCurrentSession().save(reply);

        Query query =sessionFactory.getCurrentSession().createQuery("from PostTable where id=:id");
        query.setParameter("id",reply.getPostId());
        PostTable postTable = (PostTable) query.uniqueResult();
        postTable.setReplayNumber(postTable.getReplayNumber()+1);





    }
}
