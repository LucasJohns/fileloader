/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luke
 */
public class CompilerJ {
    
    public static void execute(double[] values){
        String s = "java Code  ";
        for (double v: values){
            s += v + " ";
        }
        
        System.out.println(s);
        runProcess("javac Code.java");
        runProcess(s);
    }
    
     public static void printLines(String name, InputStream ins){
        String line = null;
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(ins));
            String completeText = "";
            while((line = in.readLine()) != null){
               System.out.println(line);
               completeText += line +"\n";
               Gui2.g2.setOutputText(completeText);
            }
             
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
     public static void runProcess(String command){
        try{
            Process pro = Runtime.getRuntime().exec(command);
            printLines(command+" stdout: ",pro.getInputStream());
            printLines(command+" stdrr: ",pro.getErrorStream());
            try {
                pro.waitFor();
            } catch (InterruptedException ex) {
                Logger.getLogger(CompilerJ.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(pro.exitValue());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
