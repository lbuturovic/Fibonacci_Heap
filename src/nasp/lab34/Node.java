package nasp.lab34;

public class Node <T extends Comparable<T>> implements Comparable<Node<T>>{
    T key;
    Node<T> left;
    Node<T> right;
    Node<T> p;
    Node<T> child;
    int degree;
    boolean mark;

    public Node(){
        this.p = null;
        this.left = this;
        this.right = this;
        this.child = null;
        this.degree = 0;
        this.mark = false;
    }

    public Node (T k){
        this();
        this.key = k;
    }

    @Override
    public String toString() {
        return this.key.toString();
    }

    @Override
    public int compareTo(Node<T> o) {
        return key.compareTo(o.key);
    }
}
