package com.suresh.week3.dto;

import com.suresh.week3.entities.StudentEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdmissionRecordDTO {
    private Long id;
    private Integer fees;
    private StudentEntity studentRecord;
}
