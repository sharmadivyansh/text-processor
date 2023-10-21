package com.div;

import com.div.data.Command;
import com.div.exceptions.InvalidFileFormat;
import com.div.exceptions.InvalidFlag;
import com.div.util.ArgUtil;
import com.div.util.FileUtil;
import com.div.util.Logger;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    public static void main(String[] args) {
        Map<String, ?> argMap = new HashMap<>();
        try {
            argMap = ArgUtil.parseArgs(args);
        }
        catch (IllegalArgumentException e){
            System.out.println("Invalid command");
        }
        catch(InvalidFlag e){
            System.out.println("Invalid flag");
        }
        catch(InvalidFileFormat e){
            System.out.println("Invalid file extension. Only .txt and .csv files supported");
        }
        finally{
            System.out.println(ArgUtil.showUsage());
        }

        Command command = (Command)argMap.get("command");
        char flag = (char)argMap.get("flag");
        String filename = (String)argMap.get("filename");
        switch (command){
            case SORT:
                FileUtil.printSorted(filename,flag);
                break;
            case REMOVE:
                FileUtil.removeDuplicate(filename,flag);
                break;
            case SEARCH:
                String word = args[2];
                FileUtil.searchWord(filename,word);
                break;
            case REPLACE:
                String wordToReplace = args[2];
                String replaceWith = args[3];
                FileUtil.replaceWord(filename,wordToReplace,replaceWith);
                break;
            case MERGE:
                System.out.println("Merge");
                String firstFilename = filename;
                String secondFilename = null;
                String mergeFilename = null;
                if(args[2].endsWith(".txt") || args[2].endsWith(".csv")
                && args[3].endsWith(".txt") || args[3].endsWith(".csv")){
                    secondFilename = args[2];
                    mergeFilename = args[3];
                }
                else
                    new RuntimeException("File type not supported");
                if(FileUtil.mergeFiles(firstFilename,secondFilename,mergeFilename))
                    System.out.println("File merged successfully");
                else
                    Logger.log("Error! Could not merge files");
                break;
            default:
                Logger.log("Incorrect command");
        }

    }
}
