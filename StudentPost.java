package com.telusko.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentPost {


    @Id
    private long studNumber;
    private String studentName;
    private String studEducation;
    private int studExperience;
    private String studEmail;
    private String studCollege;


}
