public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(5);
        tree.add(10);
        tree.add(0);
        tree.add(-12);
        tree.add(7);
        tree.add(12);
        tree.delete(-12);
        tree.traverseInWidth();
    }
}