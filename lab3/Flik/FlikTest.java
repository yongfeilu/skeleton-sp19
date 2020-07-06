import static org.junit.Assert.*;
import org.junit.Test;

public class FlikTest {
    @Test
    public void isSameNumberTest() {
        boolean actualA = Flik.isSameNumber(1, 1);
        boolean actB = Flik.isSameNumber(128, 128);
        boolean actC = Flik.isSameNumber(null, null);
        boolean actD = Flik.isSameNumber(2, null);
        boolean actF = Flik.isSameNumber(2, 5);

        assertEquals(true, actualA);
        assertEquals(true, actB);
        assertEquals(true, actC);
        assertEquals(false, actD);
        assertEquals(false, actF);


    }
}
