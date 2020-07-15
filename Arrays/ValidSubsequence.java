import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		// int i=0;
		int sNo=0;
		for(int i=0;i<array.size();i++){
			
			if(sNo==sequence.size())
				break;
			
			if(sequence.get(sNo)==array.get(i))
				sNo++;
		}
			
    return sNo==sequence.size();
  }
}
