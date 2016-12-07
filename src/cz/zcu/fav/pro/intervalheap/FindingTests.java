package cz.zcu.fav.pro.intervalheap;

import cz.zcu.fav.pro.Constants;
import cz.zcu.fav.pro.OutputFormater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Random;

/**
 * Třída, která otestuje časy potřebné k vyhledání prvků
 */
@RunWith(Parameterized.class)
public class FindingTests {

    @Parameterized.Parameters()
    public static Collection<Object[]> mediaTypes() {
        return Constants.getParameters();
    }

    @Parameterized.Parameter()
    public int size;
    @Parameterized.Parameter(1)
    public int max;

    @Test
    public void findMinValueTest() throws Exception {
        IntervalHeap<Integer> heap = new IntervalHeap<>();
        new Random().ints(size, Constants.MIN_VALUE, max+1).forEach(heap::add);

        long start = System.nanoTime();
        int minValue = heap.min();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Nalezení nejmenšího prvku: %8d v intervalové haldě o velikosti: %8d v čase: %dns%n", minValue, size, delta);
    }

    @Test
    public void findMaxValueTest() throws Exception {
        IntervalHeap<Integer> heap = new IntervalHeap<>();
        new Random().ints(size, Constants.MIN_VALUE, max+1).forEach(heap::add);

        long start = System.nanoTime();
        int maxValue = heap.max();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Nalezení největšího prvku: %8d v intervalové haldě o velikosti: %8d v čase: %dns%n", maxValue, size, delta);
    }

}
