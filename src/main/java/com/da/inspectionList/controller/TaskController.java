package com.da.inspectionList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.service.TaskServiceImpl;

@Controller
public class TaskController {

  @Autowired
  private TaskServiceImpl taskServiceImpl;

  @GetMapping(value = { "/tasks", "/" })
  public String index() {
    return "index";
  }

  @GetMapping("/tasks/{task_id}")
  public String getTaskById(@PathVariable("task_id") Long task_id, Model model) {
    Task task = taskServiceImpl.findTaskById(task_id);
    model.addAttribute("task", task);
    return "task";
  }

  @GetMapping("/tasks/new")
  public String getTaskForm(Model model) {
    model.addAttribute("task", new Task());
    return "newTask";
  }

}
