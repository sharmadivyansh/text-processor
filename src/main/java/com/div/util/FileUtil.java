package com.div.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileUtil {

    public static Stream<String> sortFile(String filename, char flag) {

        Path path = Paths.get(filename);
        if(Files.notExists(path))
            throw new RuntimeException("File does not exist.");
        List<String> linesFromFile = new ArrayList<>();
        try {
            linesFromFile = Files.readAllLines(path);
        }
        catch(IOException exception){
            Logger.log(exception.getMessage());
        }

        Comparator<String> comparator = String::compareTo;
        if(flag == 'd')
            comparator = (s1,s2) -> s1.compareTo(s2) * -1;

        return linesFromFile.stream()
                .sorted(comparator);
    }

    public static void printSorted(String filename,char flag){
        sortFile(filename,flag)
                .forEach(System.out::println);
    }

    public static void removeDuplicate(String filename, char flag) {
        Path path = Paths.get(filename);
        if(Files.notExists(path))
            throw new RuntimeException("File does not exist.");

        List<String> linesFromFile = new ArrayList<>();
        try {
            linesFromFile = Files.readAllLines(path);
            Set<String> lineSet = new TreeSet<>(linesFromFile);
            List<byte[]> byteList = new ArrayList<>();
            lineSet.stream()
                            .map(line-> byteList.add(line.concat("\n").getBytes()))
                                    .forEach(System.out::println);
            Files.write(path, "".getBytes());
            for(byte[] b: byteList)
                Files.write(path,b, StandardOpenOption.APPEND);
        }
        catch(IOException e){
            Logger.log(e.getMessage());
        }
    }

    public static void searchWord(String filename, String word) {
        List<String>linesFromFile = readLines(filename);

        IntStream.range(0,linesFromFile.size())
                .filter(i-> linesFromFile.get(i).contains(word))
                .boxed()
                .forEach(System.out::println);
    }

    public static List<String> readLines(String filename){
        Path path = Paths.get(filename);
        if(Files.notExists(path))
            throw new RuntimeException("File does not exist.");
        List<String> linesFromFile = new ArrayList<>();
        try {
            linesFromFile = Files.readAllLines(path);
        }
        catch(IOException e){
            Logger.log(e.getMessage());
        }
         return linesFromFile;
    }

}


