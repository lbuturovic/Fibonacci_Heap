package nasp.lab34;

public class FibHeap<T extends Comparable<T>> {
    Node<T> min;
    int n; //broj trenutnih čvorova u gomili

    public Node<T> getMin() {
        return min;
    }

    public int getN() {
        return n;
    }

    public FibHeap() {
        this.min = null;
        this.n = 0;
    }

    public void insertNode(Node<T> x) {
       /* x.degree = 0;
        x.p = null;
        x.child = null;     vec namjesteno u konstruktoru cvora
        x.mark = false;*/

        if (min == null) {
            x.left = x;
            x.right = x;
            min = x;
        } else {
            x.right = min;
            x.left = min.left;
            min.left.right = x;
            min.left = x;
            if (x.compareTo(min) < 0) //x.key < min.key
                min = x;
        }
        n += 1;
    }

    public void insert(T key) {
        insertNode(new Node<>(key));
    }

    public static FibHeap union(FibHeap H1, FibHeap H2) {
        FibHeap H = new FibHeap<>();
        H.min = H1.min;
        if (H1.min != null && H2.min != null) {
            //concatenate the root list of H2 with the root list of H
            Node min1R = H1.min.right;
            Node min2L = H2.min.left;
            H1.min.right = H2.min;
            H2.min.left = H1.min;
            min2L.right = min1R;
            min1R.left = min2L;

        }
        if (H1.min == null || (H2.min != null && H2.min.compareTo(H1.min) < 0)) {
            H.min = H2.min;
        }
        H.n = H1.n + H2.n;
        return H;
    }


    public Node<T> extractMin() {
        Node<T> z = this.min;
        if (z != null) {
            Node c = z.child;
            Node x = c;
            if (c != null) {
                Node k = c;
                do {
                    k = c.right;
                    c.p = null;
                    insertNode(c);
                    c = c.right;
                    c = k;
                } while (c != null && c != x);
            }
            // izbacivanje min iz gomile
            z.left.right = z.right;
            z.right.left = z.left;
            z.child = null;
            //
            if (z == z.right) {
                this.min = null;
            } else {
                this.min = z.right;
                this.consolidate();
            }
            this.n = this.n - 1;
        }

        return z;
    }

    public void consolidate() {
        double phi = (1 + Math.sqrt(5)) / 2;
        int D = (int) (Math.log(this.n) / Math.log(phi));
        Node[] A = new Node[D + 1];
        for (int i = 0; i < D; i++) {
            A[i] = null;
        }
        Node w = this.min;
        if (w != null) {
            Node k = this.min; // kako bi se moglo provjeriti jesu li predjeni svi korijenski cvorovi
            do {
                Node x = w;
                Node wright = w.right;
                int d = x.degree;
                while (A[d] != null) {
                    Node y = A[d];
                    if (x.compareTo(y) > 0) {
                        //zamjena cvorova x i y
                        Node z = x;
                        x = y;
                        y = z;
                        //w = x; //trenutni cvor iz niza korijena
                        //
                    }
                    if (y == k) k = k.right;
                    if (y == wright) {
                        wright = wright.right;
                    }
                    FibHeapLink(y, x);
                    A[d] = null;
                    //k = x;
                    d += 1;
                }
                A[d] = x;
                w = wright;
            } while (w != null && w != k);
            // rekonstrukcija gomile
            this.min = null;
            for (int i = 0; i < D; i++) {
                if (A[i] != null) insertNode(A[i]);
            }
        }
    }

    public static void FibHeapLink(Node y, Node x) {
        //uklanjanje cvora y iz liste korijena
        y.left.right = y.right;
        y.right.left = y.left;
        //
        Node c = x.child;
        if (c == null) {
            y.right = y;
            y.left = y;
        } else {
            y.right = c;
            y.left = c.left;
            c.left.right = y;
            c.left = y;
        }
        x.child = y;
        y.p = x;
        x.degree+= 1;
        y.mark = false;
    }

    public void display(){
        display(this.min);
    }
    private void display(Node x)
    {
        System.out.print("(");
        if(x==null)
        {
            System.out.print(")");
            return;
        }
        else
        {
            Node t = x;
            do
            {
                System.out.print(t.key);
                Node k = t.child;
                display(k);
                System.out.print("->");
                t = t.right;
            }while(t!=x);
            System.out.print(")");
        }
    }

    public void decreaseKey(Node<T> x, Integer k)
    {
        if(k.compareTo((Integer) x.key) > 0)
            return;
        x.key = (T) k;
        Node<T> y = x.p;
        if(y!=null && x.key.compareTo(y.key) < 0)
        {
            cut(x,y);
            cascadingCut(y);
        }
        if(x.key.compareTo(min.key) < 0)
            min = x;
    }

    public void cut(Node x, Node y)
    {
        if(x.p != y){
            System.out.println("\nČvor " + y + " nije roditelj čvora " + x + "! Odsjecanje se ne izvršava.");
            return;
        }
        //remove x from the child list of y, decrementing y:degree
        if(x.left == x && x.right == x){
            y.child = null;
        }
        else {
            if(y.child == x) //ako se gubi pokazivač na dijete
            y.child = x.right;
            x.left.right = x.right;
            x.right.left = x.left;
        }
        y.degree-=1;
        //add x to the root list of H
        x.right = null;
        x.left = null;
        x.p = null;
        x.mark = false;
        insertNode(x);
    }

    public void cascadingCut(Node y)
    {
        Node z = y.p;
        if(z!=null){

            if(y.mark==false)
                y.mark = true;
            else
            {
                cut(y,z);
                cascadingCut(z);
            }
        }
    }

    public void delete(Node x){
        decreaseKey(x,Integer.MIN_VALUE);
        extractMin();
    }
}
