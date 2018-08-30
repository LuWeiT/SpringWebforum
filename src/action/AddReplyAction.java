package action;

import Entity.ReplyTable;
import Services.ReplyService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("addReplyAction")
@Scope(value = "prototype")
public class AddReplyAction extends ActionSupport implements ModelDriven<ReplyTable> {
    @Autowired
    ReplyTable replyTable ;
    @Autowired
    ReplyService replyService ;
    @Override
    public String execute() throws Exception {
        replyService.addReply(replyTable);
        ActionContext.getContext().put("postId",replyTable.getPostId());
        return SUCCESS;
    }

    @Override
    public ReplyTable getModel() {
        return replyTable;
    }
}
