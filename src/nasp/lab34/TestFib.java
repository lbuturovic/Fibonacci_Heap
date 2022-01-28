package nasp.lab34;
import nasp.lab34.FibHeap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class TestFib {
    private static FibHeap<Integer> h1 = new FibHeap<>();
    private static FibHeap<Integer> h2 = new FibHeap<>();
    private static List<Integer> keys1 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1,0));
    private static List<Integer> keys2 = new ArrayList<>(Arrays.asList(14,3,28,16,65,34,93,22,61,40,76,32,43,98,45,32,54,67,58,94,33,65,23,34,76,34,23,12,94,5,18,44,36,34));

    public TestFib(){
        h1 = new FibHeap<>();
       /* h2 = new FibHeap<>();
        h3 = new FibHeap<>();
        h4 = new FibHeap<>();
        keys1 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1,0));*/
    }
    private static void  reset(){
        h1 = new FibHeap<>();
        h2 = new FibHeap<>();
        keys1 = new ArrayList<>(Arrays.asList(9,8,7,6,5,4,3,2,1,0));
        keys2 = new ArrayList<>(Arrays.asList(14,3,28,16,65,34,93,22,61,40,76,32,43,98,45,32,54,67,58,94,33,65,23,34,76,34,23,12,94,5,18,44,36,34));
    }
    public static void testInsertEmptyHeap(){
        System.out.println("\n*** Test Insert u praznu gomilu ***");
        h1.insert(7);
        System.out.println("Gomila nakon unosa ključa 7:");
        h1.display();
        System.out.println("\n Atributi unesenog čvora su: roditelj: " + h1.min.p + ", lijevi brat: " + h1.min.left.key + ", desni brat: " + h1.min.right.key +
                ", dijete: " + h1.min.child + ", oznaka: " + h1.min.mark);
        reset();
    }
    public static void testInsert(){
        System.out.println("\n*** Test Insert ***");
        System.out.print("Gomila h1 prije unosa elemenata: ");
        h1.display();
        System.out.println("\nUnose se elementi: 9,8,7,6,5,4,3,2,1,0");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        System.out.print("Gomila h1 nakon unosa elemenata: ");
        h1.display();
        System.out.println("\nBroj elemenata u gomili h1 je " + h1.getN());
        if(h1.getN() == 10 && h1.min.key.compareTo(0) == 0) System.out.println("Test uspješan\n");
        else System.out.println("Test neuspješan\n");
        System.out.print("Gomila h2 prije unosa elemenata: ");
        h2.display();
        System.out.println("\nUnose se elementi: 14,3,28,16,65,34,93,22,61,40,76,32,43,98,45,32,54,67,58,94,33,65,23,34,76,34,23,12,94,5,18,44,36,34");
        for (Integer key: keys2) {
            h2.insert(key);
        }
        System.out.print("Gomila h2 nakon unosa elemenata: ");
        h2.display();
        System.out.println("\nBroj elemenata u gomili h2 je " + h2.getN());
        if(h2.getN() == 34 && h2.min.key.compareTo(3) == 0) System.out.println("Test uspješan\n");
        else System.out.println("Test neuspješan\n");
        List<FibHeap> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        reset();

    }

    public static void testUnionEmpty(){
        System.out.println("\n*** Test Union Empty ***");
        System.out.println("Gomila h1 prije spajanja: " + "(broj elemenata: " + h1.getN() + ")");
        h1.display();
        System.out.println("\nGomila h2 prije spajanja: " + "(broj elemenata: " + h2.getN() + ")");
        h2.display();
        FibHeap h = FibHeap.union(h1,h2);
        System.out.println("\nNovoformirana gomila: "+ "(broj elemenata: " + h.getN() + ")");
        h.display();
        if(h.getN() == h1.getN() + h2.getN()) System.out.println("\nTest uspješan");
        reset();
    }

    public static void testUnion1(){
        System.out.println("\n*** Test Union ***");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        for (Integer key: keys1) {
            h1.insert(key);
        }
        System.out.println("Gomila h1 prije spajanja: " + "(broj elemenata: " + h1.getN() + ")");
        h1.display();
        System.out.println("\nGomila h2 prije spajanja: " + "(broj elemenata: " + h2.getN() + ")");
        h2.display();
        FibHeap h = FibHeap.union(h1,h2);
        System.out.println("\nNovoformirana gomila: "+ "(broj elemenata: " + h.getN() + ")");
        h.display();
        if(h.getN() == h1.getN() + h2.getN() && h.min.key.compareTo(0) == 0) System.out.println("\nTest uspješan");
        reset();
    }

    public static void testExtractMinEmpty(){
        System.out.println("\n*** Test Extract Min Empty ***");
        System.out.println("H1 prije izbacivanja min:");
        h1.display();
        h1.extractMin();
        System.out.println("\n H1 nakon izbacivanja min:");
        h1.display();
        System.out.println();
        reset();
    }

    public static void testFibHeapLink(){
        System.out.println("\n*** Test Fib Heap Link 1 ***");
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(2);
        n2.child = n3;
        n3.p = n2;
        System.out.println("Neka imamo čvor 5 čije je dijete čvor 2 i čvor 1 koji nema djece, vršimo poziv FibHeapLink(1,5):");
        FibHeap.FibHeapLink(n1,n2);
        System.out.println("Čvor " + n2.key + " ima dijete " + n2.child.key + " njegovo dijete ima roditelja " + n2.child.p.key + " i brata " + n2.child.right.key + " a brat ima brata " +  n2.child.right.left.key );

    }

    public static void testFibHeapLink2(){
        System.out.println("\n*** Test Fib Heap Link 2 ***");
        Node<Integer> n1 = new Node<>(1);
        Node<Integer> n2 = new Node<>(5);
        Node<Integer> n3 = new Node<>(2);
        n2.child = n3;
        n3.p = n2;
        System.out.println("Neka imamo čvor 5 čije je dijete čvor 2 i čvor 1 koji nema djece, vršimo poziv FibHeapLink(5,1):");
        FibHeap.FibHeapLink(n2,n1);
        System.out.println("Čvor " + n2.key + " ima dijete " + n2.child.key + " njegovo dijete ima roditelja " + n2.child.p.key + " i brata " + n2.child.right.key);

    }

    public static void testExtractMin1(){
        System.out.println("\n*** Test Extract Min ***");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        for (Integer key: keys2) {
            h2.insert(key);
        }
        System.out.println("H1 prije izbacivanja min:");
        h1.display();
        h1.extractMin();
        System.out.println("\n H1 nakon izbacivanja min:");
        h1.display();
        System.out.println("\nH2 prije izbacivanja min:");
        h2.display();
        h2.extractMin();
        System.out.println("\n H2 nakon izbacivanja min:");
        h2.display();
        System.out.println();
        reset();
    }

    public static void testExtractMin2(){
        System.out.println("\n*** Test Extract Min dva puta ***");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        for (Integer key: keys2) {
            h2.insert(key);
        }
        System.out.println("H1 prije izbacivanja min:");
        h1.display();
        h1.extractMin();
        System.out.println("\n H1 nakon izbacivanja min:");
        h1.display();
        System.out.println("\nMin je " + h1.min.key + ", roditelj: " + h1.min.p + ", lijevi brat: " + h1.min.left.key + ", desni brat: " + h1.min.right.key +
        ", dijete: " + h1.min.child.key + ", oznaka: " + h1.min.mark);
        System.out.println("H1 nakon ponovnog izbacivanja min:");
        //System.out.println(h1.min.child.child.child.right.right.key);
        h1.extractMin();
        h1.display();
        //if (h1.min.key == 2) System.out.println("\nTest uspješan");
        reset();
        System.out.println();
    }

    public static void testCut1 (){
        System.out.println("\n*** Test Cut 1 ***");
        System.out.println("Primjer u kojem roditeljski čvor ima više djece i briše se dijete na kojeg roditelj ima pokazivač");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije odvajanja elementa " + h1.min.child.child + ":");
        h1.display();
        System.out.println("\nH1 nakon odvajanja elementa " + h1.min.child.child + ":");
        h1.cut(h1.min.child.child, h1.min.child);
        h1.display();
        reset();
        System.out.println();
    }

    public static void testCut2 (){
        System.out.println("\n*** Test Cut 2 ***");
        System.out.println("Primjer u kojem roditeljski čvor nakon odsjecanja ostaje bez djece");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije odvajanja elementa " + h1.min.child.right.child + " od roditelja " + h1.min.child.right + ":");
        h1.display();
        System.out.println("\nH1 nakon odvajanja elementa " + h1.min.child.right.child +  " od roditelja " + h1.min.child.right + ":");
        h1.cut(h1.min.child.right.child, h1.min.child.right);
        h1.display();
        reset();
        System.out.println();
    }

    public static void testCut3 (){
        System.out.println("\n*** Test Cut 3 ***");
        System.out.println("Primjer u kojem čvorovi nisu u relaciji dijete - roditelj");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije odvajanja elementa " + h1.min.child.right.child + " od " + h1.min.child + ":");
        h1.display();
        System.out.println("\nH1 nakon odvajanja elementa " + h1.min.child.right.child +  " od  " + h1.min.child + ":");
        h1.cut(h1.min.child.right.child, h1.min.child);
        h1.display();
        reset();
        System.out.println();

    }

    public static void testCut4 (){
        System.out.println("\n*** Test Cut 4 ***");
        System.out.println("Primjer u kojem roditeljski čvor ima više djece i briše se dijete na kojeg roditelj nema pokazivač");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije odvajanja elementa " + h1.min.child.child.right + ":");
        h1.display();
        System.out.println("\nH1 nakon odvajanja elementa " + h1.min.child.child.right + ":");
        h1.cut(h1.min.child.child.right, h1.min.child);
        h1.display();
        reset();
        System.out.println();
    }

    public static void testDecreaseKey1(){
        System.out.println("\n*** Test Decrease Key 1 ***");
        System.out.println("Neka se čvor sa ključem 7 smanjuje na 6 (roditelj je i dalje manji)");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije smanjenja elementa " + h1.min.child.child + ":");
        h1.display();
        System.out.println("\n H1 nakon smanjenja elementa " + h1.min.child.child + ":");
        h1.decreaseKey(h1.min.child.child, 6);
        h1.display();
        reset();
        System.out.println();
    }

    public static void testDecreaseKey2(){
        System.out.println("\n*** Test Decrease Key 2 ***");
        System.out.println("Neka se čvor sa ključem 7 smanjuje na 1 (roditelj je veći)");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije smanjenja elementa " + h1.min.child.child + ":");
        h1.display();
        System.out.println("\n H1 nakon smanjenja elementa " + h1.min.child.child + ":");
        h1.decreaseKey(h1.min.child.child, 1);
        h1.display();
        reset();
        System.out.println();
    }

    public static void testDecreaseKey3(){
        System.out.println("\n*** Test Decrease Key 3 ***");
        System.out.println("Neka se čvor sa ključem 7 smanjuje na 1 (roditelj je veći), a nakon toga i preostali brat 6 na 2");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        Node<Integer> oldMin = new Node<>();
        oldMin = h1.min;
        System.out.println("H1 prije smanjenja elementa " + h1.min.child.child + ":");
        h1.display();
        System.out.println("\n H1 nakon smanjenja elementa " + h1.min.child.child + ":");
        h1.decreaseKey(h1.min.child.child, 1);
        h1.display();
        System.out.println("H1 prije smanjenja elementa " + oldMin.child.child + ":");
        h1.display();
        System.out.println("\n H1 nakon smanjenja elementa " + oldMin.child.child + ":");
        h1.decreaseKey(oldMin.child.child, 2);
        System.out.println("Sada bi element 5 trebao biti korijenski cvor zbog metode cascadeCut");
        h1.display();
        reset();
        System.out.println();
    }

    public static void testDelete1(){
        System.out.println("\n*** Test Delete 1 ***");
        System.out.println("Brisanje djeteta korijenskog čvora na kojeg čvor pokazuje ");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije brisanja elementa " + h1.min.child + ":");
        h1.display();
        System.out.println("H1 nakon brisanja elementa " + h1.min.child + ":");
        h1.delete(h1.min.child);
        h1.display();
        reset();
        System.out.println();

    }

    public static void testDelete2(){
        System.out.println("\n*** Test Delete 2 ***");
        System.out.println("Brisanje djeteta čvora 5 na kojeg čvor ne pokazuje, koji je ujedno i list ");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije brisanja elementa " + h1.min.child.child.right + ":");
        h1.display();
        System.out.println("\nH1 nakon brisanja elementa " + h1.min.child.child.right + ":");
        h1.delete(h1.min.child.child.right);
        h1.display();
        reset();
        System.out.println();
    }

    public static void testDelete3(){
        System.out.println("\n*** Test Delete 3 ***");
        System.out.println("Brisanje drugog djeteta čvora 5 koji ima djecu (poziva se cascade)");
        for (Integer key: keys1) {
            h1.insert(key);
        }
        h1.extractMin();
        h1.extractMin();
        System.out.println("H1 prije brisanja prvog djeteta " + h1.min.child.child.right + ":");
        h1.display();
        System.out.println("\nH1 nakon brisanja prvog djeteta " + h1.min.child.child.right + ":");
        h1.delete(h1.min.child.child.right);
        h1.display();
        System.out.println("\nH1 nakon decreaseKey drugog djeteta " + h1.min.child.child + ":");
        h1.decreaseKey(h1.min.child.child, Integer.MIN_VALUE);
        h1.display();
        System.out.println();
        h1.extractMin();
        h1.display();
        reset();
        System.out.println();
    }
}
