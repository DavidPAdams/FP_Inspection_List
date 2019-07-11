package com.da.inspectionList.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskServiceInterface {
  
  @Autowired
  private TaskRepository taskRepository;

  @Override
  public List<Task> findAll() {
    List<Task> tasks = taskRepository.findAll();
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

  public void saveTask(Task task) {
    taskRepository.save(task);    
  }

  public void deleteById(Long id) {
    taskRepository.deleteById(id);
  }
  
}
