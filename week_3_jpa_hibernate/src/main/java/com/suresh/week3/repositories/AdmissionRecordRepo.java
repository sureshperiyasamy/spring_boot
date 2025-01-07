package com.suresh.week3.repositories;

import com.suresh.week3.entities.AdmissionRecordEntity;
import com.suresh.week3.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdmissionRecordRepo extends JpaRepository<AdmissionRecordEntity,Long> {
}
