package com.cydeo.config;


import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {
//Example of Wiring
    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }
    @Bean
    public Case caseDell(Dimensions dimensions){

        return new DellCase("220B","Dell","240",dimensions);
    }

    /*
    public Case caseDell(){
        Dimensions dimensions = new Dimensions(50,10,10);
        return new DellCase("220B","Dell","240",dimensions);
    }
    This option would be tightly coupled, because if I want to change dimension I need to change
    it here
     */

}
