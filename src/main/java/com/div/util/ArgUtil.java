package com.div.util;

import com.div.data.Command;
import com.div.exceptions.InvalidFileFormat;
import com.div.exceptions.InvalidFlag;

import java.util.HashMap;
import java.util.Map;

public class ArgUtil {
    public static Map<String,?> parseArgs(String[] args) throws InvalidFlag, InvalidFileFormat {

        if(args==null || args.length<2){
            Logger.log("Insufficient Arguments");
            throw new RuntimeException("Insufficient Arguments");
        }
//        if(args[0].equals("-h") || args[0].equals("--help")){
//            System.out.println(showUsage());
//            System.exit(0);
//        }

        Command command= Command.valueOf(args[0].toUpperCase());
//        getArgData(command,args);
        char flag = 'a';
        String filename = args[1];
        if(args.length == 2){
           filename = getFileName(args);
        }
        if(args.length==3 && !(command.equals(Command.SEARCH))){
            if(args[2].startsWith("-")){
                flag = args[2].charAt(1)=='d'?'d':'a';
            }
            else{
                Logger.log("Incorrect flag");
                throw new InvalidFlag();
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

    private static String getFileName(String[] args) throws InvalidFileFormat {
        if(args[1].endsWith(".txt") || args[1].endsWith(".csv")){
            return args[1];
        }
        else{
            throw new InvalidFileFormat("File Type not supported");
        }
    }

    public static String showUsage(){
        return "Usage:" +
                "\ntextprocessor sort filename [options]" +
                "\n-a: sort file ascendingly" +
                "\n-d: sort file descendingly" +
                "\ntextprocessor remove filename" +
                "\ntextprocessor search filename word" +
                "\ntextprocessor replace filename existing-text new-text" +
                "\ntextprocessor merge filename1 filename2 filename" ;
    }

}
