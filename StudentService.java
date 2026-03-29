package com.telusko.spring_boot_rest.service;


import com.telusko.spring_boot_rest.model.StudentPost;
import com.telusko.spring_boot_rest.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class StudentService {


    @Autowired
    private StudentRepo studRepo;


    public void addStudent(StudentPost studentPost){
        studRepo.save(studentPost);
    }

}
