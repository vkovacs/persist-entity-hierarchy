package com.example.persist_entity_hierarchy;

import com.example.persist_entity_hierarchy.persistence.Company;
import com.example.persist_entity_hierarchy.persistence.CompanyRepository;
import com.example.persist_entity_hierarchy.persistence.Department;
import com.example.persist_entity_hierarchy.persistence.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Transactional
    public void create() {
        // Create Employees
        Employee emp1 = new Employee();
        emp1.setName("Alice");
        emp1.setSalary(50000.0);

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setSalary(55000.0);

        // Create Department
        Department department = new Department();
        department.setName("IT Department");
        department.setEmployees(Arrays.asList(emp1, emp2));

        // Create Company
        Company company = new Company();
        company.setName("TechCorp");
        company.setDepartments(List.of(department));

        companyRepository.save(company);

        System.out.println("---");
        System.out.println("Saved data: " + companyRepository.findAll());
        System.out.println("---");
    }
}
