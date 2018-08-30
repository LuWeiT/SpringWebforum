package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cancelAction")
@Scope(value = "prototype")
public class CancelAction extends ActionSupport {
    @Override
    public String execute() throws Exception {
        ActionContext.getContext().getSession().remove("user");
        return SUCCESS;
    }
}
