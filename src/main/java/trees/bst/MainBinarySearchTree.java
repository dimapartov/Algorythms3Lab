package trees.bst;

import java.util.Arrays;
import java.util.List;

public class MainBinarySearchTree {
    public static void main(String[] args) {

        AbstractBinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(2);
        binarySearchTree.insert(21);
        binarySearchTree.insert(23);
        binarySearchTree.insert(1);
        binarySearchTree.insert(10);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        binarySearchTree.insert(5);
        binarySearchTree.insert(4);

        System.out.println("-----------------------------------------Draw BST----------------------------------------");
        binarySearchTree.drawTree();

        System.out.println("---------------------------------------BST contains--------------------------------------");
        System.out.println(binarySearchTree.contains(2));
        System.out.println(binarySearchTree.contains(50));

        System.out.println("--------------------------BST search(tree from root/empty tree)--------------------------");
        System.out.println("From root = 21:");
        AbstractBinarySearchTree<Integer> firstBst = binarySearchTree.search(21);
        firstBst.drawTree();

        System.out.println("From root = 50:");
        AbstractBinarySearchTree<Integer> secondBst = binarySearchTree.search(50);
        secondBst.drawTree();

        System.out.println("-----------------------------------Get root, left and right------------------------------");
        AbstractBinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        System.out.println("Root: " + root.value);

        AbstractBinarySearchTree.Node<Integer> left = binarySearchTree.getLeft();
        System.out.println("Left: " + left.value);

        AbstractBinarySearchTree.Node<Integer> right = binarySearchTree.getRight();
        System.out.println("Right: " + right.value);

        System.out.println("-------------------------------------Find duplicates-------------------------------------");
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        List<Integer> numbers = Arrays.asList(1, 2, 3, 2, 1, 4, 5, 6, 7, 8, 9, 9, 10);
        List<Integer> duplicates = bst.findDuplicates(numbers);
        System.out.println("Duplicates: " + duplicates);
        
    }
}