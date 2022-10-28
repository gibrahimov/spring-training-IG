package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-----------REGIONS-----------");

        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainsOrderByRegion:" + regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("-----------DEPARTMENTS----------");
        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findByDivision:" + departmentRepository.findByDivision("Health"));


        System.out.println("-----------EMPLOYEES----------");
        System.out.println(employeeRepository.retrieveEmployeeDetail());
    }
}
/*
We need to creat our own query like select * from employee where id = 5. Since this  method does not exist in JPA repository iunterface we need to create our own query
3 ways to do that:

1. Derived queries - method building
2. JPQL - writing query
3. Native query  - writing query

Derived queries build method, we write method following to naming conventions

interface StudentRepository exteneds JPARepo
findById(Long id) = select * from Stident where Id = 2. Spring knows already that I am in student

Find = select
By = Where
Id = Id
this is the naming convention that Spring follows. So if query start with Select so method will be Find. Select = Find

Select = find, get, read, count, query. Coommon one is find and get
---------------------------------------------------

JPQL writing query
------

If our derived query method get longer and longer in that case we use this query writing JPQL(Java persistent Query Language)

When we write JPQL we write it through/against class(entity). It looks like SQL but are not SQL behine it will convert to SQL query

@Query("SELECT e FROM Employee e WHERE e.email = ?1")
Employee getEmployeeByEmail(String email);


@Query inside we write either SQL or JPQL
e repersents object created from Employee class

getEmployeeByEmail() is method name implementation is in @Query


@Query("SELECT e FROM Employee e WHERE e.email = ?1 AND e.salary = ?2")
Employee getEmployeeByEmailAndSalary(String email, int salary);
e.slary show slaryt filed of object
 */