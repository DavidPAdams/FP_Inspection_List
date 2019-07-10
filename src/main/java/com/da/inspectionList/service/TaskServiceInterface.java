package com.da.inspectionList.service;

import java.util.List;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;

public interface TaskServiceInterface {
  public List<Task> findAll();
  public List<Task> findAllTasksByStatus(Status status);
  public List<Task> findAllTasksByResult(Result result);
  public List<Task> findAllTasksByInspector(String inspector);
  public List<Task> findAllTasksByConstructionType(ConstructionType constructionType);
  public Task findTaskById(Long task_id);
}
