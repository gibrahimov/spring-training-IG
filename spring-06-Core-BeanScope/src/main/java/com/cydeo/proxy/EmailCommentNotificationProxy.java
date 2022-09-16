package com.cydeo.proxy;

import com.cydeo.model.Comment;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("EMAIL")// or ("PUSH")
// this class does not have HAS-A relationship but it is injected in other class
public class EmailCommentNotificationProxy implements CommentNotificationProxy{


    @Override
    public void sendComment(Comment comment) {
        System.out.println("Sending notification via email for comment: "+ comment.getText());
    }

}
