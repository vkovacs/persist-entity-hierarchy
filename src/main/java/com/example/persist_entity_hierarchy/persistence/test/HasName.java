package com.example.persist_entity_hierarchy.persistence.test;

public interface HasName<T> {
    T findByName(String name);
}