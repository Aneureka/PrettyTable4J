package com.github.aneureka;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author hiki on 2018-02-02
 */
public class TabularStringifierTest {

    @Test
    public void stringify() {
        List<String> a = Arrays.asList("1", "22", "44");
        System.out.println(TabularStringifier.stringify(a));
    }
}

/*
OUTPUT:
+-------+-------+------+------------------+-----------------+-----+--------+-------+
| value | coder | hash | serialVersionUID | COMPACT_STRINGS | ... | LATIN1 | UTF16 |
+-------+-------+------+------------------+-----------------+-----+--------+-------+
| [B@78 | 0     | 0    | -684979447075466 | true            |     | 0      | 1     |
| 2663d |       |      | 7710             |                 |     |        |       |
| 3     |       |      |                  |                 |     |        |       |
+-------+-------+------+------------------+-----------------+-----+--------+-------+
| [B@45 | 0     | 0    | -684979447075466 | true            |     | 0      | 1     |
| 24411 |       |      | 7710             |                 |     |        |       |
| f     |       |      |                  |                 |     |        |       |
+-------+-------+------+------------------+-----------------+-----+--------+-------+
| [B@40 | 0     | 0    | -684979447075466 | true            |     | 0      | 1     |
| 1e780 |       |      | 7710             |                 |     |        |       |
| 3     |       |      |                  |                 |     |        |       |
+-------+-------+------+------------------+-----------------+-----+--------+-------+
*/