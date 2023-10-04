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
            if(args[1].endsWith(".txt") || args[1].endsWith(".csv")){
                filename = args[1];
            }
            else{
                throw new RuntimeException("File Type not supported");
            }
        }
        if(args.length==3 && !(command.equals(Command.SEARCH))){
            if(args[2].startsWith("-")){
                flag = args[2].charAt(1)=='d'?'d':'a';
            }
            else{
                Logger.log("Incorrect flag");
                throw new RuntimeException();
            }
            if(args[1].endsWith(".txt") || args[1].endsWith(".csv")){
                filename = args[1];
            }
            else{
                throw new RuntimeException("Filetype not supported");
            }

        }

        Map<String,Object> argsMap = new HashMap<>();
        argsMap.put("command",command);
        argsMap.put("flag",flag);
        argsMap.put("filename",filename);
        return argsMap;

    }
}
