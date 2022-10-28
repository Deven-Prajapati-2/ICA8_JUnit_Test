import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {
    @Test
    void readFile() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST ONE EXECUTED =======");
        ArrayList<String> expectedUrinalsStrings = new ArrayList<>();
        expectedUrinalsStrings.add("10001");
        expectedUrinalsStrings.add("1001");
        expectedUrinalsStrings.add("00000");
        expectedUrinalsStrings.add("0000");
        expectedUrinalsStrings.add("01000");
        expectedUrinalsStrings.add("011");
        assertEquals(expectedUrinalsStrings,urinals.readFile());
    }
    @Test
    void goodString() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST TWO EXECUTED =======");
        assertTrue(urinals.goodString("1010101"));
    }
    @Test
    void countMaximumFreeUrinals() {
        Urinals urinals = new Urinals();
        String str = "00000";
        int actualCount = urinals.countMaximumFreeUrinals(str);
        int expectedCount = 3;
        System.out.println("====== Deven Prajapati == TEST THREE EXECUTED =======");
        assertEquals(expectedCount, actualCount);
    }

    @Test
    void createOutputFile() {
        Urinals urinals = new Urinals();
        ArrayList<String> expectedOutputFile = new ArrayList<>();
        expectedOutputFile.add("1");
        expectedOutputFile.add("2");
        expectedOutputFile.add("3");
        int[] testArray = {1,2,3};
        String path = urinals.createOutputFile(testArray);
        ArrayList<String> actualOutputFile = new ArrayList<>();
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null) {
                if(line.equals("-1") || line.equals("EOF")) break;
                actualOutputFile.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("====== Deven Prajapati == TEST FOUR EXECUTED =======");
        assertEquals(expectedOutputFile, actualOutputFile);
    }
}