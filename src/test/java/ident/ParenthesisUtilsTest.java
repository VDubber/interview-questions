package ident;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParenthesisUtilsTest {

    @Test
    public void validParenthesisTest() {
        String validCase1 = "((df)we(er(bf)we)as)";
        assertTrue(ParenthesisUtils.validParentheses(validCase1));

        String validCase2 = "(FWE(sdf(fe0))())";
        assertTrue(ParenthesisUtils.validParentheses(validCase2));

        String invalidCase1 = ")";
        assertFalse(ParenthesisUtils.validParentheses(invalidCase1));

        String invalidCase2 = "(";
        assertFalse(ParenthesisUtils.validParentheses(invalidCase2));

        String invalidCase3 = ")(";
        assertFalse(ParenthesisUtils.validParentheses(invalidCase3));

        String invalidCase4 = "()(";
        assertFalse(ParenthesisUtils.validParentheses(invalidCase4));
    }

    @Test //
    public void specialFormatterTest() {
        String case1 = "((df)we(er(bf)we)as)";
        // ((df)we(er(bf)we)as)
        // ((df)we(erfbwe)as)
        // (fdweewbfreas)
        // saerfbweewdf
        String expectedResult = "saerfbweewdf";
        assertEquals(expectedResult, ParenthesisUtils.specialFormatter(case1));

        String case2 = "asdf(qwer(ty)()top)";
        // asdf(qwer(ty)()top)
        // asdf(qweryttop)
        // asdfpottyrewq
        String expectedResult2 = "asdfpottyrewq";
        assertEquals(expectedResult2, ParenthesisUtils.specialFormatter(case2));

    }

    @Test(expected = IllegalArgumentException.class)
    public void specialFormatterInvalidArgumentText() {
        String invalidCase1 = "asdf()(";

        ParenthesisUtils.specialFormatter(invalidCase1);
    }
}