package com.keshavarziparham;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;

public class Main {

    public static void main(String[] args) {
        try {
            //Creating file - will empty
//            Path fileToCreate = FileSystems.getDefault().getPath("Examples", "file2.txt");
//            Files.createFile(fileToCreate);

            //Creating a directory in Example directory
//            Path dirToCreate = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.createDirectory(dirToCreate);

            //Path dirToCreate = FileSystems.getDefault().getPath("Examples",
                    //"Dir2\\Dir3\\Dir4\\Dir5\\Dir6");
//            Path dirToCreate = FileSystems.getDefault().getPath(
//                    "Examples\\Dir2\\Dir3\\Dir4\\Dir5\\Dir6\\Dir7");
//            Files.createDirectory(dirToCreate);

            //Getting metadata
            Path filePath = FileSystems.getDefault().getPath("Examples", "Dir1/file1.txt");
            long size = Files.size(filePath);
            System.out.println("Size = " + size);
            System.out.println("Last modified = " + Files.getLastModifiedTime(filePath));

            //Files.readAttributes will get basic attributes
            //BasicFileAttributes returns an instance that implements the basic file attributes interface

            //BasicFileAttributes needs to be passed because
            // system-specific sub-instances of basic file attributes in Java.nio package
            BasicFileAttributes attrs = Files.readAttributes(filePath, BasicFileAttributes.class);
            System.out.println("Size = " + attrs.size());
            System.out.println("Last modified = " + attrs.lastAccessTime());
            System.out.println("Created = " + attrs.creationTime());
            System.out.println("Is directory = " + attrs.isDirectory());
            //This should be true
            System.out.println("Is regular file = " + attrs.isDirectory());


            //Deleting file
//            Path fileToDelete = FileSystems.getDefault().getPath("Examples",
//                    "Dir1", "file1Copy.txt");
//            //File.delete will throw exception if it doesn't exist
//            Files.deleteIfExists(fileToDelete);


            //Moving files to parent directory, saving second copy with different name
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Files.move(fileToMove, destination);
            //Moves files
//            Path fileToMove = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path destination = FileSystems.getDefault().getPath("Examples", "Dir1", "file1Copy.txt");
//            Files.move(fileToMove, destination);

            //Will copy and create file - commented since the files already exist. Doing another tutorial
//            Path sourceFile = FileSystems.getDefault().getPath("Examples", "file1.txt");
//            Path copyFile = FileSystems.getDefault().getPath("Examples", "file1Copy.txt");
//            //When passing third argument with "StandardCopyOption.REPLACE_EXISTING", No exception thrown
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);
//
//            //Copies directory, but not the contents within it
//            sourceFile = FileSystems.getDefault().getPath("Examples","Dir1");
//            copyFile = FileSystems.getDefault().getPath("Examples", "Dir4");
//            Files.copy(sourceFile, copyFile, StandardCopyOption.REPLACE_EXISTING);

        } catch (IOException e){
            //When file exists, exception is thrown (A)
            System.out.println(e.getMessage());
            //e.printStackTrace();
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
