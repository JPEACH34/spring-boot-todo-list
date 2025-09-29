package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public interface FilesInterface {
  
  public void SaveTasks(List<Task> tasks);

  public ArrayList<Task> GetTasks();
}
