import java.util.*;
class Program {
  public static int[] twoNumberSum(int[] array, int targetSum) {
    // Write your code here.
		int start=0;
		int end=array.length-1;
		
		Arrays.sort(array);
		while(start<end){
			
			if((array[start]+array[end])>targetSum)
				end--;
			else if((array[start]+array[end])<targetSum)
				start++;
			else
				return new int[] {array[start], array[end]};
		}
		
    return new int[0];
  }
}
