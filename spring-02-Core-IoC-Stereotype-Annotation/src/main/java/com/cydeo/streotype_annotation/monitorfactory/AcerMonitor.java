package com.cydeo.streotype_annotation.monitorfactory;

import org.springframework.stereotype.Component;

@Component
public class AcerMonitor extends Monitor{

    public AcerMonitor() {
        super("21 inch beast","Acer",21);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Acer");
    }
}