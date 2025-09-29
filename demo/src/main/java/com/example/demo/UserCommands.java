package com.example.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellOption;

@ShellComponent
public class UserCommands {
    
  TasksClient tasksClient;
  FilesClient filesClient;

  public UserCommands(ApplicationContext ctx){
    tasksClient = ctx.getBean(TasksClient.class);
    filesClient = ctx.getBean(FilesClient.class);
    tasksClient.setStorageType(new TasksList());
    filesClient.setStorageType(new TextFormat());
  }

  //ADD a Task
  @ShellMethod(key = "add", value = "Add a new Task")
  public void Add(){
    String content = null;
    while(content == null){
      content = org.jline.reader.LineReaderBuilder.builder().build().readLine("Please enter some content: ");
    }
    tasksClient.add(content);
    System.out.println("Task added: " + content);
  }

  //COMPLETE a Task
  @ShellMethod(key="complete", value="set a task as complete")
  public void Complete(@ShellOption(defaultValue = "0") String taskIndex){
    if("0".equals(taskIndex)){
      taskIndex = org.jline.reader.LineReaderBuilder.builder().build().readLine("Please enter the index of the task to be completed: ");
    }
    tasksClient.complete(Integer.parseInt(taskIndex));
  }

  //DELETE a Task
  @ShellMethod(key="delete", value="Remove a task from the saved Tasks")
  public void Delete(@ShellOption(defaultValue = "0") String taskIndex){
    if("0".equals(taskIndex)){
      taskIndex = org.jline.reader.LineReaderBuilder.builder().build().readLine("Please enter the index of the task to be deleted: ");
    }
    tasksClient.delete(Integer.parseInt(taskIndex));
  }

  //LIST all Tasks
  @ShellMethod(key="list", value="Display all saved tasks")
  public void List(){
    var list = tasksClient.list();
    list.forEach(i -> i.printTask());
  }

  //SHOW Memory Type
  @ShellMethod(key="memory", value="Display the current memory storage data structure")
  public void Show(){
    tasksClient.showType();
  }

  //SAVE to file storage
  @ShellMethod(key="save", value="Save to File Storage")
  public void SaveFile(){
    var list = tasksClient.list();
    filesClient.save(list);
  }

  //LOAD a file from storage
  @ShellMethod(key="load", value="Load from File Storage")
  public void loadFile(){
    var list = filesClient.read();
    tasksClient.addAll(list);
    List();
  }

  //SWAP file storage types
  @ShellMethod(key="change", value="Save to File Storage")
  public void ChangeType(@ShellOption(defaultValue=ShellOption.NULL) String type){
    while(type == null || !("txt".equals(type) || "dat".equals(type))){
      type = org.jline.reader.LineReaderBuilder.builder().build().readLine("Please choose either txt or dat file type: ");
    }
    if("txt".equals(type))
    {
      filesClient.setStorageType(new TextFormat());
    } else {
      filesClient.setStorageType(new DatFormat());
    }
  }
}
