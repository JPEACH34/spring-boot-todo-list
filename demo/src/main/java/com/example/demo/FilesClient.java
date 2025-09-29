package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FilesClient {

  private final TasksClient tasksClient;

  public FilesClient(TasksClient tasksClient){
    this.tasksClient = tasksClient;
  }
  
  @Autowired
  private FilesInterface filesInterface;

  public void save(List<Task> tasks){
    filesInterface.SaveTasks(tasks);
  }

  public ArrayList<Task> read(){
    return filesInterface.GetTasks();
  }

  //Setter-based Dependency Injection
  public void setStorageType(FilesInterface handleFile){
    this.filesInterface = handleFile;
  }
}
