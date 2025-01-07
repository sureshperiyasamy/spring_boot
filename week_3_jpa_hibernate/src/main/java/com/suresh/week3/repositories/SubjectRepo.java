package com.suresh.week3.repositories;

import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<SubjectEntity,Long> {
}
