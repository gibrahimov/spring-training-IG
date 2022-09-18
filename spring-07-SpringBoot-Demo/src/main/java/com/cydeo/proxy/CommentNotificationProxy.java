package com.cydeo.proxy;

import com.cydeo.model.Comment;

// Interface no object creation so no @Component
public interface CommentNotificationProxy {

    void sendComment(Comment comment);

}
