package com.example.persist_entity_hierarchy;

import com.example.persist_entity_hierarchy.persistence.CompanyEntity;
import com.example.persist_entity_hierarchy.persistence.CompanyRepository;
import com.example.persist_entity_hierarchy.persistence.DepartmentEntity;
import com.example.persist_entity_hierarchy.persistence.EmployeeEntity;
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
        EmployeeEntity emp1 = new EmployeeEntity();
        emp1.setName("Alice");
        emp1.setSalary(50000.0);

        EmployeeEntity emp2 = new EmployeeEntity();
        emp2.setName("Bob");
        emp2.setSalary(55000.0);

        // Create Department
        DepartmentEntity departmentEntity = new DepartmentEntity();
        departmentEntity.setName("IT Department");
        departmentEntity.setEmployeeEntities(Arrays.asList(emp1, emp2));

        // Create Company
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setName("TechCorp");
        companyEntity.setDepartmentEntities(List.of(departmentEntity));

        companyRepository.save(companyEntity);

        System.out.println("---");
        System.out.println("Saved data: " + companyRepository.findAll());
        System.out.println("---");
    }
}
