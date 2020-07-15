import java.util.*;

class Program {
  public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
    // Write your code here.
    // return null;
		int start=0;
		int end=array.size()-1;
		
		while(start<end){
			
			while(start<end && array.get(end)==toMove)
				end--;
				
			if(array.get(start)==toMove)
			{
				int temp=array.get(end);
				array.set(end, array.get(start));
				array.set(start,temp);
				end--;
			}
			start++;
			
		}
		
		return array;
  }
}
