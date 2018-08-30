package Services;

import Dao.UserDao;
import Entity.UserTable;

import org.hibernate.Session;
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
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = false)

public class RegisterService {
    @Autowired
    UserDao userDao;

    public void register(UserTable user) throws RuntimeException {
        UserTable userTable = userDao.selectUserByUserName(user.getName());
        if(userTable!=null){
            throw new RuntimeException("用户名已存在！");
        }
        else{
            userDao.saveUser(user);
        }

    }
}
