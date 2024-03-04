package com.example.testservice.service;

import com.example.testservice.model.Employee;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Slf4j
@Service
public class TestService {

    private final RestTemplate restTemplate;

    private final String url = "http://localhost:8080/api/v1";

    @PostConstruct
    public void init() {
        Employee employee = Employee.builder()
            .firstName("Ivan")
            .lastName("Petrov")
            .build();

        log.info("Employee create: {}", employee);
        restTemplate.postForObject(url, employee, Void.class);
        employee = restTemplate.getForObject(url + "/" + 1L, Employee.class);
        log.info("Employee get: {}", employee);
        restTemplate.delete(url + "/" + 1L);
        employee = restTemplate.getForObject(url + "/" + 1L, Employee.class);
        log.info("Employee delete: {}", employee);
    }
}
