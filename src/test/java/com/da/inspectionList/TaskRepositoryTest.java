package com.da.inspectionList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;
import com.da.inspectionList.repository.TaskRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TaskRepositoryTest {
  
  private static Task testTaskOne;
  private static Task testTaskTwo;
  private static List<Task> testTaskList;
  
  @Autowired
  private TestEntityManager testEntityManager;
  
  @Autowired
  private TaskRepository taskRepository;
  
  @Before
  public void setUp() {
    testTaskOne = new Task(ConstructionType.REBAR, "Arts Building", "Check vert & horiz reinforcement for C2 column", "Ben DeBarre", Status.PENDING, Result.PENDING);
    testTaskTwo = new Task(ConstructionType.REBAR, "Arts Building", "Check beam and column rebar", "Frank Fluxter", Status.PENDING, Result.PENDING);
    testEntityManager.persistAndFlush(testTaskOne);
    testEntityManager.persistAndFlush(testTaskTwo);
    testTaskList = new ArrayList<>(Arrays.asList(testTaskOne, testTaskTwo));
  }
  
  @Test
  public void givenTaskById_returnTask() {
    Task result = taskRepository.findTaskById(testTaskOne.getId());
    assertThat(testTaskOne).isEqualToComparingFieldByField(result);
  }
  
  @Test
  public void findAll_returnsAllTasks() {
    List<Task> result = taskRepository.findAll();
    assertEquals(result, testTaskList);
  }
  
  @Test
  public void findAllTasksByConstructionType_returnsTasksOfSameConstructionType() {
    List<Task> result = taskRepository.findAllTasksByConstructionType(testTaskTwo.getConstructionType());
    assertEquals(testTaskList, result);
  }

}
   