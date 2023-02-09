package org.example;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.Logger;

class FileHandle
{
    public static final Logger Log = Logger.getLogger(("InfoLogging"));
    ArrayList<Map.Entry<String, Integer> > listOfEntry;
    File path;
    public void path()
    {
        path = new File("FileRead.txt");
    }
    public String read() throws IOException {
        String readData =""+path;
        return new String(Files.readAllBytes(Paths.get(readData)));
    }
    public void write(String value) throws IOException {
        FileWriter fileWrite = new FileWriter(path);
        for (int i = 0; i < value.length(); i++)
            fileWrite.write(value.charAt(i));
        fileWrite.flush();
        fileWrite.close();
    }
    public void sort(String data)
    {
        Map<String, Integer> hashMap = new HashMap<>();
        String[] words = data.split(" ");
        for (String word : words) {
            Integer integer = hashMap.get(word);
            if (integer == null)
                hashMap.put(word, 1);
            else
            {
                hashMap.put(word, integer + 1);
            }
        }
        Set<Map.Entry<String, Integer> > entrySet = hashMap.entrySet();
        listOfEntry = new ArrayList<>(entrySet);
        listOfEntry.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
    }
    public void display()
    {
        String print=""+listOfEntry;
        Log.info(print);
    }
}
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


