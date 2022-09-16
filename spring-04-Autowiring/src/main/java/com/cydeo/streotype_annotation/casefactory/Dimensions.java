package com.cydeo.streotype_annotation.casefactory;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter

@Component
public class Dimensions {
    private int width;
    private int height;
    private int depth;
//if we put @AllArgConstructor it will try to inject those int. Injection does not work with primitives.



    public void pressPowerButton(){
        System.out.println("Power button pressed");
    }


}
