import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BackspaceCompareTest {

    @Test
    public void testEmpty() {
        assertTrue(Main.backspaceCompare("", ""));
    }

    @Test
    public void testNoSpecials() {
        assertFalse(Main.backspaceCompare("abc", "abcd"));
    }

    @Test
    public void testUselessBackspaces() {
        assertTrue(Main.backspaceCompare("ab##cd", "ab##cd"));
    }

    @Test
    public void testExtraBackspaces() {
        assertTrue(Main.backspaceCompare("xy#z", "xzzz##"));
    }

    @Test
    public void testSingleBackspace() {
        assertTrue(Main.backspaceCompare("a#", ""));
    }

    @Test
    public void testSingleBackspaceBoth() {
        assertTrue(Main.backspaceCompare("b#", "c#"));
    }

    @Test
    public void testConsecutiveBackspaces() {
        assertFalse(Main.backspaceCompare("abc###", "ad#"));
    }

    @Test
    public void testAllBackspaces() {
        assertTrue(Main.backspaceCompare("#####", "####"));
    }

    @Test
    public void testLeadingBackspaces() {
        assertTrue(Main.backspaceCompare("#a#", "#b#"));
    }

    @Test
    public void testTrailingCharacters() {
        assertTrue(Main.backspaceCompare("abc##d", "ab#d"));
    }

    @Test
    public void testNumbersAndSpecialChars() {
        assertTrue(Main.backspaceCompare("12#34#", "13#33#"));
    }

    @Test
    public void testNoBackspaces() {
        assertFalse(Main.backspaceCompare("abcd", "abcde"));
    }

    @Test
    public void testBackspacesStartEnd() {
        assertTrue(Main.backspaceCompare("#abc#", "abb#c#"));
    }

    @Test
    public void testNonAlphanumeric() {
        assertTrue(Main.backspaceCompare("!@#$%", "!@#$%f#"));
    }

    @Test
    public void testSpacesAndBackspaces() {
        assertFalse(Main.backspaceCompare("a b #c", "a  bc#"));
    }

    @Test
    public void testBackspacesDifferentChars() {
        assertTrue(Main.backspaceCompare("abcd#", "abce#"));
    }

    @Test
    public void testLongStrings() {
        assertTrue(Main.backspaceCompare("a" + "b".repeat(1000) + "#".repeat(1000), "a"));
    }

    @Test
    public void testMixedCase() {
        assertFalse(Main.backspaceCompare("Ab#c", "ab#c"));
    }

    @Test
    public void testBackspaceNotAffecting() {
        assertFalse(Main.backspaceCompare("abc#d", "ab#cd"));
    }

    @Test
    public void testEmptyAndBackspacesOnly() {
        assertTrue(Main.backspaceCompare("", "###"));
    }

    @Test
    public void testMultipleDifferentChars() {
        assertTrue(Main.backspaceCompare("ab#c#d#", "abcd###"));
    }

    @Test
    public void testDifferentLengthsSameEffectiveLength() {
        assertTrue(Main.backspaceCompare("ab#b#c", "ab#c"));
    }

    @Test
    public void testSameLengthDifferentEffectiveLength() {
        assertFalse(Main.backspaceCompare("ab#c", "ab#d"));
    }

    @Test
    public void testOnlyBackspaces() {
        assertTrue(Main.backspaceCompare("####", "###"));
    }
}
