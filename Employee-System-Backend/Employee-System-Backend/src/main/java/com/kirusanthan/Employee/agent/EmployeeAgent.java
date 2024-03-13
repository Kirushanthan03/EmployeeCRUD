package com.kirusanthan.Employee.agent;


import com.kirusanthan.Employee.converter.EmployeeConverter;
import com.kirusanthan.Employee.dto.EmployeeDto;
import com.kirusanthan.Employee.entity.Employee;
import com.kirusanthan.Employee.service.serviceImpl.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class EmployeeAgent {

    private final EmployeeService employeeService;
    private final EmployeeConverter employeeConverter;

    public EmployeeDto save(EmployeeDto employeeDto){
        Employee employee=employeeConverter.convertToEntity(employeeDto);
        Employee employee1 = employeeService.save(employee);
        return employeeConverter.convertToDto(employee1);
    }


    public List<EmployeeDto> getAll() {
        List<Employee> employeeList = employeeService.getAll();

        return employeeList.stream()
                .map(employeeConverter::convertToDto)
                .collect(Collectors.toList());
    }

    public void delete(String email) {
      employeeService.delete(email);
    }

    public EmployeeDto get(String email){
        Employee employee = employeeService.get(email);
        return employeeConverter.convertToDto(employee);
    }

    public EmployeeDto edit(EmployeeDto employeeDto,String email) {
        Employee employee = employeeConverter.convertToEntity(employeeDto);
        Employee employee1=employeeService.edit(employee,email);

        return employeeConverter.convertToDto(employee1);
    }
}
