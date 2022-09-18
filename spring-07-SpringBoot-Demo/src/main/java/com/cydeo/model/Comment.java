package com.cydeo.model;


import lombok.Data;

@Data
/*
so don't add @Component for this Class because if we go check other Classes we won't see any class
require private String author; private String text; in anywhere. OR this class itself does not require
any injection there is no HAS-A relationship

SPRING RULE: WE NEVER PUT @COMPONENT FOR CLASSES INSIDE MODEL PACKAGE.

 */
public class Comment {

    private String author;
    private String text;

}
