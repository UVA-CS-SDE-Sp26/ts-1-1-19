/**
 * Commmand Line Utility
 * part a --> command line interface
 * checking the number of arguments the user uses
 */
import java.util.*;
import java.io.*;
public class TopSecret {
    public static String folderPath; // this should be the data folder


    public static void main(String[] args) { // maybe this should be in a "solve" method b/c we are running tests in a separate file?
        //File folder = new File("data"); // just replace this with whatever the actual folder is (especially file and whatnot)

        // Team member A

        // Team member B

        // Team member C
        ProgramControl pc = new ProgramControl();
        try { // needed b/c we throw exception in the creation of the object
            pc.loadProgram(folderPath, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // Team member D
        // Already integrated into Team C code
    }


}


