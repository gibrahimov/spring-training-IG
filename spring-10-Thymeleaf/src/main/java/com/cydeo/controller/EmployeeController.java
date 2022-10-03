package com.cydeo.controller;

import com.cydeo.model.Employee;
import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

//COMPARE WITH MENTOR CONTROLLER THIS EMPLOYEE CONTROLLER WILL TAKE YOU TO CONFIRMATION PAGE UPON
//CLICKING REGISTER BUTTON.

//COMPARE EMPLOYEE CONTROLLER AND HTML FILES WITH MENTOR CONTROLLER AND HTML FILES

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @GetMapping("/register") //localhost:8080/employee/register
    public String register(Model model) {
        List<String> shiftList = Arrays.asList("Full Time", "Part Time", "Night Shift");
        model.addAttribute("shiftList", shiftList);

        model.addAttribute("employee", new Employee());
/*
when you fill the form all data(object data) will be stored in "employee" attributeName
 */

        return "employee/employee-register";
    }

    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("employee") Employee employee){
//@ModelAttribute("employee") will print all data that you filled in the form. So basically
//catching attributeName data with @ModelAttribute
        return "employee/employee-register-confirm";
    }


}
