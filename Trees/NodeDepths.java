import java.util.*;

class Program {

  public static int nodeDepths(BinaryTree root) {
    // Write your code here.
    // return -1;
		return nodeDepths(root, 0);
		
  }
	
	public static int nodeDepths(BinaryTree node, int depth) {
		if (node==null)
			return 0;
		return depth+nodeDepths(node.left, depth+1)+nodeDepths(node.right, depth+1);
	}

  static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    public BinaryTree(int value) {
      this.value = value;
      left = null;
      right = null;
    }
  }
}
