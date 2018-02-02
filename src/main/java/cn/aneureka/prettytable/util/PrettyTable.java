package cn.aneureka.prettytable.util;

import cn.aneureka.prettytable.exception.FieldsNotSetException;
import cn.aneureka.prettytable.exception.RowSizeMismatchException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hiki on 2018-02-02
 */

public class PrettyTable {

    /**
     * printing configuration
     */
    private static final int L_PAD = 1;
    private static final int R_PAD = 1;

    private static final char INTERSECTION_SYMBOL = '+';
    private static final char HORIZONTAL_SYMBOL = '-';
    private static final char VERTICAL_SYMBOL = '|';
    private static final char BLANK_SYMBOL = ' ';

    /**
     * data
     */
    private String title;
    private List<String> fields;
    private List<List<String>> rows;

    public PrettyTable(List<String> fields) {
        this.rows = new ArrayList<>();
        this.fields = fields;
    }

    public void addRow(List<String> row) throws FieldsNotSetException, RowSizeMismatchException {
        // check the fields and row
        if (fields.isEmpty()) {
            throw new FieldsNotSetException();
        }
        if (row == null || fields.size() != row.size()) {
            throw new RowSizeMismatchException();
        }
        rows.add(row);
    }


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(getDefaultLine())
                .append(getFieldLine())
                .append(getDefaultLine());
        for (List<String> row : rows) {
            builder.append(getRowLine(row));
            builder.append(getDefaultLine());
        }

        return builder.toString();
    }

    public void print() {
        System.out.println(toString());
    }

    private String getDefaultLine() {
        StringBuilder builder = new StringBuilder();
        List<Integer> columnSizes = fields.stream().map(e -> e.length()+L_PAD+R_PAD).collect(Collectors.toList());
        for (int size : columnSizes) {
            builder.append(INTERSECTION_SYMBOL).append(getRepetitiveSymbols(HORIZONTAL_SYMBOL, size));
        }
        builder.append(INTERSECTION_SYMBOL).append("\n");
        return builder.toString();
    }

    private String getFieldLine() {
        StringBuilder builder = new StringBuilder();
        for (String field : fields) {
            builder.append(VERTICAL_SYMBOL)
                    .append(getRepetitiveSymbols(BLANK_SYMBOL, L_PAD))
                    .append(field)
                    .append(getRepetitiveSymbols(BLANK_SYMBOL, R_PAD));
        }
        builder.append(VERTICAL_SYMBOL).append("\n");
        return builder.toString();
    }

    private String getRowLine(List<String> row) {

        List<List<String>> splitRows = splitRow(row);

        StringBuilder builder = new StringBuilder();
        for (List<String> splitRow : splitRows) {
            System.out.println();
            for (String item : splitRow) {
                builder.append(VERTICAL_SYMBOL)
                        .append(getRepetitiveSymbols(BLANK_SYMBOL, L_PAD))
                        .append(item)
                        .append(getRepetitiveSymbols(BLANK_SYMBOL, R_PAD));
            }
            builder.append(VERTICAL_SYMBOL).append("\n");
        }

        return builder.toString();
    }
    
    private List<List<String>> splitRow(final List<String> r) {
        // compare with the field size
        List<String> row = new ArrayList<>(r);
        List<Integer> fieldSizes = fields.stream().map(String::length).collect(Collectors.toList());
        List<List<String>> splitRows = new ArrayList<>();

        boolean rest = true;
        while (rest) {
            rest = false;
            List<String> tempSplitRow = new ArrayList<>();

            for (int i = 0; i < row.size(); i++) {
                String item = row.get(i);
                int length = item.length();
                int cmpLength = fieldSizes.get(i);

                if (length > cmpLength) {
                    rest = true;
                    tempSplitRow.add(item.substring(0, cmpLength));
                    row.set(i, item.substring(cmpLength));
                }
                else {
                    tempSplitRow.add(item + getRepetitiveSymbols(BLANK_SYMBOL, fieldSizes.get(i)-length));
                    row.set(i, "");
                }
            }

            splitRows.add(tempSplitRow);

        }

        return splitRows;

    }

    private String getRepetitiveSymbols(char symbol, int time) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < time; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }

}
