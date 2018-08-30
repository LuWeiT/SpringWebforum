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
@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED,readOnly = true)
public class LoginService {
    @Autowired
    UserDao userDao ;


    public UserTable login(UserTable user) throws RuntimeException{

        UserTable u = userDao.selectUserByUserName(user.getName());



        if(u == null)throw new RuntimeException("用户不存在！");

        if(!u.getPassword().equals(user.getPassword())){
            throw new RuntimeException("密码错误！");

        }
        return u;


    }
}
