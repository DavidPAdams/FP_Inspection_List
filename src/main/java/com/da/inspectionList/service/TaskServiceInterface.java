package com.da.inspectionList.service;

import java.util.List;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;

public interface TaskServiceInterface {
  public List<Task> findAllTasks();
  public List<Task> findAllTasksByConstructionType(ConstructionType constructionType);
  public Task findTaskById(Long task_id);
}
