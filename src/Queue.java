public class Queue {
    QueueNode front;
    QueueNode rear;

    public void enqueue(TreeNode node){
        QueueNode newNode=new QueueNode(node);
        if (this.front==null){
            this.front=this.rear=newNode;
        }else{
            this.rear.next=newNode;
            this.rear=newNode;
        }
    }
    public TreeNode dequeue(){
        if(this.front==null){
            return null;
        }
        QueueNode temp=this.front;
        this.front=this.front.next;
        return temp.node;
    }
    public boolean isEmpty(){
        if(this.front==null){
            return true;
        }else{
            return false;
        }
    }
}
