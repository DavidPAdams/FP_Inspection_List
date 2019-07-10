package com.da.inspectionList.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
  public List<Task> findAllTasks();
  public List<Task> findAllTasksByStatus(Status status);
  public List<Task> findAllTasksByResult(Result result);
  public List<Task> findAllTasksByInspector(String inspector);
  public List<Task> findAllTasksByConstructionType(ConstructionType constructionType);
}
