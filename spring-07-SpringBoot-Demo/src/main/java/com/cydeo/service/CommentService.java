package com.cydeo.service;

import com.cydeo.config.AppConfigData;
import com.cydeo.config.DBConfigData;
import com.cydeo.model.Comment;
import com.cydeo.proxy.CommentNotificationProxy;
import com.cydeo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype")
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class CommentService {
//this is business logic, like publish comment, like save and send
    private final CommentRepository commentRepository;
    //It can save DB or in cloud or other place in future
    private final CommentNotificationProxy commentNotificationProxy;
    // this is loosely couple, tomorrow I might send text notification
//we create with final key word because it is good practice and reason is there could be case you might
//forget to create constructor which will not create Autowire, BUT if you put final key word it will
//start complaining and will FORCE/REMIND you to generate constructor.
private final AppConfigData appConfigData;
private final DBConfigData dbConfigData;



//once you create constructor it generates Autowire automatically
    public CommentService(CommentRepository commentRepository, @Qualifier("EMAIL") CommentNotificationProxy commentNotificationProxy, AppConfigData appConfigData, DBConfigData dbConfigData) {
        this.commentRepository = commentRepository;
        this.commentNotificationProxy = commentNotificationProxy;
        this.appConfigData = appConfigData;
        this.dbConfigData = dbConfigData;
    }

    public void publishComment(Comment comment) {
        //save in the DB
        //send email
// when you create object you will call this method and this method will run below methods which are
//store in DB and send Email
        commentRepository.storeComment(comment);
        commentNotificationProxy.sendComment(comment);

    }

    public void printConfigData(){
        //print ozzy
        //print abc123
        //print url
        System.out.println(appConfigData.getUserName());
        System.out.println(appConfigData.getPassword());
        System.out.println(appConfigData.getUrl());
    }

    public void printDbConfigData(){
        System.out.println(dbConfigData.getUsername());
        System.out.println(dbConfigData.getPassword());
        System.out.println(dbConfigData.getType());

    }

}
