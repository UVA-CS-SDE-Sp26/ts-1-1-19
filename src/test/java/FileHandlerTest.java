import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileHandlerTest {

    //Setup
    static FileHandler fh;

    @BeforeAll
    public static void setupFileHandler(){
        fh = new FileHandler();
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
