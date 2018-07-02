package com.kodilla.exception.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.lang.*;


public class FileReaderWithoutHandling {


    public void readFile() throws IOException {

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("file/names.txt").getFile());
        System.out.println(file.getPath());
        Stream<String> fileLines = Files.lines(Paths.get(file.getPath()));
        fileLines.forEach(System.out::println);

    }
}

