package com.da.inspectionList.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.da.inspectionList.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  
}
