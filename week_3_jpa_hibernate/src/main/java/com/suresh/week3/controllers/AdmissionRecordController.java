package com.suresh.week3.controllers;

import com.suresh.week3.dto.AdmissionRecordDTO;
import com.suresh.week3.dto.DepartmentDTO;
import com.suresh.week3.dto.StudentDTO;
import com.suresh.week3.repositories.AdmissionRecordRepo;
import com.suresh.week3.services.AdmissionRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admissions")
public class AdmissionRecordController {

    private final AdmissionRecordService admissionRecordService ;

    public AdmissionRecordController(AdmissionRecordService admissionRecordService) {
        this.admissionRecordService = admissionRecordService;
    }

    @PostMapping
    public ResponseEntity<AdmissionRecordDTO> addNewAdmissionRecord(@RequestBody AdmissionRecordDTO inputRequestBody){
        AdmissionRecordDTO admissionRecord = admissionRecordService.addNewAdmissionRecord(inputRequestBody);
        return new ResponseEntity<>(admissionRecord, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<AdmissionRecordDTO> getStudentAdmissionRecord(@RequestBody AdmissionRecordDTO inputRequestBody){
        AdmissionRecordDTO admissionRecord = admissionRecordService.addNewAdmissionRecord(inputRequestBody);
        return new ResponseEntity<>(admissionRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{admissionId}/assign/{studentId}")
    public ResponseEntity<AdmissionRecordDTO> assignStudentToAdmissionRecord(@PathVariable Long studentId, @PathVariable Long admissionId) {
        AdmissionRecordDTO createdEmployee = admissionRecordService.assignStudentToAdmissionRecord(studentId, admissionId);
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
}
