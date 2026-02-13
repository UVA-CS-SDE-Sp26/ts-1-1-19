import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandLineTest {

    private FakeFileHandler fakeHandler;
    private CommandLine cli;

    @BeforeEach
    public void setUp() {
        fakeHandler = new FakeFileHandler();
        cli = new CommandLine(fakeHandler); // inject fake
    }

    // Test 1: No args should NOT read file
    @Test
    public void testNoArgsListsFiles(){
        cli.run(new String[]{});
        assertFalse(fakeHandler.readCalled);
    }

    // Test 2: Valid file number reads file
    @Test
    public void testSingleArgReadsFile(){
        cli.run(new String[]{"01"});
        assertTrue(fakeHandler.readCalled);
        assertEquals("File_Example.txt", fakeHandler.lastFilename);
    }

    // Test 3: Invalid arg should not read file
    @Test
    public void testInvalidArgDoesNothing(){
        cli.run(new String[]{"ABC"});
        assertFalse(fakeHandler.readCalled);
    }

    // Test 4: Two args still reads file
    @Test
    public void testTwoArgsAcceptsKey(){
        cli.run(new String[]{"01", "key.txt"});
        assertTrue(fakeHandler.readCalled);
    }

    private static class FakeFileHandler extends FileHandler{

        boolean readCalled = false;
        String lastFilename = null;

        @Override
        public String getData(String filename){
            readCalled = true;
            lastFilename = filename;
            return "TEST DATA";
        }
    }
}
