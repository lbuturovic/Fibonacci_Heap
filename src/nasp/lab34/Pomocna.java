package nasp.lab34;

public class Pomocna {
    public static void pomocna(String[] args) {
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
