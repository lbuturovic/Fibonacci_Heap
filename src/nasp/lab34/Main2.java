package nasp.lab34;

public class Main2 {

    public static void main2(String[] args) {
        //testiranje insert metode
        FibHeap<Integer> heap1 = new FibHeap<Integer>();
        Node n1 = new Node(3);
        heap1.insertNode(n1);
        Node n2 = new Node(6);
        heap1.insertNode(n2);
        Node n3 = new Node(5);
        heap1.insertNode(n3);
        Node n4 = new Node(0);
        heap1.insertNode(n4);
        heap1.display();
        System.out.println("Broj cvorova: " + heap1.n);
        System.out.println("Minimalni element je: " + heap1.min.key);


        System.out.println("\nTestiranje Union metode (gomile nisu prazne: ");
        FibHeap<Integer> heap2 = new FibHeap<>();
        Node n5 = new Node(7);
        heap2.insertNode(n5);
        Node n6 = new Node (4);
        heap2.insertNode(n6);
        Node n7= new Node(9);
        heap2.insertNode(n7);

        FibHeap<Integer> newUnionHeap = FibHeap.union(heap1,heap2);
        newUnionHeap.display();
        System.out.println("Broj cvorova: " + newUnionHeap.n);
        System.out.println("Minimalni element je: " + newUnionHeap.min.key);


        System.out.println("\nTestiranje union metode kada je druga gomila prazna: ");
        FibHeap<Integer> heap3 = new FibHeap<>();
        FibHeap<Integer> newUnionHeap2 = FibHeap.union( newUnionHeap, heap3);
        newUnionHeap2.display();
        System.out.println("Broj cvorova: " + newUnionHeap2.n);
        System.out.println("Minimalni element je: " + newUnionHeap2.min.key);

        System.out.println("\nTestiranje union metode kada je prva gomila prazna: ");
        FibHeap<Integer> heap4 = new FibHeap<>();
        FibHeap<Integer> newUnionHeap3 = FibHeap.union(heap4, newUnionHeap2);
        newUnionHeap3.display();
        System.out.println("Broj cvorova: " + newUnionHeap3.n);
        System.out.println("Minimalni element je: " + newUnionHeap3.min.key);


        System.out.println("\nTestiranje union metode kada  gomile imaju po jedan element: ");
        FibHeap<Integer> heap6 = new FibHeap<>();
        Node n8 = new Node(1);
        heap6.insertNode(n8);
        FibHeap<Integer> heap7 = new FibHeap<>();
        Node n9 = new Node(2);
        heap7.insertNode(n9);
        FibHeap<Integer> newUnionHeap4 = FibHeap.union(heap6, heap7);
        newUnionHeap4.display();
        System.out.println("Broj cvorova: " + newUnionHeap4.n);
        System.out.println("Minimalni element je: " + newUnionHeap4.min.key);

        System.out.println("\nTestiranje extract min metode kada je gomila prazna: ");
        FibHeap<Integer> heap5 = new FibHeap<>();
        try {
            heap5.extractMin();
        } catch (Exception e) {
            System.out.println("Gomila je prazna!");
        }

        System.out.println("\nTestiranje extractMin metode: ");
        try {
            Node min = newUnionHeap3.extractMin();
            System.out.println("Minimalni element je: "+min.key);
            System.out.println("Broj cvorova je: " + newUnionHeap3.n);
            System.out.println("Novi minimalni element je: "+newUnionHeap3.min.key);
            newUnionHeap3.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nTestiranje extractMin metode: ");
        try {
            Node min = newUnionHeap3.extractMin();
            System.out.println("Minimalni element je: "+min.key);
            System.out.println("Broj cvorova je: " + newUnionHeap3.n);
            System.out.println("Novi minimalni element je: "+newUnionHeap3.min.key);
            newUnionHeap3.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nTestiranje extractMin metode: ");
        try {
            Node min = newUnionHeap3.extractMin();
            System.out.println("Minimalni element je: "+min.key);
            System.out.println("Broj cvorova je: " + newUnionHeap3.n);
            System.out.println("Novi minimalni element je: "+newUnionHeap3.min.key);
            newUnionHeap3.display();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\nTestiranje decreaseKey metode: ");
        Node n10 = new Node(11);
        try {
            newUnionHeap3.decreaseKey(n10,5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje decreaseKey metode: ");
        try {
            newUnionHeap3.decreaseKey(n2,9);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje decreaseKey metode: ");
        try {
            System.out.println("Minimalni element je: "+newUnionHeap3.min.key);
            newUnionHeap3.decreaseKey(n2,4);
            System.out.println("Novi minimalni element je: "+newUnionHeap3.min.key);
            System.out.println("Broj cvorova je: " + newUnionHeap3.n);
            newUnionHeap3.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje decreaseKey metode: ");
        try {
            System.out.println("Minimalni element je: "+newUnionHeap3.min.key);
            newUnionHeap3.decreaseKey(n7,1);
            System.out.println("Novi minimalni element je: "+newUnionHeap3.min.key);
            System.out.println("Broj cvorova je: " + newUnionHeap3.n);
            newUnionHeap3.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje decreaseKey metode (prazna gomila): ");
        try {
            Node x = new Node(-5);
            FibHeap<Integer> newFibHeap6 = new FibHeap<>();
            newFibHeap6.decreaseKey(x,-8);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje delete metode (prazna gomila) ");
        try {
            Node x = new Node(5);
            FibHeap<Integer> newFibHeap6 = new FibHeap<>();
            newFibHeap6.delete(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje delete metode (prazna gomila) ");
        try {
            Node x = new Node(0);
            newUnionHeap3.delete(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje delete metode: ");
        try {
            Node x = new Node(0);
            newUnionHeap3.delete(x);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nTestiranje delete metode: ");
        try {
            newUnionHeap3.delete(n5);
            newUnionHeap3.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }
}
