import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static org.junit.Assert.*;

public class Solution {

    public static boolean isValid(String code) {

        // determine if the input code is valid
        Deque<Character> stack= new ArrayDeque<>();
        Queue<Character> stackClosers= new LinkedList<>();
        
        Map<Character, Character> map= new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        
        for(char c: code.toCharArray()){
            if (c=='(' || c=='{' || c=='[')
                stack.push(c);
                
            if (c=='}' || c==')' || c==']')
                stackClosers.add(c);    
                
            if(!stack.isEmpty()){
                if(stackClosers.peek()==map.get(stack.peek())){
                    stack.pop();
                    stackClosers.remove();
                }
            }
        }

        return (stack.isEmpty() && stackClosers.isEmpty()) ? true : false;
    }


















    // tests

    @Test
    public void validShortCodeTest() {
        final boolean result = isValid("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = isValid("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = isValid("([][]}");
        assertFalse(result);
    }

    @Test
    public void interleavedOpenersAndClosersTest() {
        final boolean result = isValid("([)]");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = isValid("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = isValid("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = isValid("");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Solution.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}