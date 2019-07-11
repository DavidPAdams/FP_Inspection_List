package com.da.inspectionList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  public List<Task> findAll();
  public List<Task> findAllTasksByConstructionType(ConstructionType constructionType);
  public Task findTaskById(Long task_id);
}
