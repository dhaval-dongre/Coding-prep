
import java.util.Arrays;

class Program {
  public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
    // Write your code here.
    // return null;
		
		int smallest=Integer.MAX_VALUE;
		int current=Integer.MAX_VALUE;
		int smallestPair[]= new int[2];
		int i=0;
		int j=0;
		
		Arrays.sort(arrayOne);
		Arrays.sort(arrayTwo);
		
		while(i<arrayOne.length && j<arrayTwo.length){
			
			int firstNo=arrayOne[i];
			int secondNo=arrayTwo[j];
			
			if(firstNo>secondNo){
				j++;
				current=firstNo-secondNo;
			}
			
			else if(secondNo>firstNo){
				i++;
				current=secondNo-firstNo;
			}
			
			else{
				return new int[]{firstNo, secondNo};
			}
			
			if(current<smallest){
				smallest=current;
				smallestPair=new int[]{firstNo, secondNo};
			}
		}
		return smallestPair;
  }
}
