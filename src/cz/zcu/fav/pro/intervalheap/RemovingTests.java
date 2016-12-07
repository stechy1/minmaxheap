package cz.zcu.fav.pro.intervalheap;

import cz.zcu.fav.pro.Constants;
import cz.zcu.fav.pro.OutputFormater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Random;

/**
 * Třída, která otestuje časy potřebné k odstranění prvku
 */
@RunWith(Parameterized.class)
public class RemovingTests {

    @Parameterized.Parameters()
    public static Collection<Object[]> mediaTypes() {
        return Constants.getParameters();
    }

    @Parameterized.Parameter()
    public int size;
    @Parameterized.Parameter(1)
    public int max;

    @Test
    public void removeMinValueTest() throws Exception {
        IntervalHeap<Integer> heap = new IntervalHeap<>();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);

        long start = System.nanoTime();
        Integer min = heap.dequeueMin();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Odebrání nejmenšího prvku: %8d z intervalové haldy o velikosti: %8d v čase: %dns%n", min, size, delta);
    }

    @Test
    public void removeMaxValueTest() throws Exception {
        IntervalHeap<Integer> heap = new IntervalHeap<>();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);

        long start = System.nanoTime();
        Integer max = heap.dequeueMax();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Odebrání největšího prvku: %8d z intervalové haldy o velikosti: %8d v čase: %dns%n", max, size, delta);
    }
}
