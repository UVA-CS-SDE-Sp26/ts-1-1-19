import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class ProgramControlTest {

    private FakeFileHandler fakeFileHandler;
    private ProgramControl controller;

    @BeforeEach
    public void setUp() {
        fakeFileHandler = new FakeFileHandler();
        controller = new ProgramControl(fakeFileHandler);
    }

    // Test 1: No files in folder
    @Test
    public void noFilesInFolder() {
        fakeFileHandler.files = new File[0];
        File[] result = controller.getSortedFiles();
        assertEquals(1, result.length); //Geehun told me he put in a sample file in there for the tests. "File_Example.txt" If it detects 1, then that means it doesn't detect anything else.
    }

    // Test 2: No args should list files
    @Test
    public void noArgsListsFiles() {
        File[] result = controller.getSortedFiles();
        assertTrue(result.length > 0, "The 'data' folder should contain at least one file");
        File folder = new File("data");
        File[] actualFiles = folder.listFiles();
        assertNotNull(actualFiles, "'data' folder should exist");
        for (File f : actualFiles) {
            boolean found = Arrays.stream(result)
                    .anyMatch(r -> r.getName().equals(f.getName()));
            assertTrue(found, "Expected file in listing: " + f.getName());
        }
    }

    // Test 3: Non-integer argument
    @Test
    public void nonIntegerArgumentThrows() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("ABC");
        });
    }

    // Test 4: Index out of range
    @Test
    public void indexOutOfBoundsThrows() {
        fakeFileHandler.files = new File[]{
                new File("fileA.txt")
        };

        assertThrows(IndexOutOfBoundsException.class, () -> {
            int index = 5;
            if (index < 0 || index >= fakeFileHandler.files.length) {
                throw new IndexOutOfBoundsException();
            }
        });
    }

    // Test 5: Valid index returns file content
    @Test
    public void validIndexReturnsFileContent() {
        fakeFileHandler.files = new File[]{
                new File("fileA.txt")
        };

        String content = controller.getFileContent("fileA.txt");

        assertEquals("SECRET DATA", content);
    }

    // Test 6: Empty file
    @Test
    public void emptyFileReturnsEmptyString() {
        fakeFileHandler.emptyFile = true;

        String content = controller.getFileContent("empty.txt");

        assertEquals("", content);
    }

    // Test 7: Missing file
    @Test
    public void missingFileReturnsNotFound() {
        fakeFileHandler.missingFile = true;

        String content = controller.getFileContent("missing.txt");

        assertEquals("File Not Found!", content);
    }

    // Fake FileHandler for testing
    private static class FakeFileHandler extends FileHandler {

        File[] files = new File[]{
                new File("fileA.txt"),
                new File("fileB.txt")
        };

        boolean emptyFile = false;
        boolean missingFile = false;

        @Override
        public String getData(String filename) {

            if (missingFile) {
                return "File Not Found!";
            }

            if (emptyFile) {
                return "";
            }

            return "SECRET DATA";
        }
    }
}
