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
        System.out.println();
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
    public String BFS(int value) {
        System.out.println();
        int level=0;
        if(this.root ==null){
            return "tree is Empty";
        }else{
            Queue queue=new Queue();
            queue.enqueue(this.root);

            while(!queue.isEmpty()){
                TreeNode temp=queue.dequeue();// tree node ekat assigned karnn puluwan wenne  dequeue method ekedi return karanne tree node ekak
                System.out.print("--->"+temp.data);
                if(temp.data==value){
                    return "level="+ level;
                }else{
                    if(temp.right!=null){
                        queue.enqueue(temp.right);
                        level++;
                    }
                    if(temp.left!=null){
                        queue.enqueue(temp.left);
                        level++;
                    }
                }
            }
        }
        return "not found";
    }
    public int getdepth(char letter) {
        int depth = Level(root, letter, 0);
        return depth;
    }

    private int Level(TreeNode root, char letter, int level) {
        if (root == null) {
            return 0;
        }
        if (root.letter == letter) {
            return level;
        }
        int n = Level(root.left, letter, level + 1);
        if (n != 0) {
            return n;
        }
        n = Level(root.right, letter, level + 1);
        return n;
    }

    //last methods are created for integer value. It will be set to character.

    //search
    public TreeNode searchNode(){
        if(root == null){
            return null;

        } else {
            if(root.data == target){
                return root;

            } else if(target > root.data){
                return searchNode(root.right, target);

            } else {
                return searchNode(root.left, target);
            }
        }
    }

    public void search(int target){

        TreeNode temp = searchNode(root, target);

        if(temp == null){
            System.out.println("Value not Found!");
        } else {
            System.out.println("Value Found! " + target);
        }
    }

    //delete
    public void delete(int target){
        this.root = deleteNode(this.root, target);
    }

    private TreeNode deleteNode(TreeNode root, int target){
        if(root == null){
            return root;
        }

        if(taget < root.data){
            root.left = deleteNode(root.left, target);

        } else if(){
            root.right = deleteNode(root.right, target);

        } else {

            if(root.left == null && root.right == null){
                System.out.println("Deleting " + target);
                return null;

            } else if(root.left == null){
                System.out.println("Deleting " + target);
                return root.right;

            } else if(root.right == null){
                System.out.println("Deleting " + target);
                return root.leftt;

            } else {

                int minValue = minVal(root.right);
                root.data = minValue;
                root.right = deleteNode(root.right, minValue);
                System.out.println("Deleting " + target);
            }
        }
        return root;
    }

    //searching for minimun value
    int minVal(TreeNode root){
        int minV = root.data;

        while(root.left != null){
            minV = root.left.data;
            root = root.left;
        }
        return minV;
    }

} 
}
