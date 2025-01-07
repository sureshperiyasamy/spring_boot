package com.suresh.week3.services;


import com.suresh.week3.dto.DepartmentDTO;
import com.suresh.week3.dto.EmployeeDTO;
import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.EmployeeEntity;
import com.suresh.week3.repositories.DepartmentRepository;
import com.suresh.week3.repositories.EmployeeRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {


    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // CREATE NEW DEPARTMENT
    public DepartmentDTO createNewDepartment(DepartmentDTO inputRequestBody) {
        DepartmentEntity departmentEntity = modelMapper.map(inputRequestBody, DepartmentEntity.class);
        DepartmentEntity savedEntity = departmentRepository.save(departmentEntity);
        return modelMapper.map(savedEntity, DepartmentDTO.class);
    }

    public DepartmentDTO getDepartmentById(Long departmentId) {
        DepartmentEntity departmentEntity = departmentRepository.findById(departmentId).orElse(null);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);
    }

    public DepartmentDTO assignManagerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        DepartmentEntity departmentEntityMapper = departmentEntity.flatMap(department ->
                employeeEntity.map(employee -> {
                    department.setManager(employee);
                    return departmentRepository.save(department);
                })).orElse(null);

        return modelMapper.map(departmentEntityMapper, DepartmentDTO.class);
    }

    public DepartmentDTO assignWorkerToDepartment(Long departmentId, Long employeeId) {
        Optional<DepartmentEntity> departmentEntity = departmentRepository.findById(departmentId);
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);

        DepartmentEntity departmentEntityMapper = departmentEntity
                .flatMap(department ->
                employeeEntity.map(employee -> {

                    employee.setWorkerDepartment(department);
                    employeeRepository.save(employee);

                    department.getWorkers().add(employee);
                    return department;

                })).orElse(null);

        return modelMapper.map(departmentEntityMapper, DepartmentDTO.class);
    }
}
