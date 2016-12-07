package cz.zcu.fav.pro;

import java.util.Arrays;
import java.util.Collection;

/**
 * Pomocné konstanty ke spuštění testů
 */
public final class Constants {

    private Constants() {throw new UnsupportedOperationException();}

    public static Collection<Object[]> getParameters() {
        return Arrays.asList(new Object[][]{
                // Velikost haldy, maximální prvek
                {100, 100},
                {100, 1000},
                {100, 10000},
                {1000, 100},
                {1000, 1000},
                {1000, 10000},
                {10000, 100},
                {10000, 1000},
                {10000, 10000},
                {100000, 100},
                {100000, 1000},
                {100000, 10000},
                {1000000, 100},
                {1000000, 1000},
                {1000000, 10000},
                {10000000, 100},
                {10000000, 1000},
                {10000000, 10000},
        });
    }

    public static final int MIN_VALUE = 0;

}
