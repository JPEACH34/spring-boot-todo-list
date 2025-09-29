package com.example.demo;


public class Task {
  private int index;
  private String content;
  private String status;

  public Task(){
    index = 0;
    content = "";
    status = "INCOMPLETE";
  }

  public Task(int index, String content){
    this.index = index;
    this.content = content;
    this.status = "INCOMPLETE";
  }

  public int getIndex(){
    return this.index;
  }

  public void setIndex(int index){
    this.index = index;
  }

  public String getContent(){
    return this.content;
  }

  public void setContent(String content){
    this.content = content;
  }

  public String getStatus(){
    return this.status;
  }
  
  public void completeTask(){
    this.status = "COMPLETE";
  }

  public void printTask(){
    System.out.println("--------------------------------------------------------------------------");
    System.out.println("Task " + index + ": " + content);
    System.out.println(status);
    System.out.println("--------------------------------------------------------------------------");
  }
}
