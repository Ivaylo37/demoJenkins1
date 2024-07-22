package com.example.repository;

import com.example.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.Optional;

@Transactional
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public Employee findByEmployeeId(Long id);

    public <S extends Employee> S save(S customer);
}
