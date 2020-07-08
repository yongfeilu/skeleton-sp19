import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByN {

    CharacterComparator offBy5 = new OffByN(5);
    CharacterComparator offBy3 = new OffByN(3);

    @Test
    public void testEqualChars5() {
        assertTrue(offBy5.equalChars('a', 'f'));
        assertTrue(offBy5.equalChars('b', 'g'));
        assertFalse(offBy5.equalChars('h', 'f'));
        assertFalse(offBy5.equalChars('d', 'r'));
    }

    @Test
    public void testEqualsChars3() {
        assertFalse(offBy3.equalChars('a', 'e'));
        assertFalse(offBy3.equalChars('c', 'e'));
        assertTrue(offBy3.equalChars('a', 'd'));
        assertTrue(offBy3.equalChars('r', 'u'));
    }

}
