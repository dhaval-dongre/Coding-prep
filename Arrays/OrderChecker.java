import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class Solution {

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        // check if we're serving orders first-come, first-served
        int i=0;
        int j=0;
        
        for(int served : servedOrders){
            if(i<=takeOutOrders.length-1 && served==takeOutOrders[i])
                i++;
            else if(j<=dineInOrders.length-1 && served==dineInOrders[j])
                j++;
            else
                return false;
        }
        
        if(i!=takeOutOrders.length || j!=dineInOrders.length)
            return false;

        return true;
    }


















    // tests

    @Test
    public void bothRegistersHaveSameNumberOfOrdersTest() {
        final int[] takeOutOrders = {1, 4, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 4, 5, 6};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    @Test
    public void registersHaveDifferentLengthsTest() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 6, 3, 5};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void oneRegisterIsEmptyTest() {
        final int[] takeOutOrders = {};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {2, 3, 6};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    @Test
    public void servedOrdersIsMissingOrdersTest() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 6, 3, 5};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void servedOrdersHasExtraOrders() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 5, 6, 8};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void oneRegisterHasExtraOrders() {
        final int[] takeOutOrders = {1, 9};
        final int[] dineInOrders = {7, 8};
        final int[] servedOrders = {1, 7, 8};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }


    @Test
    public void oneRegisterHasUnservedOrders() {
        final int[] takeOutOrders = {55, 9};
        final int[] dineInOrders = {7, 8};
        final int[] servedOrders = {1, 7, 8, 9};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void orderNumbersAreNotSequential() {
        final int[] takeOutOrders = {27, 12, 18};
        final int[] dineInOrders = {55, 31, 8};
        final int[] servedOrders = {55, 31, 8, 27, 12, 18};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
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