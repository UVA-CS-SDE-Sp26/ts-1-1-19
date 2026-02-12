import java.io.*;
import java.util.*;

public class FileHandler {

    public String getData(String contentFile) {
        File file = new File("data", contentFile);
        if (!file.exists()) {
            return "File Not Found!";
        }
        try (Scanner sc = new Scanner(file)) {
            StringBuilder sb = new StringBuilder();
            while (sc.hasNextLine()) {
                sb.append(sc.nextLine());
                if (sc.hasNextLine()) {
                    sb.append("\n");
                }
            }
            return sb.toString();
        } catch (FileNotFoundException e) {
            return "File Not Found!";
        }
    }
}
