package collections.optionalTask.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Writer {
    public void writeLinesToFile(List<String> lines, String fileName)
    {
        try(BufferedWriter bufferedWriter = new BufferedWriter( new FileWriter(fileName))){
            for(String str : lines){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
            }
        }
        catch(IOException exception){
            System.out.println(exception.getMessage());
        }
    }
}
