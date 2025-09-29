package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class TasksList implements TasksInterface{
  private final List<Task> tasks = new ArrayList<>();
  private int nextIndex = 1;

  @Override
  public void addTask(String content){
    Task task = new Task(nextIndex++, content);
    tasks.add(task);
  }

  public void setIndex(int taskIndex){
    tasks.get(taskIndex + 1).setIndex(taskIndex);
  }

  @Override
  public List<Task> list(){
    return tasks;
  }

  @Override
  public void completeTask(int taskIndex){
    tasks.get(taskIndex - 1).completeTask();
  }

  @Override
  public void addList(ArrayList<Task> list){
    tasks.addAll(list);
    reIndex();
  }

  @Override
  public void deleteTask(int taskIndex){
    if(tasks.removeIf(entry -> entry.getIndex() == taskIndex)){
      reIndex();
    }
  }

  public void reIndex(){
    for(int i = 0; i < tasks.size(); i++){
        tasks.get(i).setIndex(i + 1);
      }
  }

  @Override 
  public void showType(){
    System.out.println("Array List");
  }
}
