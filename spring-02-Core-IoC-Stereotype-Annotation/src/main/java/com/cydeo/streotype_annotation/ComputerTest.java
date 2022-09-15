package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.config.PcConfig;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComputerTest {
    public static void main(String[] args) {

//Interface to create container
        ApplicationContext container = new AnnotationConfigApplicationContext(PcConfig.class);
        Monitor theMonitor = container.getBean(Monitor.class);
        System.out.println(theMonitor.getSize());// picks monitor that has @component also
        //@Primary if there are >2 class. Although we have two monitors only one them has @Primary
        // that's why primary monitor was picked




    }
}
