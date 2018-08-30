package Services;

import Dao.UserDao;
import Entity.UserTable;

import com.opensymphony.xwork2.ActionContext;
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
public class UserService {
    @Autowired
    UserDao dao ;

    public void updateUserPasswordByUsername(String username, String password,String code)   {

        if(!code.equals(ActionContext.getContext().getSession().get("emailCode"))){
            ActionContext.getContext().getSession().remove("emailCode");

            throw new RuntimeException("验证码错误！");
        }


        UserTable user =dao.selectUserByUserName(username);
        user.setPassword(password);

        ActionContext.getContext().getSession().remove("emailCode");

    }
}
