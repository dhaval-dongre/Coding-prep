import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.util.*;
import static org.junit.Assert.*;

public class Solution {

    // fill in the definitions for push(), pop(), and getMax()
    

    public static class MaxStack {
        
        Deque<Integer> stack= new ArrayDeque<>();
        Deque<Integer> maxStack= new ArrayDeque<>();
        
        // int max=Integer.MIN_VALUE;

        public void push(int item) {
            stack.push(item);
            // max=Math.max(item, max);
            
            if(maxStack.isEmpty() || item>=maxStack.peek())
                maxStack.push(item);
        }

        public int pop() {
            
            if(stack.peek()==maxStack.peek())
                maxStack.pop();
                
            return stack.pop();
            
        }

        public int getMax() {
            return maxStack.peek();
        }
    }


















    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
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