package cn.aneureka.prettytable;

import cn.aneureka.prettytable.exception.FieldsNotSetException;
import cn.aneureka.prettytable.exception.RowSizeMismatchException;
import cn.aneureka.prettytable.util.ClassFieldsResolver;
import cn.aneureka.prettytable.util.PrettyTable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author hiki on 2018-02-02
 */

public class ObjectTabularPrinter {

    public static void print(Object o) {
        Map<String, String> fields = ClassFieldsResolver.getFields(o);
        List<String> fieldNames = new ArrayList<>(fields.keySet());
        List<String> fieldValues = new ArrayList<>(fields.values());
        // construct the table
        PrettyTable table = new PrettyTable(fieldNames);
        try {
            table.addRow(fieldValues);
        } catch (FieldsNotSetException | RowSizeMismatchException e) {
            System.err.println(e.getMessage());
        }
        table.print();
    }

}
