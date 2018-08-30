package action;

import Entity.PostTable;
import Services.ContentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("contentAction")
@Scope(value = "prototype")
public class ContentAction extends ActionSupport {
    @Autowired
    ContentService contentService;
    @Override
    public String execute() throws Exception {
        List<PostTable> list = contentService.getAllPost();

        ActionContext.getContext().put("list",list);
        return SUCCESS;
    }
}
