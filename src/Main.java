import models.Reader;
import models.ResourcesAccessManager;
import models.Writer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> resource = new ArrayList<Integer>();
        ResourcesAccessManager manager = new ResourcesAccessManager();

        Writer w1 = new Writer(manager, 1, resource);
        Writer w2 = new Writer(manager, 2, resource);

        Reader r1 = new Reader(manager, 1, resource);
        Reader r2 = new Reader(manager, 2, resource);
        Reader r3 = new Reader(manager, 3, resource);

        w1.start();
        w2.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        r1.start();
        r2.start();
        r3.start();

        try {
            w1.join();
            w2.join();
            r1.join();
            r2.join();
            r3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}