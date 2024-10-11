package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    
    @Test
    public void testEmptyString() {
        assertTrue(isBalanced("")); 
    }

    @Test
    public void testSingleOpenSymbol() {
        assertFalse(isBalanced("{")); 
        assertFalse(isBalanced("[")); 
        assertFalse(isBalanced("(")); 
    }

    @Test
    public void testSingleCloseSymbol() {
        assertFalse(isBalanced("}")); 
        assertFalse(isBalanced("]")); 
        assertFalse(isBalanced(")")); 
    }

    @Test
    public void testSimpleBalancedString() {
        assertTrue(isBalanced("()")); 
        assertTrue(isBalanced("[]"));
        assertTrue(isBalanced("{}"));
    }

    @Test
    public void testComplexBalancedString() {
        assertTrue(isBalanced("{[]}"));
        assertTrue(isBalanced("{[()]}")); 
    }

    @Test
    public void testUnbalancedString() {
        assertFalse(isBalanced("{]")); 
        assertFalse(isBalanced("[(])")); 
        assertFalse(isBalanced("{[(])}"));
    }
}