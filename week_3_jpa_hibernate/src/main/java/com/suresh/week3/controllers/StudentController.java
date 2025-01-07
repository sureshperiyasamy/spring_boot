package com.suresh.week3.controllers;

import com.suresh.week3.dto.DepartmentDTO;
import com.suresh.week3.dto.StudentDTO;
import com.suresh.week3.repositories.AdmissionRecordRepo;
import com.suresh.week3.repositories.StudentRepo;
import com.suresh.week3.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService ;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addNewStudent(@RequestBody StudentDTO inputRequestBody){
        System.out.println("Student controller "+inputRequestBody.toString());
        StudentDTO student = studentService.addNewStudent(inputRequestBody);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


}
