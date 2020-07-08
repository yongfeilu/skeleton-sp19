import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;

public class TestArrayDequeGold {

    @Test
    public void testStudentArrayDeque() {
        StudentArrayDeque<Integer> test1 = new StudentArrayDeque<Integer>();
        ArrayDequeSolution<Integer> test2 = new ArrayDequeSolution<Integer>();
        Integer studentOutput;
        Integer correctOutput;

        while (true) {
            double numberBeteewnZeroAndOne = StdRandom.uniform();
            int number = StdRandom.uniform(10);
            if (numberBeteewnZeroAndOne >= 0.75) {
                test1.addFirst(number);
                test2.addFirst(number);
                System.out.printf("addFirst(%d) \n", number);
            } else if (numberBeteewnZeroAndOne >= 0.5) {
                test1.addLast(number);
                test2.addLast(number);
                System.out.printf("addLast(%d) \n", number);
            } else if ((numberBeteewnZeroAndOne >= 0.25) && !test1.isEmpty()
                        && !test2.isEmpty()) {
                studentOutput = test1.removeFirst();
                correctOutput = test2.removeFirst();
                System.out.printf("removeFirst()\n");
                assertEquals("removeFirst() is wrong.", correctOutput, studentOutput);
            } else if (numberBeteewnZeroAndOne >= 0 && !test1.isEmpty()
                       && !test2.isEmpty()) {
                studentOutput = test1.removeLast();
                correctOutput = test2.removeLast();
                System.out.printf("removeLast()\n");
                assertEquals("removeLast() is wrong.", correctOutput, studentOutput);
            } else  {
                assertEquals(test2.isEmpty(), test1.isEmpty());
            }
        }
    }
}
