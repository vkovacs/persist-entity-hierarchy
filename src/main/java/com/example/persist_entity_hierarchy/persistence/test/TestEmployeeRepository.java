package com.example.persist_entity_hierarchy.persistence.test;

import com.example.persist_entity_hierarchy.persistence.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, HasName<EmployeeEntity> {
}