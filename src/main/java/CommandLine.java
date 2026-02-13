import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class CommandLine {

    private FileHandler fileHandler = new FileHandler();

    public void run(String[] args) {
        File folder = new File("data");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles == null || listOfFiles.length == 0) {
            System.out.println("No files found");
            return;
        }

        Arrays.sort(listOfFiles, Comparator.comparing(File::getName));

        //case 1: no args -> list files
        if (args.length == 0) {
            for (int i=0; i<listOfFiles.length; i++) {
                System.out.printf("%02d %s%n", i+1, listOfFiles[i].getName());
            }
            return;
        }

        String fileNumber = args[0];

        if (!isTwoDigitNumber(fileNumber)){
            printUsage();
            return;
        }

        int index = Integer.parseInt(fileNumber)-1;

        if (index<0 || index>=listOfFiles.length){
            System.out.println("Invalid file number");
            return;
        }

        String filename = listOfFiles[index].getName();
        String content = fileHandler.getData(fileName);

        //case 3: cipher key
        if (args.length == 2) {
            String key = args[1];
        }
        System.out.println(content);
    }
    private boolean isTwoDigitNumber(String s) {
        return s != null && s.length() == 2 && Character.isDigit(s.charAt(0)) && Character.isDigit(s.charAt(1)) && !s.equals("00");
    }

    private void printUsage() {
        System.out.println("Usage:");
        System.out.println("java topsecret");
        System.out.println("java topsecret 01");
        System.out.println("java topsecret 01 key");
    }
}
