package com.suresh.week3.repositories;

import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity,Long> {}
