package com.suresh.week2.controllers;


import com.suresh.week2.dto.EmployeeDTO;
import com.suresh.week2.entities.EmployeeEntity;
import com.suresh.week2.exceptions.ResourceNotFoundException;
import com.suresh.week2.repositories.EmployeeRepository;
import com.suresh.week2.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @GetMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long employeeId) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(employeeId);
        return employeeDTO
                .map((employeeDTO1 -> ResponseEntity.ok(employeeDTO1)))
//                .orElse(ResponseEntity.notFound().build());
                .orElseThrow(() -> new ResourceNotFoundException("Resource not found with id "+employeeId));
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(@RequestBody @Valid EmployeeDTO inputRequestBody) {
        EmployeeDTO createdEmployee = employeeService.createNewEmployee(inputRequestBody);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    @PutMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployeeById(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
//        return employeeService.updateEmployeeById(employeeDTO, employeeId);
        return ResponseEntity.ok(employeeService.updateEmployeeById(employeeDTO, employeeId));
    }

    @DeleteMapping(path = "/{employeeId}")
    public ResponseEntity<Boolean> deleteEmployeeById(@PathVariable Long employeeId) {
        boolean isDeleted = employeeService.deleteEmployeeById(employeeId);
        if (isDeleted)
            return ResponseEntity.ok(employeeService.deleteEmployeeById(employeeId));
        else
            return ResponseEntity.notFound().build();
    }


    @PatchMapping(path = "/{employeeId}")
    public ResponseEntity<EmployeeDTO> updatePatchEmployeeById(@PathVariable Long employeeId, @RequestBody Map<String, Object> objectMap) {
        EmployeeDTO employeeDTO = employeeService.updatePatchEmployeeById(employeeId, objectMap);
        if (employeeDTO == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(employeeService.updatePatchEmployeeById(employeeId, objectMap));
    }




}
