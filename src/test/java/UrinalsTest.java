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
        expectedOutputFile.add(0);
        expectedOutputFile.add(3);
        expectedOutputFile.add(2);
        expectedOutputFile.add(1);
        ArrayList<String> urinalStrings = new ArrayList<>();
        try {
            urinalStrings = urinals.readFile("data\\urinal.dat");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        int size = urinalStrings.size();
        int[] testArray = new int[size];
        for(int i=0;i<urinalStrings.size();i++) {
            int count;
            if(urinals.goodString(urinalStrings.get(i))) {
                count = urinals.countMaximumFreeUrinals(urinalStrings.get(i));
            } else {
                count = -1;
            }
            testArray[i] = count;
        }
        String path = "rule.txt";
        try {
            path = urinals.createOutputFile(testArray, "rule.txt");
        }
        catch (Exception e){
            e.printStackTrace();
        }
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
    @Test
    void duplicateWriteFile() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST TEN EXECUTED =======");
        ArrayList<String> urinalStrings = new ArrayList<>();
        try {
            urinalStrings = urinals.readFile("data\\urinal.dat");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        int size = urinalStrings.size();
        int[] testArray = new int[size];
        for(int i=0;i<urinalStrings.size();i++) {
            int count;
            if(urinals.goodString(urinalStrings.get(i))) {
                count = urinals.countMaximumFreeUrinals(urinalStrings.get(i));
            } else {
                count = -1;
            }
            testArray[i] = count;
        }
        String path1 = "rule.txt",path2 = "rules.txt";
        try {
            path1 = urinals.createOutputFile(testArray, "rule.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            path2 = urinals.createOutputFile(testArray, "rule.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        assertNotEquals(path1,path2);
    }
    @Test
    void badNameFileWrite() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST ELEVEN EXECUTED =======");
        ArrayList<String> urinalStrings = new ArrayList<>();
        try {
            urinalStrings = urinals.readFile("data\\urinal.dat");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        int size = urinalStrings.size();
        int[] testArray = new int[size];
        for(int i=0;i<urinalStrings.size();i++) {
            int count;
            if(urinals.goodString(urinalStrings.get(i))) {
                count = urinals.countMaximumFreeUrinals(urinalStrings.get(i));
            } else {
                count = -1;
            }
            testArray[i] = count;
        }
        String badFileName = "ru/@le.txt";
        try {
            Throwable exception = assertThrows(FileNotFoundException.class, () -> urinals.createOutputFile(testArray,badFileName));
            assertEquals("ru\\@le.txt (The system cannot find the path specified)", exception.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}