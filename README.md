# PrettyTable4J

## Feature

- Print your [Object/Iterable fields] in an elegant way

## How to use

```xml
<dependency>
    <groupId>com.github.aneureka</groupId>
    <artifactId>PrettyTable4J</artifactId>
    <version>0.0.2</version>
</dependency>
```

## For example

```java
@Test
public void print() {
    List<String> a = Arrays.asList("a", "b", "c");
    System.out.println(TabularStringifier.stringify(a));
    // or you can simply do [TabularStringifier.stringify("a")] to deal with an object
}

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
   
```

