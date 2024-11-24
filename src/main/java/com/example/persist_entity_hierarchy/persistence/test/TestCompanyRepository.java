package com.example.persist_entity_hierarchy.persistence.test;

import com.example.persist_entity_hierarchy.persistence.CompanyEntity;
import com.example.persist_entity_hierarchy.persistence.CompanyRepository;

public interface TestCompanyRepository extends CompanyRepository, HasName<CompanyEntity> {
}