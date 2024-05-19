public class Stack<T> {
    Node<T> head;
    public Stack (){
        this.head = null;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void push(T data){
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()) {
            this.head = newNode;
        } else{
            Node<T> current = this.head;
            while(current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public T peek(){
        Node<T>current = this.head;
        while(current.next != null){current = current.next;}
        return current.data;
    }

    public T pop(){
        T returnedValue = null;
        if (!this.isEmpty()){
            if (this.head.next == null){
                returnedValue = this.head.data;
                this.head = null;
            } else{
                Node<T> current = this.head;
                while(current.next.next != null){current = current.next;}
                returnedValue = current.next.data;
                current.next = null;
            }
        }
        return returnedValue;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Node<T> current = this.head; current != null; current = current.next){
            result.insert(0, (current == this.head) ? current.data : (current.data + "↓\n"));
        }
        return this.head == null ? "Стек пустой" : result.toString();
    }

    private static class Node<T>{
        private final T data;
        private Node<T> next;

        public Node(T data){
            this.data = data;
            this.next = null;
        }
    }
}
