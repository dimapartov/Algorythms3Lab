package trees.bt;

import trees.bt.AbstractBinaryTree;
import trees.bt.BinaryTree;

public class MainBinaryTree {
    public static void main(String[] args) {

        AbstractBinaryTree<Integer> tree = new BinaryTree<>(13,
                new BinaryTree<>(8,new BinaryTree<>(5,null,null),new BinaryTree<>(9,new BinaryTree<>(10,null,null),null)),
                new BinaryTree<>(25,new BinaryTree<>(15,null,null),new BinaryTree<>(26,null,new BinaryTree<>(27,null,null))));

        System.out.println("----------------------------------As indented pre order----------------------------------");
        System.out.println(tree.asIndentedPreOrder(0));

        System.out.println("-------------------------------------------Tree------------------------------------------");
        tree.drawTree();

        System.out.println("-------------------------------------------DFS-------------------------------------------");
        tree.depthFirstSearch();

        System.out.println("-------------------------------------------BFS-------------------------------------------");
        tree.breadthFirstSearch();

        System.out.println("----------------------------------------Pre order----------------------------------------");
        for (AbstractBinaryTree<Integer> node : tree.preOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("-----------------------------------------In order----------------------------------------");
        for (AbstractBinaryTree<Integer> node : tree.inOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("------------------------------------Post order-------------------------------------------");
        for (AbstractBinaryTree<Integer> node : tree.postOrder()) {
            System.out.print(node.getKey() + " ");
        }
        System.out.println();

        System.out.println("------------------------------------For each in order------------------------------------");
        tree.forEachInOrder(node -> System.out.print(node + " "));
        System.out.println();
    }
}