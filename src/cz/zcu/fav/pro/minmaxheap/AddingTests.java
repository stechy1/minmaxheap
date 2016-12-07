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
 * Třída, která otestuje časy potřebné k přidání nového prvku
 */
@RunWith(Parameterized.class)
public class AddingTests {

    @Parameterized.Parameters()
    public static Collection<Object[]> mediaTypes() {
        return Constants.getParameters();
    }

    @Parameterized.Parameter()
    public int size;
    @Parameterized.Parameter(1)
    public int max;

    @Test
    public void addMinValueTest() throws Exception {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size+1).create();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);

        long start = System.nanoTime();
        heap.add(Constants.MIN_VALUE);
        long end = System.nanoTime();
        long delta = end - start;
        OutputFormater.format("Přidání nejmenšího prvku: %8d do haldy o velikosti: %8d v čase: %dns%n", Constants.MIN_VALUE, size, delta);
    }

    @Test
    public void addMaxValueTest() throws Exception {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size+1).create();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);

        long start = System.nanoTime();
        heap.add(max);
        long end = System.nanoTime();
        long delta = end - start;
        OutputFormater.format("Přidání největšího prvku: %8d do haldy o velikosti: %8d v čase: %dns%n", max, size, delta);
    }

    @Test
    public void addAverageValueTest() throws Exception {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size+1).create();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);
        int average = max / 2;

        long start = System.nanoTime();
        heap.add(average);
        long end = System.nanoTime();
        long delta = end - start;
        OutputFormater.format("Přidání průměrného prvku: %8d do haldy o velikosti: %8d v čase: %dns%n", average, size, delta);
    }

}
