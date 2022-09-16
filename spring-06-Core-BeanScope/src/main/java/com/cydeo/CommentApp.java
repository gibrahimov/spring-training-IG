package com.cydeo;

import com.cydeo.config.CommentConfig;
import com.cydeo.model.Comment;
import com.cydeo.service.CommentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CommentApp {
    public static void main(String[] args) {

        Comment comment  = new Comment();
        comment.setAuthor("Johnson");
        comment.setText("Spring Framework");

        ApplicationContext context = new AnnotationConfigApplicationContext(CommentConfig.class);
        CommentService cs1= context.getBean(CommentService.class);//if we were with java we should have used
        //like using new keyword
        CommentService cs2= context.getBean(CommentService.class);
        System.out.println(cs1);
        System.out.println(cs2);
        System.out.println(cs1==cs2);//TRUE with singleton
        //if you use prototype it will be false because spring each time will give you different object


    }
}
