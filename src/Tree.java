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
    private TreeNode SearchNode(TreeNode root,int target){
        if(root==null){
            return  null;
        }else{
            if(root.data==target){
                return root;
            } else if (target>root.data) {
                return SearchNode(root.right,target);
            }else {
                return SearchNode(root.left,target);
            }
        }
    }
    public void Search(int target){
        TreeNode temp=SearchNode(this.root,target);
        if(temp==null){
            System.out.println("value not found");
        }else{
            System.out.println("value found");
        }
    }
    public void nodeDelete(int target){
        this.root=delete(this.root,target);
    }
    private TreeNode delete(TreeNode root ,int target){
        if(root==null) return root;
        if(target<root.data){
            root.left=delete(root.left,target);
        }else if(target>root.data){
            root.right=delete(root.right,target);
        }else {
            if(root.left==null || root.right==null){
                TreeNode temp=root.left!=null ? root.left:root.right;

                if (temp != null) {
                    return temp;
                } else {
                    return null;
                }
            }else{
                TreeNode successor=getSuccessor(root);
                root.data=successor.data;

                root.right=delete(root.right,successor.data);
                return root;
            }
        }
        return root;
    }
     private   TreeNode getSuccessor(TreeNode currentNode){
        if(currentNode==null){
            return null;
        }
        TreeNode temp=currentNode.right;

        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }

}
