package com.example.persist_entity_hierarchy.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
}
