package com.cydeo.service;

import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.proxy.EmailCommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import com.cydeo.repository.DBCommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CommentService {
//this is business logic, like publish comment, like save and send
    private final CommentRepository commentRepository;
    //It can save DB or in cloud or other place in future
    private final CommentNotificationProxy commentNotificationProxy;
    // this is loosely couple, tomorrow I might send text notification
//we create with final key word because it is good practice and reason is there could be case you might
//forget to create constructor which will not create Autowire, BUT if you put final key word it will
//start complaining and will FORCE/REMIND you to generate constructor.




//once you create constructor it generates Autowire automatically
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
    }

    public void publishComment(Comment comment) {
        //save in the DB
        //send email
// when you create object you will call this method and this method will run below methods which are
//store in DB and send Email
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }

}
