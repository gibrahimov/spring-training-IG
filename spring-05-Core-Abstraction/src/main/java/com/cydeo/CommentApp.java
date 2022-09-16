package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {
//always put your running Class under main package which is com.cydeo in my case
//now we need create object from CommentService class, then call publishComment method. But with Spring
//we don't do that because it is too long to type codes.

       //these below portion will come from user form or from Database, we are typing here as example
        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService commentService = context.getBean(CommentService.class);
        commentService.publishComment(comment);

    }
}
