public class Tree {
    TreeNode root;

    public Tree() {
        this.root = null;
    }

    public void insertNode(int data){
        TreeNode newNode=new TreeNode(data);
        this.root=insert(this.root,newNode);
    }
    private TreeNode insert(TreeNode root,TreeNode newNode){
        if(root == null){
            return newNode;
        }
        if(newNode.data < root.data){
            root.left = insert(root.left, newNode);
        } else {
            root.right = insert(root.right, newNode);
        }

        return root;
    }
    //in-order Traversal
    public void inorder(){
        System.out.println();
        inorderTraversal(this.root);
    }
    private void inorderTraversal(TreeNode root){
        if(root!=null){
            inorderTraversal(root.left);
            System.out.print(root.data+" ");
            inorderTraversal(root.right);
        }
    }
    //pre-order Traversal
    public void preOrder(){
        System.out.println();
        preOrderTraversal(this.root);
    }
    private void preOrderTraversal(TreeNode root){
        if(root !=null){
            System.out.print(root.data+" ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }


    //post-order Traversal
    public void postOrder(){
        System.out.println();
        postOrderTraversal(this.root);
    }

    private void postOrderTraversal(TreeNode root){

        if(root != null){
            postOrderTraversal(root.left);             //left
            postOrderTraversal(root.right);            //right
            System.out.print(root.data + " ");         //root
        }
    }


    //DFS Search
    public String DFS(int value){
        Stack stack=new Stack();
        stack.push(this.root);
        while(!stack.isEmpty()){
            TreeNode temp=stack.pop();
            System.out.print("--->"+temp.data);
            if(temp.data==value){
                return "found";
            }else {
                if(temp.right!=null){
                    stack.push(temp.right);
                }
                if(temp.left!=null){
                    stack.push(temp.left);
                }
            }
        }
        return "not found";
    }
}
