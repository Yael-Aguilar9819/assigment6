package assigment6;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
class AppTest {
    /**
     * Rigorous Test.
     */
    @BeforeEach
    void  firstTest() {
        System.out.print("ah");
    }


    @Test
    void testApp() {
        assertEquals(1, 1);
    }

}
