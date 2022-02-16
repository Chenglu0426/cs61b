import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    @Test
    public void testoffbuone() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('a', 'e'));
    }

    @Test
    public void testoffbyb() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(offBy5.equalChars('a', 'f'));
        assertFalse(offBy5.equalChars('f', 'h'));
    }

    // Your tests go here.

    //Uncomment this class once you've created your CharacterComparator interface and OffByOne class.
}
