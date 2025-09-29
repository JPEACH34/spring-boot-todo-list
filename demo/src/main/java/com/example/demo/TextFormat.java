package com.example.demo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Component;

@Component
public class TextFormat implements FilesInterface{

  @Override
  public void SaveTasks(List<Task> tasks){

    File oldFile = new File("./Tasks/ToDoList.txt");
    oldFile.delete();

    for(int i = 0; i < tasks.size(); i++){
      Task temp = tasks.get(i);
      temp.printTask();
      int index = temp.getIndex();
      String content = temp.getContent();
      String status = temp.getStatus();

      try(FileWriter writer = new FileWriter("./Tasks/ToDoList.txt", true)){
        writer.write(index + "\n" + content + "\n" + status + "\n");
      }catch(IOException e){
        System.out.println("Error writing Task to file.");
      }
    }
  }

  @Override
  public ArrayList<Task> GetTasks(){
    ArrayList<Task> tasks = new ArrayList<>();
    
    File taskFile = new File("./Tasks/ToDoList.txt");
  
    try(Scanner fileReader = new Scanner(taskFile)){
      while(fileReader.hasNextLine()){
        Task temp = new Task();

        //Get Individual Task
        String indexString = fileReader.nextLine();
        int index = Integer.parseInt(indexString);
        String content = fileReader.nextLine();
        String status = fileReader.nextLine();

        temp.setIndex(index);
        temp.setContent(content);
        if("COMPLETE".equals(status)){temp.completeTask();}
        tasks.add(temp);
      }
    }catch(IOException e){
      System.out.println("Error reading from File.");
    }

    return tasks;
  }
}