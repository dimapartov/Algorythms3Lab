package trees.bt;

import java.util.*;
import java.util.function.Consumer;

public class BinaryTree<E> implements AbstractBinaryTree<E> {
    private E key;
    private AbstractBinaryTree<E> leftTree;
    private AbstractBinaryTree<E> rightTree;
    public BinaryTree(E key, AbstractBinaryTree<E> leftTree, AbstractBinaryTree<E> rightTree) {
        this.key = key;
        this.leftTree = leftTree;
        this.rightTree = rightTree;
    }
    private int getHeight(AbstractBinaryTree<E> node) {
        if (node == null) {
            return 0;
        } else {
            int leftHeight = getHeight(node.getLeftTree());
            int rightHeight = getHeight(node.getRightTree());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    @Override
    public E getKey() {
        return key;
    }
    @Override
    public AbstractBinaryTree<E> getLeftTree() {
        return leftTree;
    }
    @Override
    public AbstractBinaryTree<E> getRightTree() {
        return rightTree;
    }
    @Override
    public void setKey(E key) {
        this.key = key;
    }
    @Override
    public String asIndentedPreOrder(int indent) {
        StringBuilder result = new StringBuilder();
        result.append(" ".repeat(indent)).append(getKey()).append("\n");
        if (getLeftTree() != null) {
            result.append(getLeftTree().asIndentedPreOrder(indent + 1));
        }
        if (getRightTree() != null) {
            result.append(getRightTree().asIndentedPreOrder(indent + 1));
        }
        return result.toString();
    }
    @Override
    public List<AbstractBinaryTree<E>> preOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        result.add(this);
        if (getLeftTree() != null) {
            result.addAll(getLeftTree().preOrder());
        }
        if (getRightTree() != null) {
            result.addAll(getRightTree().preOrder());
        }
        return result;
    }
    @Override
    public List<AbstractBinaryTree<E>> inOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (getLeftTree() != null) {
            result.addAll(getLeftTree().inOrder());
        }
        result.add(this);
        if (getRightTree() != null) {
            result.addAll(getRightTree().inOrder());
        }
        return result;
    }
    @Override
    public List<AbstractBinaryTree<E>> postOrder() {
        List<AbstractBinaryTree<E>> result = new ArrayList<>();
        if (getLeftTree() != null) {
            result.addAll(getLeftTree().postOrder());
        }
        if (getRightTree() != null) {
            result.addAll(getRightTree().postOrder());
        }
        result.add(this);
        return result;
    }
    @Override
    public void forEachInOrder(Consumer<E> consumer) {
        if (getLeftTree() != null) {
            getLeftTree().forEachInOrder(consumer);
        }
        consumer.accept(getKey());
        if (getRightTree() != null) {
            getRightTree().forEachInOrder(consumer);
        }
    }
    @Override
    public void depthFirstSearch() {
        Stack<AbstractBinaryTree<E>> stack = new Stack<>();
        stack.push(this);
        while (!stack.isEmpty()) {
            AbstractBinaryTree<E> current = stack.pop();
            System.out.print(current.getKey() + " ");
            if (current.getRightTree() != null) {
                stack.push(current.getRightTree());
            }
            if (current.getLeftTree() != null) {
                stack.push(current.getLeftTree());
            }
        }
        System.out.println();
    }
    @Override
    public void breadthFirstSearch() {
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.offer(this);
        while (!queue.isEmpty()) {
            AbstractBinaryTree<E> current = queue.poll();
            System.out.print(current.getKey() + " ");
            if (current.getLeftTree() != null) {
                queue.offer(current.getLeftTree());
            }
            if (current.getRightTree() != null) {
                queue.offer(current.getRightTree());
            }
        }
        System.out.println();
    }
    @Override
    public void drawTree() {
        int maxHeight = getHeight(this);
        Queue<AbstractBinaryTree<E>> queue = new LinkedList<>();
        queue.add(this);
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
                AbstractBinaryTree<E> node = queue.poll();
                if (node != null) {
                    System.out.print(node.getKey());
                    queue.add(node.getLeftTree());
                    queue.add(node.getRightTree());
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
}