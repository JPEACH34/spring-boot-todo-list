package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public interface TasksInterface {
  
  void showType();

  void addTask(String content);

  List<Task> list();

  void completeTask(int taskIndex);
  
  void deleteTask(int taskIndex);

  void addList(ArrayList<Task> tasksList);
}
