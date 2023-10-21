package com.div.util;

import com.div.data.Command;

public class CommandUtil {

    public static String showCommandHelp(Command command){

        switch (command){
            case SORT:
                return "textprocessor sort {filename} {options} \n" +
                        "options: \n" +
                        "-a: ascending" +
                        "-d: descending";
            case MERGE:
                return "textprocessor remove {filename}";
            case REMOVE:
                return "textprocessor search {filename} {word}";
            case SEARCH:
                return "textprocessor replace {filename} {current-text} {new-text}";
            case REPLACE:
                return "textprocessor merge {file1} {file2} {mergedfile}";
            default:
                return "Invalid command";
        }

    }

}
