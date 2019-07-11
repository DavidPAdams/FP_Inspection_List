package com.da.inspectionList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.model.Task.Result;
import com.da.inspectionList.model.Task.Status;
import com.da.inspectionList.repository.TaskRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.MOCK,
                classes = InspectionListApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-testing.properties")
public class InspectionListApplicationIntegrationTest {

  private Task testTaskOne;
  private Task testTaskTwo;
  
  @Autowired
  private TaskRepository taskRepository;
  
  @Autowired
  private MockMvc mvc;
  
  @Before
  public void setUp() {
    testTaskOne = new Task(ConstructionType.REBAR, "Arts Building", "Check vert & horiz reinforcement for C2 column", "Ben DeBarre", Status.PENDING, Result.PENDING);
    taskRepository.save(testTaskOne);
    testTaskTwo = new Task(ConstructionType.REBAR, "Arts Building", "Check beam and column rebar", "Frank Fluxter", Status.PENDING, Result.PENDING);
    taskRepository.save(testTaskTwo);
  }
  
  @After
  public void tearDown() {
    taskRepository.deleteAll();
  }
	
  @Test
  public void getIndex_returnsHtmlAnd200Status() throws Exception {
    mvc.perform(get("/").contentType(MediaType.TEXT_HTML)).andExpect(status().isOk());
  }

}

