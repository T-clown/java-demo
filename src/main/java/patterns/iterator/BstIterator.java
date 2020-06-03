
package patterns.iterator;

import java.util.ArrayDeque;
import java.util.NoSuchElementException;


public class BstIterator<T extends Comparable<T>> implements Iterator<TreeNode<T>> {

  private ArrayDeque<TreeNode<T>> pathStack;

  public BstIterator(TreeNode<T> root) {
    pathStack = new ArrayDeque<>();
    pushPathToNextSmallest(root);
  }


  private void pushPathToNextSmallest(TreeNode<T> node) {
    while (node != null) {
      pathStack.push(node);
      node = node.getLeft();
    }
  }


  @Override
  public boolean hasNext() {
    return !pathStack.isEmpty();
  }


  @Override
  public TreeNode<T> next() throws NoSuchElementException {
    if (pathStack.isEmpty()) {
      throw new NoSuchElementException();
    }
    TreeNode<T>  next = pathStack.pop();
    pushPathToNextSmallest(next.getRight());
    return next;
  }

}
