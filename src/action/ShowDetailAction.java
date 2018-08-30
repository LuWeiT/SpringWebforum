package action;

import Entity.PostTable;
import Entity.ReplyTable;
import Services.PostService;
import Services.ReplyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("showDetailAction")
@Scope(value = "prototype")
public class ShowDetailAction extends ActionSupport {
    long id;
    @Autowired
    PostService service ;
    @Autowired
    ReplyService replyService ;
    @Override
    public String execute() throws Exception {

        PostTable post = service.getPostById(getId());
        List<ReplyTable> list = replyService.getReplyByPostId(getId());
        ActionContext.getContext().put("post",post);
        ActionContext.getContext().put("replyList",list);
        return SUCCESS;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
