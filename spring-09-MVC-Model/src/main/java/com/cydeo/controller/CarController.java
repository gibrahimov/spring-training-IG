package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CarController {

    //localhost:8080/info?make=Honda
    @RequestMapping("/info")
    public String carInfo(@RequestParam String make, Model model){
//@RequestParam works with ? query parameter, key and value structure. This Honda or Toyota etc will come
//from user as search and will assign to String make variable, so we can use that make variable
        model.addAttribute("make",make);

        return "car/car-info";
    }

    //localhost:8080/info2 (KIA)
    @RequestMapping("/info2")
    public String carInfo2(@RequestParam(value = "make",required = false,defaultValue = "KIA") String make, Model model){

        model.addAttribute("make",make);

        return "car/car-info";
    }


    //localhost:8080/info3?make=Honda&year=2015
    @RequestMapping("/info3")
    public String carInfo3(@RequestParam String make,@RequestParam int year, Model model){

        model.addAttribute("make",make);
        model.addAttribute("year",year);

        return "car/car-info";
    }


    //As backend developer specially in API side we will be using PathVariable
    @RequestMapping("/info/{make}/{year}")  //localhost:8080/info/honda/2015
//{make} and {year} are dynamic and will come from user and assign to variable
    public String getCarInfo(@PathVariable String make,@PathVariable String year){

        System.out.println(make);
        System.out.println(year);

        return "car/car-info";
    }

}
/*
www.amazon.com When you search TV, tv comes, when you search table comes. So basically anything search
comes to page. Does it mean that amazon created view page for each product items? NO
www.amazon.com/s?k=table - shows in top browser bar
www.amazon.com/s?k=TV - shows in top browser bar

We know that whatever page comes after we type TV or table is result of one end point.
Amazon has one method(){} with @RequestMapping("/s"). so that method open search page. Inside the
method we will write business logic that will decide what we are searching. So question is how my
method will know what I am searching and how I will bring those search information to my code?
or I should say how can I bring info from UI into my Java code?

? is query parameters. k- vey and value.


 */