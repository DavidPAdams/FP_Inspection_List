package com.da.inspectionList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;
import com.da.inspectionList.repository.TaskRepository;
import com.da.inspectionList.service.TaskServiceImpl;
import com.da.inspectionList.service.TaskServiceInterface;

@RunWith(SpringRunner.class)
public class TaskServiceTest {

  @Configuration
  static class ServiceConfiguration {
    @Bean
    public TaskServiceInterface configuration() {
      return new TaskServiceImpl();
    }
  }
  
  @Autowired
  private TaskServiceInterface taskServiceInterface;
  
  @MockBean
  private TaskRepository taskRepository;
  
  private static Task testTaskOne;
  private static Task testTaskTwo;
  private static List<Task> testTaskList;
  
  @Before
  public void setUp() {
    testTaskOne = new Task(ConstructionType.REBAR, "Arts Building", "Check vert & horiz reinforcement for C2 column", "Ben DeBarre", Status.PENDING, Result.PENDING);
    testTaskTwo = new Task(ConstructionType.REBAR, "Arts Building", "Check beam and column rebar", "Frank Fluxter", Status.PENDING, Result.PENDING);
    testTaskList = new ArrayList<>(Arrays.asList(testTaskOne, testTaskTwo));
  }
  
  @Test
  public void givenTaskId_returnTask() {
    Mockito.when(taskRepository.findTaskById(testTaskOne.getId())).thenReturn(testTaskOne);
    Task result = taskServiceInterface.findTaskById(testTaskOne.getId());
    assertThat(testTaskOne).isEqualToComparingFieldByField(result);
  }

  @Test
  public void givenTasks_returnAllTasks() {
    Mockito.when(taskRepository.findAll()).thenReturn(testTaskList);
    List<Task> result = taskServiceInterface.findAll();
    assertEquals(testTaskList, result);
  }
  
  @Test
  public void givenConstructionType_returnAllTasksByConstructionType() {
    Mockito.when(taskRepository.findAllTasksByConstructionType(testTaskTwo.getConstructionType()))
           .thenReturn(testTaskList);
    List<Task> result = taskServiceInterface.findAllTasksByConstructionType(testTaskTwo.getConstructionType());
    assertEquals(testTaskList, result);
  }
}
