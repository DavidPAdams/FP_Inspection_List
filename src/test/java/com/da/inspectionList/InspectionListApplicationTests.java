package com.da.inspectionList;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.da.inspectionList.model.Task;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InspectionListApplicationTests {

	@Test
	@Ignore
	public void contextLoads() {
	}
	
	@Test
	public void taskDomainExistsTDD() {
	  Task testTask = new Task();
	  assertThat(testTask.getStatus()).isNotEqualTo(null);
	}

}
