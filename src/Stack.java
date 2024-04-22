public class Stack {
    private StackNode top;

    public Stack() {
        this.top =null;
    }
    public boolean isEmpty(){
        if(this.top==null){
            return true;
        }else {
            return false;
        }
    }
    public void push(TreeNode node){
        StackNode newNode=new StackNode(node);
        newNode.next=this.top;
        this.top=newNode;
    }
    public TreeNode pop(){
        if(this.top!=null){
            StackNode temp=this.top;
            this.top=top.next;
            return temp.node;
        }
        return null;
    }

}
