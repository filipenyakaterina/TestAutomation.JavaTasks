package ioFundamentals.mainTask.input;

import ioFundamentals.mainTask.analyzers.FileAnalyzer;
import ioFundamentals.mainTask.analyzers.FileStructureAnalyzer;
import ioFundamentals.mainTask.fileStructureEntities.DirectoryHierarchy;

import java.io.*;
import java.util.Objects;

public class DirectoryHierarchyCreator {
    private final DirectoryHierarchy directoryHierarchy;

    public DirectoryHierarchyCreator(DirectoryHierarchy directoryHierarchy) {
        this.directoryHierarchy = directoryHierarchy;
    }

    public void createFromFile(String filePath){
        try(FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while((line = bufferedReader.readLine()) != null){
                directoryHierarchy.add(FileAnalyzer.analyzeLine(line, directoryHierarchy));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createFromDirectory(String directoryPath){
        File Directory = new File(directoryPath);
        putFilesWithNestedLevel(directoryHierarchy, Directory);
    }

    private void putFilesWithNestedLevel(DirectoryHierarchy directoryHierarchy, File directory){
        for(File file: Objects.requireNonNull(directory.listFiles())){
            directoryHierarchy.add(FileStructureAnalyzer.getDirectoryHierarchyItem(directoryHierarchy,file));
            if(file.isDirectory()){
                putFilesWithNestedLevel(directoryHierarchy, file);
            }
        }
    }
}
