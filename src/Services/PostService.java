package Services;


import Dao.PostDao;
import Entity.PostTable;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Scope(value = "prototype")
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class PostService {
    @Autowired
    PostDao dao ;
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void savePost(PostTable post) {

        dao.savePost(post);

    }

    public PostTable getPostById(long id) {

        PostTable post =dao.getPostById(id);

        return post;
    }
}
