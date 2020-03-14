package collections.optionalTask.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Reader {
    public List<String> readLinesFromFileToList(String fileName){
        List<String> lines = new LinkedList<>();

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;

            while((line = bufferedReader.readLine()) != null){
                lines.add(line.trim());
            }
        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        return lines;
    }

    public HashSet<String> readWordsFromFile(String fileName){
        HashSet<String> words = new HashSet<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;

            while((line = bufferedReader.readLine()) != null){
                StringTokenizer stringTokenizer = new StringTokenizer(
                        line," (){}[]<>#*!?.,:;-\'\"/");
                while (stringTokenizer.hasMoreTokens()){
                    String word = stringTokenizer.nextToken();
                    words.add(word.toLowerCase());
                }
            }

        }
        catch (IOException exception){
            System.out.println(exception.getMessage());
        }
        return words;
    }
}
