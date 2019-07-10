package com.da.inspectionList.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;

@Service
public class TaskServiceImpl implements TaskServiceInterface {

  @Override
  public List<Task> findAllTasks() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Task> findAllTasksByStatus(Status status) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Task> findAllTasksByResult(Result result) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Task> findAllTasksByInspector(String inspector) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<Task> findAllTasksByConstructionType(ConstructionType constructionType) {
    // TODO Auto-generated method stub
    return null;
  }
  
}
