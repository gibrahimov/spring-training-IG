package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    // will be our MVC

    @RequestMapping("/home")
    public String home(){
        return "home.html";
    }

    @RequestMapping({"/apple","/orange"})// either one will open home.html
    public String getHomePage4(){
        return "home.html";
    }

}
