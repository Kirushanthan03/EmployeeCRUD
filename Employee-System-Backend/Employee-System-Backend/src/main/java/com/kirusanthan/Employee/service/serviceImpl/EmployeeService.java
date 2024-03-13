package com.kirusanthan.Employee.service.serviceImpl;


import com.kirusanthan.Employee.entity.Employee;
import com.kirusanthan.Employee.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee save(Employee employee){
       return employeeRepository.save(employee);
    }

    public List<Employee> getAll() {

        return employeeRepository.findAll();
    }

    public void delete(String email) {

        Employee employee = employeeRepository.findByEmail(email);
        employeeRepository.delete(employee);
    }

    public Employee get(String email){
        return employeeRepository.findByEmail(email);
    }

    public Employee edit(Employee employee,String email) {
        Employee employee1 = employeeRepository.findByEmail(email);
        employee1.setFirstName(employee.getFirstName());
        employee1.setLastName(employee.getLastName());
        employee1.setEmail(employee.getEmail());
        return employeeRepository.save(employee1);
    }
}
