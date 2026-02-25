import app.Reader;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ReaderTest {


    @Test
    public void testReadFileFromTestResource() {
    List<String> result = Reader.readFile("datos.txt");
    assertEquals(15, result.size());
}

    @TempDir
    Path tempDir;

    @Test
    void verifyReadSingleLine() throws IOException {
        File file = tempDir.resolve("test.txt").toFile();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("23+\n");
        }

        List<String> lines = Reader.readFile(file.getAbsolutePath());

        assertEquals(1, lines.size(), "Should read one line");
        assertEquals("23+", lines.get(0), "Line content should match");
    }

    @Test
    void verifyReadMultipleLines() throws IOException {
        File file = tempDir.resolve("test.txt").toFile();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("23+\n");
            writer.write("84-\n");
            writer.write("56*\n");
        }

        List<String> lines = Reader.readFile(file.getAbsolutePath());

        assertEquals(3, lines.size(), "Should read three lines");
        assertEquals("23+", lines.get(0));
        assertEquals("84-", lines.get(1));
        assertEquals("56*", lines.get(2));
    }

    @Test
    void verifyEmptyLinesAreIgnored() throws IOException {
        File file = tempDir.resolve("test.txt").toFile();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("\n");
            writer.write("23+\n");
            writer.write("\n");
            writer.write("84-\n");
        }

        List<String> lines = Reader.readFile(file.getAbsolutePath());

        assertEquals(2, lines.size(), "Empty lines should be ignored");
        assertEquals("23+", lines.get(0));
        assertEquals("84-", lines.get(1));
    }

    @Test
    void verifyTrimIsApplied() throws IOException {
        File file = tempDir.resolve("test.txt").toFile();

        try (FileWriter writer = new FileWriter(file)) {
            writer.write("   23+   \n");
        }

        List<String> lines = Reader.readFile(file.getAbsolutePath());

        assertEquals(1, lines.size());
        assertEquals("23+", lines.get(0), "Line should be trimmed");
    }

    @Test
    void verifyFileNotFoundReturnsEmptyList() {
        List<String> lines = Reader.readFile("non_existing_file.txt");

        assertNotNull(lines, "Returned list should not be null");
        assertTrue(lines.isEmpty(), "List should be empty when file does not exist");
    }

    
    

}
