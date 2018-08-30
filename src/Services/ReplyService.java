package Services;

import Dao.ReplyDao;
import Entity.ReplyTable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Scope(value = "prototype")
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class ReplyService {
    @Autowired
    ReplyDao dao ;

    public List<ReplyTable> getReplyByPostId(long id) {


        List<ReplyTable> replyTables =dao.getReplyById(id);


        return replyTables;
    }
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)
    public void addReply(ReplyTable reply) {

        dao.addReply(reply);



    }
}
