package com.da.inspectionList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;
import com.da.inspectionList.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskServiceInterface {
  
  @Autowired
  private TaskRepository taskRepository;

  public List<Task> findAll() {
    List<Task> tasks = taskRepository.findAll();
    return tasks;
  }

  @Override
  public List<Task> findAllTasksByStatus(Status status) {
    List<Task> tasks = taskRepository.findAllTasksByStatus(status);
    return tasks;
  }

  @Override
  public List<Task> findAllTasksByResult(Result result) {
    List<Task> tasks = taskRepository.findAllTasksByResult(result);
    return tasks;
  }

  @Override
  public List<Task> findAllTasksByInspector(String inspector) {
    List<Task> tasks = taskRepository.findAllTasksByInspector(inspector);
    return tasks;
  }

  @Override
  public List<Task> findAllTasksByConstructionType(ConstructionType constructionType) {
    List<Task> tasks = taskRepository.findAllTasksByConstructionType(constructionType);
    return tasks;
  }
  
  @Override
  public Task findTaskById(Long task_id) {
    Task task = taskRepository.findTaskById(task_id);
    return task;
  }
  
}
