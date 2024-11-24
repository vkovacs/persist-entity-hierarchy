package com.example.persist_entity_hierarchy;

import com.example.persist_entity_hierarchy.persistence.CompanyEntity;
import com.example.persist_entity_hierarchy.persistence.CompanyRepository;
import com.example.persist_entity_hierarchy.persistence.DepartmentEntity;
import com.example.persist_entity_hierarchy.persistence.EmployeeEntity;
import com.example.persist_entity_hierarchy.persistence.test.HasName;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final List<HasName> repositoriesWithName;

    @Transactional
    public void createFluent() {
        var fluentCompanyEntity = CompanyEntity.builder()
                .name("TechCorp").departmentEntities(List.of(DepartmentEntity.builder()
                        .name("IT Department").employeeEntities(List.of(
                                EmployeeEntity.builder()
                                        .name("Alice").salary(50000.0).build(),
                                EmployeeEntity.builder()
                                        .name("Bob").salary(55000.0).build()
                        )).build())).build();

        companyRepository.save(fluentCompanyEntity);
    }

    @Transactional
    public void query() {
        CompanyEntity company = findBy("TechCorp");
        EmployeeEntity employee = findBy("Alice");

        System.out.println("---");
        System.out.println("Company: " + company);
        System.out.println("Employee: " + employee);
        System.out.println("---");
    }

    public <T> T findBy(String name) {
        List<Object> results = repositoriesWithName.stream()
                .map(repo -> repo.findByName(name))
                .filter(Objects::nonNull)
                .toList();

        if (results.size() == 1) {
            return (T) results.get(0);
        }
        throw new IllegalArgumentException("Ambiguous or not found entity!");
    }
}
