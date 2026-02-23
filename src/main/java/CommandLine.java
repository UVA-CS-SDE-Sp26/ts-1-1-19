import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;

public class CommandLine {

    private FileHandler fileHandler;
    private ProgramControl process;

    // private File folder;
    // private File[] listOfFiles;
    public CommandLine() {
        this.fileHandler = new FileHandler();
        this.process = new ProgramControl();
    }

    // Constructor for testing
    public CommandLine(FileHandler fileHandler, ProgramControl process) {
        this.fileHandler = fileHandler;
        this.process = process;

    }

    public void run(String[] args) throws Exception {
        this.process.loadProgram("data", args);
        // String filename = files[index].getName();

        // THIS is what your tests care about
        // String content = fileHandler.getData(filename);
        //
        // // If two args, accept key but do nothing special in this class
        // if (args.length == 2) {
        // String key = args[1];
        // // Key handling would be done elsewhere (ProgramControl / Cipher)
        // }
        //
        // System.out.println(content);
    }

    private boolean isTwoDigitNumber(String s) {
        return s != null &&
                s.matches("\\d{2}") &&
                !s.equals("00");
    }

    private void printUsage() {
        System.out.println("Usage:");
        System.out.println("java topsecret");
        System.out.println("java topsecret 01");
        System.out.println("java topsecret 01 key.txt");
    }
}
