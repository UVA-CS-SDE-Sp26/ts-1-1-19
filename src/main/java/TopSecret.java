/**
 * Commmand Line Utility
 * part a --> command line interface
 * checking the number of arguments the user uses
 */
import java.util.*;
import java.io.*;
public class TopSecret {
    public static File folder;
    //public static ProgramControl pc;
    public TopSecret(String s) {
        folder = new File("./" + s); // this is supposed to read in a FOLDER
    }


    public static void main(String[] args) throws Exception { // maybe this should be in a "solve" method b/c we are running tests in a separate file?
        //File folder = new File("data"); // just replace this with whatever the actual folder is (especially file and whatnot)

        // Team member A
        CommandLine cli = new CommandLine();
        cli.run(args);
        // Team member B

        // Team member C
        //pc.loadProgram("ts-1-1-19\\data", args); // different args?
        // Team member D
    }


}


