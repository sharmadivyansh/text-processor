package org.io.util;

import org.io.data.Command;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ArgUtil {
    /*
    * Change arg parsing according to README
    * */
    public static Map<String,?> parseArgs(String[] args) {
        char flag = 'd';
        String filename = args[1];
        Command command = Command.valueOf(args[0].toUpperCase());;
        if(args.length<2) {
            Logger.log("Insufficient Arguments");
            throw new RuntimeException();
        }
        if(args.length == 2){
            if(args[1].endsWith(".txt") || args[1].endsWith(".csv")){
                filename = args[1];
            }
            else{
                throw new RuntimeException("Filename not supported");
            }
//            command = Command.valueOf(args[0].toUpperCase());
        }
        if(args.length==3 && !(command.equals(Command.SEARCH))){
            if(args[1].startsWith("-")){
                flag = args[1].charAt(1)=='d'?'d':'a';
            }
            else{
                Logger.log("Incorrect flag");
                throw new RuntimeException();
            }
            if(args[2].endsWith(".txt") || args[2].endsWith(".csv")){
                filename = args[2];
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
