package org.fsj.demo;

import java.io.*;

public class InputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis;
        String line = "";
        try {
            fis = new FileInputStream("F:\\java\\Logback\\InfoLog.2018-02-08.log");
            InputStreamReader pr = new InputStreamReader(fis);
            BufferedReader br =  new BufferedReader(pr);
           while((line = br.readLine()) != null){
               System.out.println(line);
           }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
