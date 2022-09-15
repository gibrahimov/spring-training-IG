package com.cydeo.streotype_annotation.monitorfactory;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class SonyMonitor extends Monitor{

//with Stereotype annotation @Component this is done. We can't do more than 1 SonyMonitor
//But with @Bean we can create more than 1 SonyMonitor, only method name will be different.

    public SonyMonitor() {
        super("25 inch beast","Sony",25);
    }

    public void drawPixelAt() {
        System.out.println("Drawing pixel with Sony");
    }
}
