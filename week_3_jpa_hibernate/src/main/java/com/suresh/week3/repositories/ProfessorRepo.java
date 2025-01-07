package com.suresh.week3.repositories;

import com.suresh.week3.entities.DepartmentEntity;
import com.suresh.week3.entities.ProfessorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepo extends JpaRepository<ProfessorEntity,Long> {
}
