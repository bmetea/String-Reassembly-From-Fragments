import static org.junit.Assert.assertTrue;

import org.junit.Test;

import components.set.Set;
import components.set.Set1L;

public class StringReassemblyTest {

    @Test
    public void testCombinationEmpty() {
        String str1 = "";
        String str2 = "";
        String result = StringReassembly.combination(str1, str2, 0);
        assertTrue(result.isEmpty());
        assertTrue(str1.equals(""));
    }

    @Test
    public void testCombinationOneEmpty() {
        String str1 = "first";
        String str2 = "";
        String result = StringReassembly.combination(str1, str2, 0);
        String result2 = StringReassembly.combination(str2, str1, 0);
        assertTrue(result.equals("first"));
        assertTrue(result2.equals("first"));
        assertTrue(str1.equals("first"));
        assertTrue(str2.equals(""));
    }

    @Test
    public void testCombinationNoOverlap() {
        String str1 = "first";
        String str2 = "second";
        String result = StringReassembly.combination(str1, str2, 0);
        String result2 = StringReassembly.combination(str2, str1, 0);
        assertTrue(result.equals("firstsecond"));
        assertTrue(result2.equals("secondfirst"));
        assertTrue(str1.equals("first"));
        assertTrue(str2.equals("second"));
    }

    @Test
    public void testCombinationOneOverlap() {
        String str1 = "firs";
        String str2 = "second";
        String result = StringReassembly.combination(str1, str2, 1);
        String result2 = StringReassembly.combination(str2, str1, 0);
        assertTrue(result.equals("firsecond"));
        assertTrue(result2.equals("secondfirs"));
        assertTrue(str1.equals("firs"));
        assertTrue(str2.equals("second"));
    }

    @Test
    public void testCombinationTwoOverlap() {
        String str1 = "chase";
        String str2 = "second";
        String result = StringReassembly.combination(str1, str2, 2);
        assertTrue(result.equals("chasecond"));
        assertTrue(str1.equals("chase"));
        assertTrue(str2.equals("second"));
    }

    @Test
    public void testCombinationTenOverlap() {
        String str1 = "12345678910";
        String str2 = "2345678910a";
        String result = StringReassembly.combination(str1, str2, 10);
        assertTrue(result.equals("12345678910a"));
        assertTrue(str1.equals("12345678910"));
        assertTrue(str2.equals("2345678910a"));
    }

    @Test
    public void testaddToSetAvoidingSubstringsNotContained() {
        //test the method when the string is not contained
        String str1 = "123";
        String str2 = "456";
        Set<String> test = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "64";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);

        assertTrue(test.contains(str3));
        assertTrue(test.size() == 3);
        assertTrue(test.contains(str1));
        assertTrue(test.contains(str2));

    }

    @Test
    public void testaddToSetAvoidingSubstringsNotContained2() {
        //test the method when the string is not contained
        String str1 = "making tests";
        String str2 = " is boring";
        Set<String> test = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "I want to play starcraft";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);

        assertTrue(test.contains(str3));
        assertTrue(test.size() == 3);
        assertTrue(test.contains(str1));
        assertTrue(test.contains(str2));

    }

    @Test
    public void testaddToSetAvoidingSubstringsContained() {
        //test when the string is contained
        String str1 = "123";
        String str2 = "456";
        Set<String> test = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "5";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertTrue(test.size() == 2);
        assertTrue(test.contains(str1));
        assertTrue(test.contains(str2));

    }

    @Test
    public void testaddToSetAvoidingSubstringsContained2() {
        //test when the string is a copy of another
        String str1 = "this is a test";
        String str2 = "this is also a test";
        Set<String> test = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "this is also a test";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertTrue(test.size() == 2);
        assertTrue(test.contains(str1));
        assertTrue(test.contains(str2));

    }

    @Test
    public void testaddToSetAvoidingSubstringsContained3() {
        //test when a string is a substring of multiple
        String str1 = "this is a test";
        String str2 = "this is also a test";
        Set<String> test = new Set1L<String>();
        test.add(str1);
        test.add(str2);
        String str3 = "this is";
        StringReassembly.addToSetAvoidingSubstrings(test, str3);
        assertTrue(test.size() == 2);
        assertTrue(test.contains(str1));
        assertTrue(test.contains(str2));

    }

}
