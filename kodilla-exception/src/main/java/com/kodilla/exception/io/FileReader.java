package com.kodilla.exception.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public void readFile() throws FileReaderException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        System.out.println(file.getPath());
        //Path path = Paths.get(file.getPath());
        // Path path = Paths.get("file/name.txt");
        try (Stream<String> fileLines = Files.lines(Paths.get("C:\\Users\\Comp\\IdeaProjects\\kodilla-course\\kodilla-exception\\out\\production\\resources\\file\\names.txt"))) {

            //  try(Stream<String> fileLines = Files.lines(Paths.get(file.getPath())))  {
            fileLines.forEach(System.out::println);
        } catch (IOException e) {
            throw new FileReaderException();
        } finally {
            System.out.println("Finlly sholud be always!");
        }
    }

}

