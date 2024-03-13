package com.kirusanthan.Employee.controller;


import com.kirusanthan.Employee.agent.EmployeeAgent;
import com.kirusanthan.Employee.dto.EmployeeDto;
import com.kirusanthan.Employee.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/employee")
@CrossOrigin("*")
public class EmployeeController {

    private final EmployeeAgent employeeAgent;

    @PostMapping("/save")
    public EmployeeDto save(@RequestBody EmployeeDto employeeDto){
        return employeeAgent.save(employeeDto);
    }

    @GetMapping("/getAll")
    public List<EmployeeDto> getAll(){
        return employeeAgent.getAll();
    }

    @DeleteMapping("/delete/{email}")
    public void delete(@PathVariable("email") String email){

        employeeAgent.delete(email);

    }

    @GetMapping("/get/{email}")
    public EmployeeDto get(@PathVariable("email") String email){
        return employeeAgent.get(email);
    }

    @PutMapping("/edit/{email}")
    public EmployeeDto edit(@RequestBody EmployeeDto employeeDto ,@PathVariable String email){
        return employeeAgent.edit(employeeDto,email);
    }



}
