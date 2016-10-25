package TestFile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.security.Timestamp;


/**
 * Created by IEUser on 10/23/2016.
 */
public class TestFile01 {

    public static String testDirectory = "C:\\TEST\\";
    public static String testFileName = testDirectory + "test.txt";
    public static String testText = "test test test";
    public static Writer writer;
    public static File testFile;
    public static File directory;

    public TestFile01() {
        directory = new File(testDirectory);
        testFile = new File(testFileName);
    }

    @BeforeClass
    public static void createFolder() {
        if (!directory.exists()) directory.mkdir();
    }

    @AfterClass
    public static void deleteFolder() {
        if (directory.exists() && directory.isDirectory())  {
            delete(directory);
            System.out.println("AfterClass");
        }
    }

    @Test
    public static void testCreateFile() throws IOException {

        if (!testFile.exists()) testFile.createNewFile();
    }

    @Test
    public static void testWriteFile() throws IOException {
        if (testFile.exists() && testFile.canWrite()) {
            writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(testFile), "utf-8"));
            writer.write(testText);
            writer.close();
        }
    }

    public static void delete(File file) {
        if (file.isDirectory()) {
            if (file.list().length == 0) {
                file.delete();
            } else {
                // files inside
                String[] files = file.list();
                for (String f : files) {
                    delete(new File(file, f));
                }
            }
        } else {
            // is file
            file.delete();
        }
        if (file.isDirectory()) {
            if (file.list().length == 0) {
                file.delete();
            }
        }

    }

}
