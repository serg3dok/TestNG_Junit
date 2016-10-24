package TestFile;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;


/**
 * Created by IEUser on 10/23/2016.
 */
public class testFile01 {

    public static String testDirectory = "C:\\TEST\\";
    public static File directory = new File(testDirectory);
    public static String testFileName = "test.txt";
    public static File testFile = new File(testDirectory + testFileName);
    public static Writer writer;
    public static String testText = "test test test";

    @BeforeClass
    public static void createFolder() {
        if (!directory.exists()) directory.mkdir();
    }

    @AfterClass
    public static void deleteFolder() {

        if (directory.exists()) directory.delete();
        if (directory.exists()) System.out.println("AfterClass");
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

}
