package trees.bst;

public class MainBinarySearchTree {
    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(2);
        binarySearchTree.insert(21);
        binarySearchTree.insert(23);
        binarySearchTree.insert(-5);
        binarySearchTree.insert(10);
        binarySearchTree.insert(6);

        System.out.println("------------------------------------Binary search tree-----------------------------------");
        binarySearchTree.drawTree();

        System.out.println("------------------------------------BST contains-----------------------------------");
        System.out.println(binarySearchTree.contains(2));
        System.out.println(binarySearchTree.contains(50));

        System.out.println("--------------------------------BST from root/empty tree---------------------------------");
        System.out.println("From root = 21:");
        AbstractBinarySearchTree<Integer> firstBst = binarySearchTree.search(21);
        firstBst.drawTree();

        System.out.println("From root = 50:");
        AbstractBinarySearchTree<Integer> secondBst = binarySearchTree.search(50);
        secondBst.drawTree();

        System.out.println("--------------------------------Get root, left and right---------------------------------");
        AbstractBinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        System.out.println("Root: " + root.value);

        AbstractBinarySearchTree.Node<Integer> left = binarySearchTree.getLeft();
        System.out.println("Left: " + left.value);

        AbstractBinarySearchTree.Node<Integer> right = binarySearchTree.getRight();
        System.out.println("Right: " + right.value);
    }
}