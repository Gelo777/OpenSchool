package com.example.openschool1.service;

import com.example.openschool1.model.Employee;
import com.example.openschool1.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
       return employeeRepository.save(employee);
    }

    public Employee get(Long id){
        log.info("all employee {}", employeeRepository.findAll());
       return employeeRepository.findById(id).orElse(null);
    }

    public void delete(Long id){
       employeeRepository.deleteById(id);
    }
}
