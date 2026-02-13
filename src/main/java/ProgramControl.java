import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class ProgramControl {

    private FileHandler fileHandler;

    public ProgramControl(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    public File[] getSortedFiles() {
        File folder = new File("data");
        File[] files = folder.listFiles();

        if (files == null) {
            return new File[0];
        }

        Arrays.sort(files, Comparator.comparing(File::getName));
        return files;
    }

    public String getFileContent(String filename) {
        return fileHandler.getData(filename);
    }

    public String decipherContent(String content, String keyPath) throws Exception {
        Ciphers cipher = new Ciphers();
        cipher.loadCipher(keyPath);
        return cipher.decipher(content);
    }
}
