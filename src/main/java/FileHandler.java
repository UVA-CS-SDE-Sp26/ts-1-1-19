import java.io.*;
import java.util.*;

public class FileHandler extends Throwable{

    //Find "Data" Directory and Create Array of listed items.
    File dataDir = new File("data");
    File[] listData = dataDir.listFiles();

    //Getting The Data, Linear Performance
    public String getData(String contentFile){
        //STUB: read file and convert to string
        if (listData == null) {
            return "";
        }
        for (File curFile : listData) {
            if (curFile.getName().equals(contentFile)) {
                try {
                    Scanner sc = new Scanner(curFile);
                    StringBuilder sb = new StringBuilder();
                    while (sc.hasNextLine()) {
                        sb.append(sc.nextLine()).append("\n");
                    }
                    sc.close();
                    return sb.toString();
                } catch (FileNotFoundException e) {
                    return "";
                }
            }
        }
        return "";
    }
}
