package tests;
import app.Reader;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


import java.util.List;

public class ReaderTest {


    @Test
    public void testReadFileFromTestResource() {

    List<String> result = Reader.readFile("test-data/reader_test.txt");

    assertEquals(3, result.size());
    assertEquals("23+", result.get(0));
}

    
    

}
