package com.github.aneureka;

import com.github.aneureka.util.PrettyTable;

/**
 * @author hiki on 2018-02-02
 */

public class TabularStringifier {

    public static String stringify(Object o) {
        if (o instanceof Iterable<?>) {
           return stringifyIterable((Iterable<?>) o);
        }
        return stringifyDefault(o);
    }

    private static String stringifyIterable(Iterable<?> iterable) {
        return PrettyTable.fromIterable(iterable).toString();
    }

    private static String stringifyDefault(Object o) {
        return PrettyTable.fromObject(o).toString();
    }

}
