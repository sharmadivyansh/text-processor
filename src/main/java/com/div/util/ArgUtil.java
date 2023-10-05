package com.div.util;

import com.div.data.Command;

import java.util.HashMap;
import java.util.Map;

public class ArgUtil {

    public static Map<String,?> parseArgs(String[] args) {

        if(args.length<2) {
            Logger.log("Insufficient Arguments");
            throw new RuntimeException();
        }

        char flag = 'a';
        String filename = args[1];
        Command command = Command.valueOf(args[0].toUpperCase());;
        if(args.length == 2){
           filename = getFileName(args);
        }
        if(args.length==3 && !(command.equals(Command.SEARCH))){
            if(args[2].startsWith("-")){
                flag = args[2].charAt(1)=='d'?'d':'a';
            }
            else{
                Logger.log("Incorrect flag");
                throw new RuntimeException();
            }
            filename = getFileName(args);
        }

        if(command.equals(Command.REPLACE)){
            if(args.length != 4)
                throw new RuntimeException("Insufficient Arguments");
            else{
                filename = getFileName(args);
            }
        }


        Map<String,Object> argsMap = new HashMap<>();
        argsMap.put("command",command);
        argsMap.put("flag",flag);
        argsMap.put("filename",filename);
        return argsMap;
    }

    private static String getFileName(String[] args){
        if(args[1].endsWith(".txt") || args[1].endsWith(".csv")){
            return args[1];
        }
        else{
            throw new RuntimeException("File Type not supported");
        }
    }

}
