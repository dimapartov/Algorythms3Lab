package trees.bst;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {
    private Node<E> root;
    @Override
    public void insert(E element) {
        root = insertRec(root, element);
    }
    private Node<E> insertRec(Node<E> root, E element) {
        if (root == null) {
            return new Node<>(element);
        }
        if (element.compareTo(root.value) < 0) {
            root.leftChild = insertRec(root.leftChild, element);
        } else if (element.compareTo(root.value) > 0) {
            root.rightChild = insertRec(root.rightChild, element);
        }
        return root;
    }
    @Override
    public boolean contains(E element) {
        return containsRec(root, element);
    }
    private boolean containsRec(Node<E> root, E element) {
        if (root == null) {
            return false;
        }
        if (element.compareTo(root.value) == 0) {
            return true;
        } else if (element.compareTo(root.value) < 0) {
            return containsRec(root.leftChild, element);
        } else {
            return containsRec(root.rightChild, element);
        }
    }
    @Override
    public AbstractBinarySearchTree<E> search(E element) {
        Node<E> resultNode = searchRec(root, element);
        return new BinarySearchTree<>(resultNode);
    }
    private Node<E> searchRec(Node<E> root, E element) {
        if (root == null || root.value.equals(element)) {
            return root;
        }
        if (element.compareTo(root.value) < 0) {
            return searchRec(root.leftChild, element);
        } else {
            return searchRec(root.rightChild, element);
        }
    }
    @Override
    public Node<E> getRoot() {
        return root;
    }
    @Override
    public Node<E> getLeft() {
        if (root != null) {
            return root.leftChild;
        }
        return null;
    }
    @Override
    public Node<E> getRight() {
        if (root != null) {
            return root.rightChild;
        }
        return null;
    }
    @Override
    public E getValue() {
        if (root != null) {
            return root.value;
        }
        return null;
    }
    @Override
    public void drawTree() {
        // Реализация отрисовки дерева может быть добавлена здесь
    }
    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }
}