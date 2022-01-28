package nasp.lab34;
import nasp.lab34.TestFib;

import java.util.List;

/*Razviti generičku klasu FIB-HEAP, koja će implementirati metode za sljedeće operacije u
        radu sa Fibonaccijevom gomilom:
         FIB-HEAP-INSERT (CLRS, strana 510)
         FIB-HEAP-UNION (CLRS, strana 512)
         FIB-HEAP-EXTRACT-MIN (CLRS, strana 513)
         CONSOLIDATE (CLRS, strana 516)
         FIB-HEAP-LINK (CLRS, strana 516)*/
public class Main {

    public static void main(String[] args) {
        //insert
        TestFib.testInsertEmptyHeap();
        TestFib.testInsert();
        //union
        TestFib.testUnionEmpty();
        TestFib.testUnion1();
        //fib heap link
        TestFib.testFibHeapLink();
        TestFib.testFibHeapLink2();
        //extract min
        TestFib.testExtractMin1();
        TestFib.testExtractMinEmpty();
        TestFib.testExtractMin2();
        //cut
        TestFib.testCut1();
        TestFib.testCut2();
        TestFib.testCut3();
        TestFib.testCut4();
        //decrease key
        TestFib.testDecreaseKey1();
        TestFib.testDecreaseKey2();
        TestFib.testDecreaseKey3();
        //delete
        TestFib.testDelete1();
        TestFib.testDelete2();
        TestFib.testDelete3();
        //consolidate je testirana kroz testove za metodu extractMin, a cascading cut kroz testove za metodu decrease key i delete

    }
}
