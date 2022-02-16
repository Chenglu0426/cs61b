import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    } //Uncomment this class once you've created your Palindrome class. */
    @Test
    public void testisPalindrome() {
        assertTrue(palindrome.isPalindrome("ababa"));
        assertTrue(palindrome.isPalindrome(""));
        assertFalse(palindrome.isPalindrome("baaa"));
    }
    @Test
    public void testIsoffbyonepalindrome() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("fe", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertFalse(palindrome.isPalindrome("aabaa", cc));
    }
    @Test
    public void testoffby5() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(palindrome.isPalindrome("", cc));
        assertTrue(palindrome.isPalindrome("a", cc));
        assertTrue(palindrome.isPalindrome("bing", cc));
        assertFalse(palindrome.isPalindrome("noon", cc));
    }
}
