package com.suresh.week3.dto;

import com.suresh.week3.entities.AdmissionRecordEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private Long id;
    private String name;
    private AdmissionRecordEntity admissionRecord;

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", admissionRecordDTO=" + admissionRecord +
                '}';
    }
}
