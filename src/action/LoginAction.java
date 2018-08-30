package action;

import Entity.UserTable;
import Services.LoginService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("loginAction")
@Scope(value = "prototype")
public class LoginAction extends ActionSupport implements ModelDriven<UserTable> {
    @Autowired
    UserTable userTable;
    @Autowired
    LoginService loginService ;
    @Override
    public String execute() throws Exception {
        UserTable u =new UserTable();
        try{
         u=loginService.login(userTable);
        }catch (Exception e){
            this.addActionError(e.getMessage());
            return "false";
        }

        ActionContext.getContext().getSession().put("user",u);
        return "success";
    }

    @Override
    public UserTable getModel() {
        return userTable;
    }
}
