import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    @Test
    void goodString() {
        Urinals urinals = new Urinals();
        System.out.println("====== Deven Prajapati == TEST TWO EXECUTED =======");
        assertTrue(urinals.goodString("1010101"));
    }
}