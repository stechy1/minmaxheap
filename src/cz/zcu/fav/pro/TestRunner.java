package cz.zcu.fav.pro;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Spouštěcí třída testů
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        cz.zcu.fav.pro.minmaxheap.TestRunner.class,
        cz.zcu.fav.pro.intervalheap.TestRunner.class
})
public class TestRunner {}
