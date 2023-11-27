package Trees;

import java.util.List;
import java.util.function.Consumer;

public interface AbstractBinaryTree<E> {
    E getKey();
    AbstractBinaryTree<E> getLeftTree();
    AbstractBinaryTree<E> getRightTree();
    void setKey(E key);
    String asIndentedPreOrder(int indent);
    List<AbstractBinaryTree<E>> preOrder();
    List<AbstractBinaryTree<E>> inOrder();
    List<AbstractBinaryTree<E>> postOrder();
    void forEachInOrder(Consumer<E> consumer);
    void depthFirstSearch();
    void breadthFirstSearch();
    void drawTree();
}