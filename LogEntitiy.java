package com.telusko.spring_boot_rest.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CollectionId;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class LogEntitiy {

    @Id
    @GeneratedValue
    private int id;

    private String methodName;
    private String methodMessage;
    private LocalDateTime timeStamp;
}
