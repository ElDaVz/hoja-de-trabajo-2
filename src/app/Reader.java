package app;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Reader {

    public static String readFile(String path) {
        try (Scanner sc = new Scanner(new File(path))) {

            return sc.nextLine();

        } catch (FileNotFoundException e) {

        }
        return null;
    }
}
