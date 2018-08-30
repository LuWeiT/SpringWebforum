package action;

import Services.UserService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("changePasswordActin")
@Scope(value = "prototype")
public class ChangePasswordAction extends ActionSupport {
    String password;
    String username;
    String code;
    @Autowired
    UserService userService ;
    @Override
    public String execute() throws Exception {
        try{

            userService.updateUserPasswordByUsername(username,password,code);
        }catch (Exception e){
            System.out.print(e);
            return "false";
        }
        return SUCCESS;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
