package org.example;
import java.util.*;
import java.util.logging.Logger;


public class Main 
{
    public static final Logger Log = Logger.getLogger(("InfoLogging"));
    public static void main(String[] args)  throws Exception
    {
           Scanner input=new Scanner(System.in);
           FileHandle f=new FileHandle();
           Log.info("File Created.....");
           Thread.sleep(1000);
           f.path();
           Log.info("Enter the User input string:");
           String str=input.nextLine();
           Log.info("File is writed.....");
           Thread.sleep(1000);
           f.write(str);
           Log.info("File is Readed.....");
           Thread.sleep(1000);
           String data=f.read();
           Log.info("File is sorted.....");
           f.sort(data);
           f.display();
    }
}


