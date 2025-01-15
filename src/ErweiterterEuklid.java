import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class ErweiterterEuklid {

    public static void calc(int a, int b) {
        ArrayList<Iteration> iterationen = new ArrayList<Iteration>();
        // a ist größte Zahl
        boolean switched = false;
        if( b > a) {
            int temp = b;
            b = a;
            a = temp;
        }

        Iteration it = new Iteration();
        it.a = a;
        it.b = b;
        it.q = it.a/it.b;
        it.r = it.a%it.b;
        iterationen.add(it);
        while(it.r > 0) {
            Iteration prev = it;
            it = new Iteration();
            it.a = prev.b;
            it.b = prev.r;
            it.q = it.a/it.b;
            it.r = it.a%it.b;
            iterationen.add(it);
        }


        ListIterator<Iteration> iterator = iterationen.listIterator(iterationen.size());

        it=iterator.previous();
        it.x = 0;
        it.y = 1;
        while(iterator.hasPrevious()) {
            Iteration prev = it;
            it=iterator.previous();
            it.x = prev.y;
            it.y = prev.x - it.q*prev.y;
        }

        int i = 0;
        int ggt = -1;
        Iteration prev = null;
        System.out.printf("%-3s %10s %10s %10s %10s %10s %10s %n", 'i', 'a', 'b', 'q', 'r', 'x', 'y');

        for(Iteration iteration : iterationen) {

            System.out.printf("%-3d %10d %10d %10d %10d %10d %10d %n", ++i, iteration.a, iteration.b, iteration.q, iteration.r, iteration.x, iteration.y);
            if(prev == null) {
                ggt=iteration.b;
            }
            else if(iteration.r == 0) {
                ggt = prev.r;
            }
            prev = iteration;
        }

        System.out.println("ggT("+ iterationen.get(0).a+", " + iterationen.get(0).b+ ")="+ ggt);
        System.out.println("x: " + iterationen.get(0).x );
        System.out.println("y: " + iterationen.get(0).y );
        System.out.println("Prüfung: ggt = a*x+b*y => " +ggt+ " = " + (iterationen.get(0).a*iterationen.get(0).x+iterationen.get(0).b*iterationen.get(0).y));
    }
}
