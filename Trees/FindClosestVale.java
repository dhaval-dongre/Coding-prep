import java.util.*;

class Program {
  public static int findClosestValueInBst(BST tree, int target) {
    // Write your code here.
    // return -1;
		
		if(tree.value==target || (tree.left==null && tree.right==null))
			return tree.value;
		
		else if(tree.left!=null && tree.right!=null){
			
				if(Math.abs(target-tree.left.value) > Math.abs(target-tree.right.value))
					return findClosestValueInBst(tree.right, target);

				else
					return findClosestValueInBst(tree.left, target);
		}
		
		else if(tree.left==null)
			 return findClosestValueInBst(tree.right, target);
		
		else
			return findClosestValueInBst(tree.left, target);
			
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
