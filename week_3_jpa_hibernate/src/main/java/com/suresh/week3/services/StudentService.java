package com.suresh.week3.services;

import com.suresh.week3.dto.DepartmentDTO;
import com.suresh.week3.dto.StudentDTO;
import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.StudentEntity;
import com.suresh.week3.repositories.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    private final StudentRepo studentRepo ;
    private final ModelMapper modelMapper;

    public StudentService(StudentRepo studentRepo, ModelMapper modelMapper) {
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    // ADD NEW STUDENT
    public StudentDTO addNewStudent(StudentDTO inputRequestBody) {
        System.out.println("Student service "+inputRequestBody.toString());
        StudentEntity studentEntity = modelMapper.map(inputRequestBody, StudentEntity.class);
        StudentEntity savedEntity = studentRepo.save(studentEntity);
        return modelMapper.map(savedEntity, StudentDTO.class);
    }

    public DepartmentDTO assignStudentToAdmissionRecord(Long studentId, Long admissionId) {
        return null;
    }
}
