package com.div;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TextProcessorTest {

    @Test
    public void checkNoArgs(){
        Assertions.assertThrows(RuntimeException.class,()-> TextProcessor.main(null));
    }
    @Test
    public void checkTwoArgs(){
        String[] args = {"abc","def"};
        Assertions.assertThrows(RuntimeException.class,()-> TextProcessor.main(args));
    }

    @Test
    public void removeDuplicateFromFile(){
        String[] args = {"remove","D:\\Personal\\IntelliJ-Workspace\\text-processor\\test.txt"};
        Assertions.asse
    }




}