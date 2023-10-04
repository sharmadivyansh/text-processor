package org.io;

import org.io.data.Command;
import org.io.util.ArgUtil;
import org.io.util.Logger;
import org.io.util.FileUtil;

import java.util.Map;

public class TextProcessor {
    public static void main(String[] args) {

//        sort -a/d filename
        Map<String,?> argMap = ArgUtil.parseArgs(args);
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
                break;
            case MERGE:
                break;
            default:
                Logger.log("Incorrect command");
        }


    }
}
