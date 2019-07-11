package com.da.inspectionList.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.da.inspectionList.model.Task;
import com.da.inspectionList.model.Task.ConstructionType;
import com.da.inspectionList.service.TaskServiceImpl;

@Controller
public class TaskController {

  @Autowired
  private TaskServiceImpl taskServiceImpl;

  @GetMapping(value = { "/tasks", "/" })
  public String index(@RequestParam(value="filter", required=false) ConstructionType filter, Model model) {
    List<Task> tasks = taskServiceImpl.findAll();
    if (filter == null) {
      tasks = taskServiceImpl.findAll();
    } else {
      tasks = taskServiceImpl.findAllTasksByConstructionType(filter);
    }
    model.addAttribute("filter", filter);
    model.addAttribute("tasks", tasks);
    return "index";
  }

  @GetMapping("/tasks/new")
  public String getTaskForm(Model model) {
    model.addAttribute("task", new Task());
    return "newTask";
  }
  
  @PostMapping("/tasks")
  public String submitTaskForm(Task task, Model model) {
    taskServiceImpl.saveTask(task);
    model.addAttribute("successMessage", "Inspection Task was successfully created");
    model.addAttribute("task", new Task());
    return "newTask";
  }

  @GetMapping("/tasks/{task_id}")
  public String getTaskById(@PathVariable("task_id") Long task_id, Model model) {
    Task task = taskServiceImpl.findTaskById(task_id);
    model.addAttribute("task", task);
    return "task";
  }
  
  @GetMapping("/task/{task_id}/edit")
  public String showUpdateForm(@PathVariable("task_id") Long task_id, Model model) {
    Task task = taskServiceImpl.findTaskById(task_id);
    model.addAttribute("task", task);
    return "editTask";
  }
  
  @PutMapping("/task/{task_id}/edit")
  public String update(@PathVariable("task_id") Long task_id, Task task, Model model) {
    Task updateTask = taskServiceImpl.findTaskById(task_id);
    updateTask.setConstructionType(task.getConstructionType());
    updateTask.setLocation(task.getLocation());
    updateTask.setInspActivity(task.getInspActivity());
    updateTask.setInspector(task.getInspector());
    updateTask.setStatus(task.getStatus());
    updateTask.setResult(task.getResult());
    taskServiceImpl.saveTask(updateTask);
    return "redirect:/tasks";
  }
  
  @RequestMapping(value="/task/{task_id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable("task_id") Long id) {
    taskServiceImpl.deleteById(id);
    return "redirect:/tasks";
  }

}
