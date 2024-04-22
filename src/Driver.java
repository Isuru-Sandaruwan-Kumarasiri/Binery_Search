public class Driver {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.insertNode(5);
        tree.insertNode(4);
        tree.insertNode(7);
        tree.insertNode(1);
        tree.postOrder();
        tree.inorder();
        tree.preOrder();





        tree.DFS(1);
    }
}
