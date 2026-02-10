import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
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
        assertNotNull(out);
    }

    //Incorrect File Test
    @Test
    public void incorrectFileTest(){
        assertThrows(FileNotFoundException.class, () -> fh.getData("Wrong_Test_Name.txt"));
    }

    //Capital Sensitive Test
    @Test
    public void capitalSensitiveTest(){
        assertEquals(fh.getData("File_Example.txt"),fh.getData("file_example.txt"));
    }

}
