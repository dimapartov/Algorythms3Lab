package trees.bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree<E extends Comparable<E>> implements AbstractBinarySearchTree<E> {

    private Node<E> root;

    public BinarySearchTree(Node<E> root) {
        this.root = root;
    }

    public BinarySearchTree() {
    }

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
    public int getHeight(Node<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.leftChild);
            int rightHeight = getHeight(node.rightChild);
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }

    @Override
    public void drawTree() {
        if (root == null) {
            System.out.println("Tree is empty");
            return;
        }

        int maxLevel = maxLevel(root);

        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        while (!queue.isEmpty()) {
            int levelNodes = queue.size();
            int innerSpace = (int) Math.pow(2, maxLevel - level) - 1;
            int outerSpace = (int) Math.pow(2, maxLevel - level - 1) - 1;

            printSpaces(outerSpace);

            while (levelNodes > 0) {
                Node<E> node = queue.poll();
                System.out.print(node == null ? " " : node.value);

                if (node != null) {
                    queue.add(node.leftChild);
                    queue.add(node.rightChild);
                } else {
                    queue.add(null);
                    queue.add(null);
                }

                printSpaces(innerSpace);
                levelNodes--;
            }

            System.out.println();
            level++;
            if (level == maxLevel) {
                break;
            }
        }
    }
    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }
    private int maxLevel(Node<E> node) {
        if (node == null) {
            return 0;
        }
        return Math.max(maxLevel(node.leftChild), maxLevel(node.rightChild)) + 1;
    }

    @Override
    public List<E> findDuplicates(List<E> elements) {
        List<E> duplicates = new ArrayList<>();
        for (E element : elements) {
            if (this.contains(element)) {
                duplicates.add(element);
            } else {
                this.insert(element);
            }
        }
        return duplicates;
    }

}