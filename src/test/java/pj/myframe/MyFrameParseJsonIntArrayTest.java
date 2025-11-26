package pj.myframe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for MyFrame.parseJsonIntArray method.
 */
public class MyFrameParseJsonIntArrayTest {

    @Test
    void testParseSimpleArray() {
        int[] result = MyFrame.parse("[1, 2, 3]");
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void testParseEmptyArray() {
        int[] result = MyFrame.parse("[]");
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void testParseSingleElement() {
        int[] result = MyFrame.parse("[42]");
        assertArrayEquals(new int[]{42}, result);
    }

    @Test
    void testParseWithExtraWhitespace() {
        int[] result = MyFrame.parse("  [ 1 ,  2 ,  3 ]  ");
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void testParseWithNoSpaces() {
        int[] result = MyFrame.parse("[1,2,3]");
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void testParseNegativeNumbers() {
        int[] result = MyFrame.parse("[-1, -2, -3]");
        assertArrayEquals(new int[]{-1, -2, -3}, result);
    }

    @Test
    void testParseMixedNumbers() {
        int[] result = MyFrame.parse("[1, -2, 3, -4, 5]");
        assertArrayEquals(new int[]{1, -2, 3, -4, 5}, result);
    }

    @Test
    void testParseLargeNumbers() {
        int[] result = MyFrame.parse("[1000000, 2000000, 3000000]");
        assertArrayEquals(new int[]{1000000, 2000000, 3000000}, result);
    }

    @Test
    void testParseWithoutBrackets() {
        int[] result = MyFrame.parse("1, 2, 3");
        assertArrayEquals(new int[]{1, 2, 3}, result);
    }

    @Test
    void testParseEmptyString() {
        int[] result = MyFrame.parse("");
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void testParseWhitespaceOnly() {
        int[] result = MyFrame.parse("   ");
        assertArrayEquals(new int[]{}, result);
    }

    @Test
    void testParseNullInput() {
        assertThrows(NullPointerException.class, () -> MyFrame.parse(null));
    }

    @Test
    void testParseInvalidInput() {
        assertThrows(NumberFormatException.class, () -> MyFrame.parse("[1, abc, 3]"));
    }
}
