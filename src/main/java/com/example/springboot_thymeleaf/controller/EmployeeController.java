package com.example.springboot_thymeleaf.controller;


import com.example.springboot_thymeleaf.model.Employee;
import com.example.springboot_thymeleaf.model.EmployeeDetails;
import com.example.springboot_thymeleaf.service.EmployeeService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class EmployeeController {

    //display list of employees

    @Autowired

    private EmployeeService employeeService;


    @GetMapping("/")
    public  String viewPage(Model model){
        model.addAttribute("listEmployees",employeeService.getAllEmployees());
        return "index";
    }

    @GetMapping("/showNewEmployeeForm")
    public String showNewEmployeeForm(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "new_employee";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        //save employee to database

        employeeService.saveEmployee(employee);
        return "redirect:/";
    }


    @GetMapping("/showFormForUpdate/{id}")
    public  String showFormForUpdate(@PathVariable(value = "id") long id,Model model){


        //get employee from service

        Employee employee = employeeService.getEmployeeById(id);

        //set employee as a model attribute to pre-populate the form

        model.addAttribute("employee",employee);
        return "update_employee";
    }


    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable (value = "id") long id){

        //call delete employee method

        this.employeeService.deleteEmployeeById(id);
        return "redirect:/";
    }






}
