import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;
import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    //Setup
    static FileHandler fh;

    @BeforeAll
    public static void setupFileHandler(){
        fh = new FileHandler();
    }


    //For listing files
    @Test
    public void listFilesHasFiles() {
        File[] files = fh.listFiles();
        assertNotNull(files, "listFiles should not return null");
        assertTrue(files.length > 0, "There should be at least one file in the folder");
    }

    //For If Folder Is Empty
    @Test
    public void listFilesEmptyFolder() {
        File emptyFolder = new File("empty_test_folder");
        emptyFolder.mkdir(); // create folder

        FileHandler tempFH = new FileHandler() {
            @Override
            public File[] listFiles() {
                File[] files = emptyFolder.listFiles();
                return files == null ? new File[0] : files;
            }
        };

        File[] files = tempFH.listFiles();
        assertNotNull(files, "listFiles should not return null for empty folder");
        assertEquals(0, files.length, "listFiles should return empty array for empty folder");

        emptyFolder.delete();
    }

    //Correct File Test
    @Test
    public void correctFileTest(){
        String out = fh.getData("File_Example.txt");
        assertEquals("Do not delete this file. It is required for a test.",out);
    }

    @Test
    public void correctFileContents(){
        String out = fh.getData("File_Example.txt");
        assertNotEquals("Do delete this file. It it incorrect and sad.",out);
    }

    //Incorrect File Test
    @Test
    public void incorrectFileTest() {
        String out = fh.getData("Wrong_File_Example.txt");
        assertEquals("File Not Found!", out);
    }
    //Capital Sensitive Test
    @Test
    public void capitalSensitiveTest(){
        assertEquals( fh.getData("File_Example.txt"), fh.getData("file_example.txt"));
        }

    }
