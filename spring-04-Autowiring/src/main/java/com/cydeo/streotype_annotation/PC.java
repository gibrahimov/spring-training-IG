package com.cydeo.streotype_annotation;

import com.cydeo.streotype_annotation.casefactory.Case;
import com.cydeo.streotype_annotation.monitorfactory.Monitor;
import com.cydeo.streotype_annotation.motherboardfactory.Motherboard;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
/*
We ar trying to create PC application. In order to create PC we need Case, Monitor, Motherboard
We have implementation classes of Case, Monitor and Motherboard. So we need to create PC
which is to create PC object like PC = new PC(). So I don't want to do this spring will
manage object creation. In module 1 we did PC myPc = new PC(dell, sony, asus); This is what
we did. But we don't want to create object ourselves, we want spring mange this object creating
process.
Then we need to add this PC into container either with @Bean or with Stereotype annotation way.
so we add @Component into PC however PC takes 3 other Objects(like Case, Monitor and Motherboard)
objects. So those objects also need to be managed by Spring, that's why we add @Autowiring
above each of those filed, but it will complain saying Field injection is not recommended because
Spring will get rid of that option. So best option to place @Autowired above constructor
called constructor injection.
Starting with Spring version 4.3, when you only have one constructor in the class,
you can omit writing the @Autowired annotation. AND even we create constructor with lombok
@AllArgConstructor, it will still be OK and accepted. So we are in spring version 5.3.22
per pom file. so we can remove it, just keeping for understnading purposes.
 */
public class PC {


    private Case theCase;
    private Monitor monitor;
    private Motherboard motherboard;

    @Autowired
    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    private void drawLogo() {
        // Fancy graphics
        monitor.drawPixelAt();
    }

}
