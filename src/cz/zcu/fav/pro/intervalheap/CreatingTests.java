package cz.zcu.fav.pro.intervalheap;

import cz.zcu.fav.pro.Constants;
import cz.zcu.fav.pro.OutputFormater;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Třída, která otestuje časy vytváření nových prioritních front
 */
@RunWith(Parameterized.class)
public class CreatingTests {

    @Parameterized.Parameters()
    public static Collection<Object[]> parameters() {
        return Constants.getParameters();
    }

    @Parameterized.Parameter()
    public int size;
    @Parameterized.Parameter(1)
    public int max;

    @Test
    public void creatingRandomValuesTest() throws Exception {
        IntervalHeap<Integer> heap = new IntervalHeap<>();

        long start = System.currentTimeMillis();
        new Random().ints(size, Constants.MIN_VALUE, max).forEach(heap::add);
        long end = System.currentTimeMillis();

        long delta = end - start;
        OutputFormater.format("Test vytvoření intervalové haldy náhodných prvků o velikosti: %8d, s maximálním prvkem: %8d a s časem: %dms%n", size, max, delta);
    }

    @Test
    public void creatingSameValuesTest() throws Exception {
        IntervalHeap<Integer> heap = new IntervalHeap<>();
        final int value = new Random().nextInt(max - 1);

        long start = System.currentTimeMillis();
        IntStream.generate(() -> value).limit(size).forEach(heap::add);
        long end = System.currentTimeMillis();

        long delta = end - start;
        OutputFormater.format("Test vytvoření intervalové haldy stejných prvků o velikosti: %8d, s maximálním prvkem: %8d a s časem: %dms%n", size, value, delta);

    }

}
