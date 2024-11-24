package com.example.persist_entity_hierarchy;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Application {
    private final CompanyService companyService;

    @PostConstruct
    public void start() {
        companyService.createFluent();
    }
}
