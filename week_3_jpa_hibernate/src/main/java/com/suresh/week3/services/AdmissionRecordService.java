package com.suresh.week3.services;

import com.suresh.week3.dto.AdmissionRecordDTO;
import com.suresh.week3.dto.DepartmentDTO;
import com.suresh.week3.dto.StudentDTO;
import com.suresh.week3.entities.AdmissionRecordEntity;
import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.EmployeeEntity;
import com.suresh.week3.entities.StudentEntity;
import com.suresh.week3.repositories.AdmissionRecordRepo;
import com.suresh.week3.repositories.StudentRepo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdmissionRecordService {
    private final AdmissionRecordRepo admissionRecordRepo ;
    private final StudentRepo studentRepo ;
    private final ModelMapper modelMapper;

    public AdmissionRecordService(AdmissionRecordRepo admissionRecordRepo, StudentRepo studentRepo, ModelMapper modelMapper) {
        this.admissionRecordRepo = admissionRecordRepo;
        this.studentRepo = studentRepo;
        this.modelMapper = modelMapper;
    }

    public AdmissionRecordDTO addNewAdmissionRecord(AdmissionRecordDTO inputRequestBody) {
        AdmissionRecordEntity admissionRecordEntity = modelMapper.map(inputRequestBody, AdmissionRecordEntity.class);
        AdmissionRecordEntity savedEntity = admissionRecordRepo.save(admissionRecordEntity);
        return modelMapper.map(savedEntity, AdmissionRecordDTO.class);
    }

    public AdmissionRecordDTO assignStudentToAdmissionRecord(Long studentId, Long admissionId) {
        Optional<AdmissionRecordEntity> admissionRecordEntity = admissionRecordRepo.findById(admissionId);
        Optional<StudentEntity> studentEntity = studentRepo.findById(studentId);

        AdmissionRecordEntity admissionRecordMapper = admissionRecordEntity.flatMap(admissionRecord ->
                studentEntity.map(student -> {
                    admissionRecord.setStudentRecord(student);
                    return admissionRecordRepo.save(admissionRecord);
                })).orElse(null);

        return modelMapper.map(admissionRecordMapper, AdmissionRecordDTO.class);
    }
}
