package cz.zcu.fav.pro.intervalheap;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Spouštěcí třída testů pro třídu {@link IntervalHeap}
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CreatingTests.class,
        AddingTests.class,
        FindingTests.class,
        RemovingTests.class
})
public class TestRunner {
}
