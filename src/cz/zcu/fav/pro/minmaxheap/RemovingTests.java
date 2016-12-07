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
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size).create();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);

        long start = System.nanoTime();
        Integer min = heap.pollFirst();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Odebrání nejmenšího prvku: %8d z haldy o velikosti: %8d v čase: %dns%n", min, size, delta);
    }

    @Test
    public void removeMaxValueTest() throws Exception {
        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size).create();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);

        long start = System.nanoTime();
        Integer max = heap.pollLast();
        long end = System.nanoTime();
        long delta = end - start;

        OutputFormater.format("Odebrání největšího prvku: %8d z haldy o velikosti: %8d v čase: %dns%n", max, size, delta);
    }

//    @Test
//    public void removeAverageValueTest() throws Exception {
//        MinMaxPriorityQueue<Integer> heap = MinMaxPriorityQueue.expectedSize(size).create();
//        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);
//        int average = max / 2;
//
//        long start = System.nanoTime();
//        heap.remove(average);
//        long end = System.nanoTime();
//        long delta = end - start;
//
//        OutputFormater.format("Odebrání průměrného prvku: %8d z haldy o velikosti: %8d v čase: %dns%n", average, size, delta);
//    }
}
