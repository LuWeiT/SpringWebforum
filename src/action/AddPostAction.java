package action;

import Entity.PostTable;
import Services.PostService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("addPostAction")
@Scope(value = "prototype")
public class AddPostAction extends ActionSupport implements ModelDriven<PostTable> {
    @Autowired
    PostTable post;
    @Autowired
    PostService service;
    @Override
    public String execute() throws Exception {
        service.savePost(post);
        return SUCCESS;
    }

    @Override
    public PostTable getModel() {
        return post;
    }
}
