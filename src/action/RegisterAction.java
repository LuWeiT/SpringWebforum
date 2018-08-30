package action;

import Entity.UserTable;
import Services.RegisterService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("registerAction")
@Scope(value = "prototype")
public class RegisterAction extends ActionSupport implements ModelDriven<UserTable> {
    @Autowired
    RegisterService registerService;
    @Autowired
    UserTable userTable;
    @Override
    public String execute() throws Exception {
        try {
            registerService.register(userTable);
        }catch (Exception e){
            this.addActionError(e.getMessage());
            return "regiserFalse";
        }
        return SUCCESS;
    }

    @Override
    public UserTable getModel() {
        return userTable;
    }
}
