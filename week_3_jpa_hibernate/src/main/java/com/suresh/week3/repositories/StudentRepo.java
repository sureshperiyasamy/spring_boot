package com.suresh.week3.repositories;

import com.suresh.week3.dto.StudentDTO;
import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity,Long> {}
