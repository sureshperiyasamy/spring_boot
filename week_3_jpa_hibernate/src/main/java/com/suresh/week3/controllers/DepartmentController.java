package com.suresh.week3.controllers;


import com.suresh.week3.dto.DepartmentDTO;
import com.suresh.week3.dto.EmployeeDTO;
import com.suresh.week3.services.DepartmentService;
import com.suresh.week3.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    // CREATE DEPARTMENT
    @PostMapping
    public ResponseEntity<DepartmentDTO> createNewDepartment(@RequestBody DepartmentDTO inputRequestBody) {
        DepartmentDTO createdEmployee = departmentService.createNewDepartment(inputRequestBody);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    // GET DEPARTMENT BY ID
    @GetMapping("/{departmentId}")
    public ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable Long departmentId) {
        DepartmentDTO createdEmployee = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    // ASSIGN MANAGER(EMPLOYEE) TO DEPARTMENT
    @PutMapping("/{departmentId}/assign/{employeeId}")
    public ResponseEntity<DepartmentDTO> assignManagerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        DepartmentDTO createdEmployee = departmentService.assignManagerToDepartment(departmentId, employeeId);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }

    // ASSIGN WORKER(EMPLOYEE) TO DEPARTMENT
    @PutMapping("/{departmentId}/worker/{employeeId}")
    public ResponseEntity<DepartmentDTO> assignWorkerToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        DepartmentDTO createdEmployee = departmentService.assignWorkerToDepartment(departmentId, employeeId);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
}
