package org.fsj.demo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Javaexe {
    public static void main(String[] args) {
        String s = "D:\\HJ\\AsposeConverter (1)\\Windows\\run.bat";
        try {
            Process pro = Runtime.getRuntime().exec(s);
            InputStreamReader reader = new InputStreamReader(pro.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line = null;
            while ((line = bufferedReader.readLine()) !=null){
                System.out.println(line);
            }
            bufferedReader.close();
            pro.destroy();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
