package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.xml.crypto.Data;
import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    //Display all employees with email address
    List<Employee> findByEmail(String email);

    //Display all employee with first name "" and LastName "",
    //also show all employees with email address ""

    List<Employee> findByFirstNameAndLastNameOrEmail(String fName, String lName, String emails);

    //Display all employees that firstName is not ""

    List<Employee> findByFirstNameIsNot(String firstName);

    //Display all employees where last name starts with ""
    List<Employee> findByLastNameStartingWith(String text);

    //Display all employees salary < ""

    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees salary < ""
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate data1, LocalDate data2);

    //Display all employees salary >= "" in order

    List<Employee> findBySalaryGreaterThanEqualOrderBy(Integer salary);

    //Display top unique 3 employee that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email address
    List<Employee> findByEmailIsNull();

    @Query("SELECT employee FROM Employee employee WHERE employee.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail();

    @Query("SELECT e FROM Employee e WHERE e.email = 'amcnee1@google.es'")
    Integer retrieveEmployeeSalary();


}
