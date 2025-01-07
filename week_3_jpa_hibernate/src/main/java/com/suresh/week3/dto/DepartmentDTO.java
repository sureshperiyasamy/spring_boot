package com.suresh.week3.dto;


import com.suresh.week3.entities.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {

    private Long id;
    private String title;
    private EmployeeDTO manager;
    private Set<EmployeeEntity> workers;
}
