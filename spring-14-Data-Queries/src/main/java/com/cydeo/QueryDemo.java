package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
    }




    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------Regions--------------");
        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("Contain:" + regionRepository.findByCountryContaining("United"));
        System.out.println("Sort:" + regionRepository.findByCountryContainsOrderByRegion("United"));
        System.out.println("Top:" + regionRepository.findTopByCountry("United States"));
        System.out.println("Top 2:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("find top by order:" + regionRepository.findByCountryContainsOrderByRegion("United States"));

        System.out.println("---------------Departments");

        System.out.println("findFurniture departmnet:" + departmentRepository.findByDepartment("Furniture"));

        System.out.println("findHealth division:" +departmentRepository.findByDivision("Health"));

    }


}
