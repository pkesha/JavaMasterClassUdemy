package com.keshavarziparham;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        try {
            //Will copy and create file
            Path sourceFile = FileSystems.getDefault().getPath("Examples", "files1.txt");
            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1Copy.txt");
            Files.copy(sourceFile, copyFile);
        } catch (IOException e){
            e.printStackTrace();
        }

    }

    //This code is for Exists, prior to CopyFile
//        Path path = FileSystems.getDefault().getPath("WorkingDirectoryFile.txt");
//        printFile(path);
//        //If more subdirectories, add more arguments in order that you want them to appear in the path
//        //Path filePath = FileSystems.getDefault().getPath("files","SubdirectoryFile.txt");
//
//        //Current path is represented by ".", then passing files directory, then doing text file
//        //Single period returns working directory, ".." returns parent directory
//        Path filePath = Paths.get(".", "files","SubdirectoryFile.txt");
//        printFile(filePath);
//        filePath = Paths.get("C:\\Users\\parha\\Documents\\JavaPrograms\\Section_14\\OutThere.txt");
//        printFile(filePath);
//
//        filePath = Paths.get(".");
//        //Getting absolute path instance
//        System.out.println(filePath.toAbsolutePath());
//
//        Path path2 = FileSystems.getDefault().getPath(
//                ".", "files", "..", "files", "SubdirectoryFile.txt");
//        System.out.println(path2.normalize().toAbsolutePath());
//        printFile(path2.normalize());
//
//        Path path3 = FileSystems.getDefault().getPath("thisfiledoesntexist.txt");
//        //Will print out name, it is abstract and won't check if it actually exists
//        System.out.println(path3.toAbsolutePath());
//
//        Path path4 = Paths.get("C:\\Test\\ING", "abcdef", "whatever.txt");
//        System.out.println(path4.toAbsolutePath());
//
//        filePath = FileSystems.getDefault().getPath("files");
//        System.out.println("Exists = " + Files.exists(filePath));
//
//        //This will show that path4 does not exist
//        System.out.println("Exists = " + Files.exists(path4));
//    }
//
//    private static void printFile(Path path){
//        try (BufferedReader fileReader = Files.newBufferedReader(path)){
//            String line;
//            while ((line = fileReader.readLine()) != null){
//                System.out.println(line);
//            }
//        } catch (IOException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }
//    }
}
