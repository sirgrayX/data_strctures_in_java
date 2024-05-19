public class Queue<T>{
    private Node<T> head;
    private Node<T> tail;

    public Queue(){
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void enqueue(T data){
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()){
            this.head = newNode;
        }else{
            this.tail.next = newNode;
        }
        this.tail = newNode;
    }

    public T dequeue(){
        if (this.isEmpty()){
            return null;
        }else{
            T returnedValue = head.data;
            this.head = this.head.next;
            return returnedValue;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Node<T> current = this.head; current != null; current = current.next){
            result.insert(0, (current == this.head) ? current.data : (current.data + "↓\n"));
        }
        return this.head == null ? "Очередь пуста" : result.toString();
    }


    private static class  Node<T>{
        private final T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
}
