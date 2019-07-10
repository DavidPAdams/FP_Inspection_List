package com.da.inspectionList.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.da.inspectionList.service.TaskServiceImpl;

@Controller
public class TaskController {

    @Autowired
    private TaskServiceImpl taskServiceImpl;
    
    @GetMapping("/")
    public String index() {
      return "index";
    }
    
    
}
