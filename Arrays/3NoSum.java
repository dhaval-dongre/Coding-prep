import java.util.*;

class Program {
  public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
    // Write your code here.
    // return null;
		Arrays.sort(array);
		List<Integer[]> list= new ArrayList<>();
		
		for(int i=0;i<array.length-2;i++){
			int start=i+1;
			int end=array.length-1;
			
			while(start<end){
			int sum=array[i]+array[start]+array[end];
			
			if(sum==targetSum){
				Integer out[]={array[i],array[start],array[end]};
				Arrays.sort(out);
				list.add(out);
				start++;
				end--;
			}
			
			else if(sum>targetSum)
				end--;
				
			else if(sum<targetSum)
				start++;
		}
	}
		return list;
  }
}
