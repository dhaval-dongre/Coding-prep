import java.util.*;

class Program {
  // This is the class of the input root. Do not edit it.
  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List<Integer> branchSums(BinaryTree root) {
    // Write your code here.
		List<Integer> list=new ArrayList<>();
		
    branchSums(root, 0, list);
		return list;
  }
	
	 public static void branchSums(BinaryTree node, int sum, List<Integer> list){
		 
		 if(node==null)
			 return;
		 
		 sum=sum+node.value;
		 
		 if(node.left==null && node.right==null)
			 list.add(sum);
		 
		 branchSums(node.left,sum,list);
 		 branchSums(node.right,sum,list);
		
		 
	 } 
	
}
