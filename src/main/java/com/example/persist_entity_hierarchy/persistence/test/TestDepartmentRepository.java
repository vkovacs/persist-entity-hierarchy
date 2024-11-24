package com.example.persist_entity_hierarchy.persistence.test;

import com.example.persist_entity_hierarchy.persistence.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestDepartmentRepository extends JpaRepository<DepartmentEntity, Integer>, HasName<DepartmentEntity> {
}