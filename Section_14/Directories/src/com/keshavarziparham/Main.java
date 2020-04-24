package com.keshavarziparham;

import javax.print.attribute.standard.PrinterName;
import java.awt.image.FilteredImageSource;
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

        System.out.println("---Copy Dir2 to Dir4/Dir2Copy---");
        Path copyPath = FileSystems.getDefault().getPath("FileTree" + File.separator +
                "Dir4" + File.separator + "Dir2Copy");
        //  FileTree/Dir4/Dir2Copy
        try {
           Files.walkFileTree(dir2Path, new CopyFiles(dir2Path, copyPath));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }

        File file = new File("\\Examples\\file.txt");
        Path converterPath = file.toPath();
        System.out.println("convertedPath = " + converterPath);

        File parent = new File("\\Examples");
        File resolvedFile = new File(parent, "\\dir\\file.txt");
        System.out.println((resolvedFile.toPath()));

        resolvedFile = new File("\\Examples", "\\dir\\file.txt");
        System.out.println(resolvedFile.toPath());

        Path parentPath = Paths.get("\\Examples");
        Path childRelativePath = Paths.get("\\dir\\file.txt");
        System.out.println(parentPath.resolve(childRelativePath));

        //"" translates to a working directory
        File workingDirectory = new File("").getAbsoluteFile();
        System.out.println("working directory = " + workingDirectory.getAbsolutePath());

        System.out.println("----print Dir2 contents using list()----");
        File dir2File = new File(workingDirectory, "\\FileTree\\Dir2");
        String[] dir2Contents = dir2File.list();
        for(int i = 0; i < dir2Contents.length; i++){
            System.out.println("i = " + ": " + dir2Contents[i]);
        }

        System.out.println("--- print Dir2 contents using listFiles() ---");
        File[] dir2Files = dir2File.listFiles();
        for(int i = 0; i < dir2File.length(); i++){
            System.out.println("i = "+ ": " + dir2Files[i].getName());
        }
    }
}
