import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T>{
    private Node<T> head;
    private int listLength;
    public MyLinkedList(){
        this.head = null;
        listLength = 0;
    }

    public boolean isEmpty(){
        return this.head == null;
    }

    public void addNode(T data){
        Node<T> newNode = new Node<>(data);
        if (this.isEmpty()){
            this.head = newNode;
        }else{
            Node<T> current = this.head;
            while (current.next != null) current=current.next;
            current.next = newNode;
        }
        listLength++;
    }

    public void addNode(T data, int idx){
        Node<T> newNode = new Node<>(data);
        if (idx == 0){
            if (!this.isEmpty()) {
                newNode.next = this.head;
            }
            this.head = newNode;
        } else if (idx >= listLength){
            System.out.println("Error: idx must be lower than length");
        }else{
            Node<T> current = this.head;
            for (int i = 0; i < idx-1; i++){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        listLength++;
    }

    public void delete(int k){
        if (!this.isEmpty()){
            if (k == 0){
                this.head = this.head.next;
            }else if (k < listLength){
                Node<T> current = this.head;
                for (int i = 0; i < k-1; i++){
                    current = current.next;
                }
                current.next = current.next.next;
            }else{
                System.out.println("Error: idx must be lower than length " + listLength);
            }
        }
    }

    public boolean find(T key){
        for (Node<T> current = this.head; current != null; current = current.next){
            if (current.data.equals(key)){
                return true;
            }
        }
        return false;
    }

    public T findMiddle(){
        Node<T> slow = this.head, fast = this.head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        assert slow != null;
        return slow.data;
    }

    public T reverse(){
        if (!this.isEmpty()){
            if (this.head.next == null){
                return this.head.data;
            }
            Node<T> current = this.head;
            Node<T> previous =  null;

            while(current != null) {
                Node<T> next = current.next;
                current.next = previous;
                previous = current;
                current = next;
            }
            this.head = previous;
            return this.head.data;
        }else {
            return null;
        }
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (Node<T> current = this.head; current != null; current = current.next){
            result.append(current.next == null ? (current.data) : (current.data + "↓\n"));
        }
        return this.head == null ? "Список пуст" : result.toString();
    }

    public Iterator<T> iterator(){
        return new Iterator<>() {
            Node<T> current = MyLinkedList.this.head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T returnedValue = current.data;
                current = current.next;
                return returnedValue;
            }
        };
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