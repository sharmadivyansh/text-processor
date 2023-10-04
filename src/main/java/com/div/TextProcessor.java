package com.div;

import com.div.data.Command;
import com.div.util.ArgUtil;
import com.div.util.FileUtil;
import com.div.util.Logger;

import java.util.Map;

public class TextProcessor {
    public static void main(String[] args) {

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
