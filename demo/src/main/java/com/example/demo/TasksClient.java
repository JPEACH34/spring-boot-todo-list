package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TasksClient {
  
  @Autowired
  private TasksInterface tasksInterface;

  public void add(String content){ tasksInterface.addTask(content); }

  public List<Task> list(){
    List<Task> tasks = tasksInterface.list();

    return tasks;
  }

  public void complete(int taskIndex){tasksInterface.completeTask(taskIndex);}

  public void delete(int taskIndex){tasksInterface.deleteTask(taskIndex);}

  public void showType(){tasksInterface.showType();}

  public void addAll(ArrayList<Task> tasks){tasksInterface.addList(tasks);}

  //Setter-based Dependency Injection
  public void setStorageType(TasksInterface tasksInterface){
    this.tasksInterface = tasksInterface;
  }
}
