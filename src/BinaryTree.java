public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;
    public BinaryTree(){
        this.root = null;
    }

    public void add(T data){
        this.root = addRecursive(this.root, data);
    }
    private Node<T> addRecursive(Node<T> current, T data){
        if (current == null){
            return new Node<>(data);
        }else{
            if (current.data.compareTo(data) < 0){
                current.right = addRecursive(current.right, data);
            }
            if (current.data.compareTo(data) > 0){
                current.left = addRecursive(current.left, data);
            }
            if (current.data.compareTo(data) == 0){
                return current;
            }
        }
        return current;
    }

    public void delete(T data){
        this.root = this.deleteRecursive(this.root, data);
    }

    private Node<T> deleteRecursive(Node<T> current, T data){
        if (current == null){
            return null;
        }
        if (current.data.compareTo(data) < 0){
            current.right = this.deleteRecursive(current.right, data);
        }

        if (current.data.compareTo(data) > 0){
            current.left = this.deleteRecursive(current.left, data);
        }

        if (current.data.compareTo(data) == 0){
            if (current.left == null & current.right == null){
                return null;
            }
            if (current.left == null){
                return current.right;
            }
            if (current.right == null){
                return current.left;
            }
            current.data = this.findSmallestElement(current.right);
            current.right = this.deleteRecursive(current.right, current.data);
        }
        return current;
    }

    public void traverseInDepth(){
        this.traverseInDepthRecursive(this.root);
    }

    private void traverseInDepthRecursive(Node<T> current){
        if (current != null){
            System.out.println(current.data);
            if (current.right != null){
                this.traverseInDepthRecursive(current.right);
            }
            if (current.left != null){
                this.traverseInDepthRecursive(current.left);
            }
        }
    }

    public void traverseInWidth(){
        if (this.root != null){
            Queue<Node<T>> queue = new Queue<>();
            queue.enqueue(this.root);
            while(!queue.isEmpty()){
                Node<T> node = queue.dequeue();
                if (node.left != null){
                    queue.enqueue(node.left);
                }
                if (node.right != null){
                    queue.enqueue(node.right);
                }
                System.out.println(node.data);
            }
        }
    }

    private T findSmallestElement(Node<T> current){
        return current.left != null ? this.findSmallestElement(current.left) : current.data;
    }


    private class Node<T extends Comparable<T>> {
        private T data;
        private Node<T> left;
        private Node<T> right;

        public Node(T data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
}
