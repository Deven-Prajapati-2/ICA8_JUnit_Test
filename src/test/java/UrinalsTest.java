import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
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
        String path = "data\\urinal.dat";
        try {
            assertEquals(expectedUrinalsStrings,urinals.readFile(path));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
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
        ArrayList<Integer> expectedOutputFile = new ArrayList<>();
        expectedOutputFile.add(1);
        expectedOutputFile.add(2);
        expectedOutputFile.add(3);
        int[] testArray = {1,2,3};
        String path = urinals.createOutputFile(testArray);
        ArrayList<Integer> actualOutputFile = new ArrayList<>();
        try {
            BufferedReader reader;
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            while(line != null) {
                if(line.equals("-1") || line.equals("EOF")) break;
                actualOutputFile.add(Integer.parseInt(line));
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("====== Deven Prajapati == TEST FOUR EXECUTED =======");
        assertEquals(expectedOutputFile, actualOutputFile);
    }

    @Test
    void checkStringLength() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST FIVE EXECUTED =======");
        assertFalse(urinals.goodString("101010101010010100101010010010100101"));
    }

    @Test
    void checkEmptyStringLength() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST SIX EXECUTED =======");
        assertFalse(urinals.goodString(""));
    }

    @Test
    void checkStringIsBinary() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST SEVEN EXECUTED =======");
        assertFalse(urinals.goodString("1010101210"));
    }

    @Test
    void readWrongFile() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST EIGHT EXECUTED =======");
        String path = "data1\\urinal.dat";
        try {
            Throwable exception = assertThrows(FileNotFoundException.class, () -> urinals.readFile(path));
            assertEquals("data1\\urinal.dat (The system cannot find the path specified)", exception.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void readEmptyFile() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST NINE EXECUTED =======");
        String path = "data\\emptyFile.dat";
        ArrayList<String> expectedUrinalsStrings = new ArrayList<>();
        try {
            assertEquals(expectedUrinalsStrings,urinals.readFile(path));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}