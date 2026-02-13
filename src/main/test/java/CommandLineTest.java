import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandLineTest {

    private FakeFileHandler fakeHandler;
    private CommandLine cli;

    @BeforeEach
    void setUp() {
        fakeHandler = new FakeFileHandler();
        cli = new CommandLine(fakeHandler);
    }

    @Test
    void testNoArgsListsFiles(){
        cli.run(new String[]{});
        assertTrue(fakeHandler.listCalled);
    }

    @Test
    void testSingleArgReadsFile(){
        cli.run(new String[]{"01"});
        assertTrue(fakeHandler.readCalled);
        assertEquals("filea.txt", fakeHandler.lastFilename);
    }

    @Test
    void testInvalidArgDoesNothing(){
        cli.run(new String[]{"ABC"});
        assertFalse(fakeHandler.readCalled);
    }

    @Test
    void testTwoArgsAcceptsKey(){
        cli.run(new String[]{"01", "key.txt"});
        assertTrue(fakeHandler.readCalled);
    }

    private static class FakeFileHandler extends FileHandler{
        boolean listCalled = false;
        boolean readCalled = false;
        String lastFilename = null;

        @Override
        public String getData(String filename){
            readCalled=true;
            lastFilename = filename;
            return "TEST DATA";
        }
    }
}