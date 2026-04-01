package com.telusko.spring_boot_rest.repo;

import com.telusko.spring_boot_rest.model.LogEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends JpaRepository<LogEntitiy,Integer> {
}
