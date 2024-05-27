public class Driver {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.insertNode(5);
        tree.insertNode(4);
        tree.insertNode(7);
        tree.insertNode(1);
        tree.insertNode(2);
        tree.insertNode(6);
//        tree.postOrder();
//        tree.inorder();
//        tree.preOrder();
//
//
//        System.out.println(tree.DFS(1));
//
//
//        System.out.println(tree.BFS(1));

        tree.inorder();
        tree.nodeDelete(7);
        tree.inorder();
    }
}
