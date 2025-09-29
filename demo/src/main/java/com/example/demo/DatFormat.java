package com.example.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class DatFormat implements FilesInterface{
  
  @Override
  public void SaveTasks(List<Task> tasks){
    try(FileOutputStream fout = new FileOutputStream("./Tasks/ToDoList.dat")){
      String concatTask = "";
      for(int i = 0; i < tasks.size(); i++){
        Task temp = tasks.get(i);

        concatTask += temp.getIndex() + "\n" + temp.getContent() + "\n" + temp.getStatus() + "\n"; 
      }

      for(char character : concatTask.toCharArray()){
        fout.write(character);
      }
    }catch(IOException e){
      System.out.println("Error saving to file");
    }
  }

  @Override
  public ArrayList<Task> GetTasks(){
    ArrayList<Task> tasks = new ArrayList<>();

    int i;
    String listString = "";

    try(FileInputStream fin = new FileInputStream("./Tasks/ToDoList.dat")){
      while((i = fin.read()) != -1){
        listString += (char) i;
      }
      i = 0;

      String[] listArr = listString.split("\n");

      while(i < listArr.length){
        Task temp = new Task();
        temp.setIndex(Integer.parseInt(listArr[i]));
        temp.setContent(listArr[i + 1]);
        if("COMPLETE".equals(listArr[i + 2])){temp.completeTask();}
        tasks.add(temp);
        i += 3;
      }

    }catch(IOException e){
      System.out.println("Error reading file.");
    }
    return tasks;
  }
}
