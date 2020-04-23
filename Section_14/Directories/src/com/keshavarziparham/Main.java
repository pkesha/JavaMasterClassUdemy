package com.keshavarziparham;

import javax.print.attribute.standard.PrinterName;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;

public class Main {

    public static void main(String[] args) {

        //Creates a filter.
//        DirectoryStream.Filter<Path> filter = new DirectoryStream.Filter<Path>(){
//            public boolean accept(Path path) throws IOException {
//                return (Files.isRegularFile(path));
//            }
//        };

        //Lambda Expression equivalent to the top
        DirectoryStream.Filter<Path> filter = p -> Files.isRegularFile(p);

        //Hardcoded file separator "FileTree\\Dir2"
        //Path directory = FileSystems.getDefault().getPath("FileTree\\Dir2");

        Path directory = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try(DirectoryStream<Path> contents = Files.newDirectoryStream(directory, filter)){
            //Going through directories and files for .dat files within Dir2
            for (Path file : contents){
                System.out.println(file.getFileName());
            }
        } catch (IOException | DirectoryIteratorException e){

            System.out.println(e.getMessage());
        }

        //Since separators in a directory name is different on OS,
        //need to retrieve it to build directories
        String separator = File.separator;
        System.out.println(separator);
        separator = FileSystems.getDefault().getSeparator();
        System.out.println(separator);

        try{
            //File name 1st arguement, file extension in the second arguement
            Path tempFile = Files.createTempFile("myapp", ".apptext");
            System.out.println("Temporary file path = " + tempFile.toAbsolutePath());

        } catch(IOException e){
            System.out.println(e.getMessage());
        }

        Iterable<FileStore> stores = FileSystems.getDefault().getFileStores();
        for(FileStore store : stores){
            System.out.println("Volume name/Drive letter = " + store);
            //This shows empty - does not work
            System.out.println("file store = " + store.name());

            Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
            for(Path path : rootPaths){
                System.out.println(path);
            }
        }

        System.out.println("**********************");
        Iterable<Path> rootPaths = FileSystems.getDefault().getRootDirectories();
        for(Path path : rootPaths){
            System.out.println(path);
        }

        System.out.println("----Walking tree for Dir2----");
        Path dir2Path = FileSystems.getDefault().getPath("FileTree" + File.separator + "Dir2");
        try{
            Files.walkFileTree(dir2Path, new PathNames());
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
