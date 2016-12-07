package cz.zcu.fav.pro.minmaxheap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Spouštěcí třída testů třídy {@link com.google.common.collect.MinMaxPriorityQueue}
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreatingTests.class,
        AddingTests.class,
        FindingTests.class,
        RemovingTests.class
})
public class TestRunner {}
