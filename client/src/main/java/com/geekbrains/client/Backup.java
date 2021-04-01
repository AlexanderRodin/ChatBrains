package com.geekbrains.client;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Backup {


    public static void addMessageInHistory(String login, String text){

            try{

                File file = new File("history", login +".txt");
                FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(" "+text+"\n");
                bw.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
    }

  public static void newFile (String login){
      if(Files.exists(Paths.get("history", login+".txt")) == false){
          try {
              Path testFile1 = Files.createFile(Paths.get("history",login+".txt"));
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
  }



}
