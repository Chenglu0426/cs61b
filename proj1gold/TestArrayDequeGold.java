import static  org.junit.Assert.*;
import org.junit.Test;
public class TestArrayDequeGold {
    @Test
    public void teststudent() {
        StudentArrayDeque<Integer> testarray = new StudentArrayDeque<>();
        ArrayDequeSolution<Integer> targetarray = new ArrayDequeSolution<>();
        String log = "";
        for (int i = 0; i < 1000; i++) {
            if (testarray.size() == 0) {
                int num = StdRandom.uniform(1000);
                testarray.addFirst(num);
                targetarray.addFirst(num);
                log += "addFirst(" + num + ")\n";
            } else {
                int x = StdRandom.uniform(4);
                int num = StdRandom.uniform(1000);
                int testremovenumber = -1;
                int targetremovenumber = -1;
                switch(x) {
                    case 0:
                        log += "addFirst(" + num + ")\n";
                        testarray.addFirst(num);
                        targetarray.addFirst(num);
                        break;
                    case 1:
                        log += "addLast(" + num + ")\n";
                        testarray.addLast(num);
                        targetarray.addLast(num);
                        break;
                    case 2:
                        log += "removeFirst()\n";
                        testremovenumber = testarray.removeFirst();
                        targetremovenumber = targetarray.removeFirst();
                    case 3:
                        log += "removeLast()\n";
                        testremovenumber = testarray.removeLast();
                        targetremovenumber = targetarray.removeLast();
                    default:
                }
                assertEquals(log, targetremovenumber, testremovenumber);
            }
        }
    }
}
