package cz.zcu.fav.pro.minmaxheap;

import com.google.common.collect.MinMaxPriorityQueue;
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
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size).create();
        new Random().ints(size, Constants.MIN_VALUE, max+1).forEach(heap::add);

        long start = System.nanoTime();
        int minValue = heap.peekFirst();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Nalezení nejmenšího prvku: %8d v haldě o velikosti: %8d v čase: %dns%n", minValue, size, delta);
    }

    @Test
    public void findMaxValueTest() throws Exception {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size).create();
        new Random().ints(size, Constants.MIN_VALUE, max+1).forEach(heap::add);

        long start = System.nanoTime();
        int maxValue = heap.peekLast();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Nalezení největšího prvku: %8d v haldě o velikosti: %8d v čase: %dns%n", maxValue, size, delta);
    }

    @Test
    public void findAverageValueTest() throws Exception {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size).create();
        new Random().ints(size, Constants.MIN_VALUE, max+1).forEach(heap::add);
        int averageValue = max / 2;

        long start = System.nanoTime();
        boolean contains = heap.contains(averageValue);
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Nalezení průměrného prvku: %8d v haldě o velikosti: %8d v čase: %dns%n", averageValue, size, delta);
    }
}
