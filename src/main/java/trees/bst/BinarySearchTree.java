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
        int maxHeight = getHeight(this.root);
        Queue<Node<E>> queue = new LinkedList<>();
        queue.add(this.root);

        int level = 1;
        int nodesInLevel = 1;

        while (!queue.isEmpty()) {
            int nodesInNextLevel = 0;
            int spacesBefore = (int) (Math.pow(2, maxHeight - level) - 1);
            int spacesBetween = (int) (Math.pow(2, maxHeight - level + 1) - 1);

            for (int i = 0; i < spacesBefore; i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < nodesInLevel; i++) {
                Node<E> node = queue.poll();
                if (node != null) {
                    System.out.print(node.value);
                    queue.add(node.leftChild);
                    queue.add(node.rightChild);
                    nodesInNextLevel += 2;
                } else {
                    System.out.print(" ");
                    queue.add(null);
                    queue.add(null);
                }

                for (int j = 0; j < spacesBetween; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            level++;
            nodesInLevel = nodesInNextLevel;

            if (level > maxHeight) {
                break;
            }
        }
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