package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

//Display all departments in the Furniture Department
    List<Department> findByDepartment(String department);

//Display all department in the health division
    List<Department> findByDivision(String division);
    List<Department> findByDivisionIs(String division);
    List<Department> findByDivisionEquals(String division);

    //display all departments with division name ends with 'ics'

    List<Department> findByDivisionEndingWith(String pattern);
    //display top3 departments with division name includes 'Hea' without duplicates
    List<Department> findDistinctTop3ByDivisionContaining(String pattern);





}
