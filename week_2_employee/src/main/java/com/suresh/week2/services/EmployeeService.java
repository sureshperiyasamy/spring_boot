package com.suresh.week2.services;

import com.suresh.week2.dto.EmployeeDTO;
import com.suresh.week2.entities.EmployeeEntity;
import com.suresh.week2.exceptions.ResourceNotFoundException;
import com.suresh.week2.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;


    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    public Optional<EmployeeDTO> getEmployeeById(Long employeeId) {
        Optional<EmployeeEntity> employeeEntity = employeeRepository.findById(employeeId);
        return employeeEntity.map((employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class)));
//        return employeeRepository.findById(employeeId).map((employeeEntity1 -> modelMapper.map(employeeEntity1, EmployeeDTO.class)));
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
        return employeeEntityList
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputRequestBody) {
        EmployeeEntity employeeEntity = modelMapper.map(inputRequestBody, EmployeeEntity.class);
        EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEntity, EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployeeById(EmployeeDTO employeeDTO, Long employeeId) {
        boolean isEmployeeExists = employeeRepository.existsById(employeeId);
        if (!isEmployeeExists) {
            throw new ResourceNotFoundException("Employee not found with id "+employeeId);
        }
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployeeEntity, EmployeeDTO.class);
    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean isEmployeeExists = employeeRepository.existsById(employeeId);
        if (isEmployeeExists) {
            employeeRepository.deleteById(employeeId);
            return true;
        } else {
            return false;
        }
    }

    public EmployeeDTO updatePatchEmployeeById(Long employeeId, Map<String, Object> objectMap) {
        boolean isEmployeeExists = employeeRepository.existsById(employeeId);
        if(!isEmployeeExists) return null;
        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
        objectMap.forEach((field,value) -> {
            Field fieldToBeUpdated = ReflectionUtils.findRequiredField(EmployeeEntity.class,field);
            fieldToBeUpdated.setAccessible(true);
            ReflectionUtils.setField(fieldToBeUpdated, employeeEntity, value);
        });
        return modelMapper.map(employeeRepository.save(employeeEntity),EmployeeDTO.class);
    }
}
