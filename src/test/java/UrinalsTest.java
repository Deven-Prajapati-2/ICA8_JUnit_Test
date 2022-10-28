import org.junit.jupiter.api.Test;

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
}