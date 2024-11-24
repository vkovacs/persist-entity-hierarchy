package com.example.persist_entity_hierarchy.persistence;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id") // Foreign key in Department table
    private List<DepartmentEntity> departmentEntities;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DepartmentEntity> getDepartmentEntities() {
        return departmentEntities;
    }

    public void setDepartmentEntities(List<DepartmentEntity> departmentEntities) {
        this.departmentEntities = departmentEntities;
    }
}