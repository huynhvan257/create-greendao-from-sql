package com.example;

import java.util.ArrayList;

/**
 * Created by van on 10/13/15.
 */
public class TableStructure {
    private String tableName;
    private ArrayList<Column> columns;

    public TableStructure() {
        columns = new ArrayList<Column>();
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public ArrayList<Column> getColumns() {
        return columns;
    }

    public void setColumns(ArrayList<Column> columns) {
        this.columns = columns;
    }

    public static TableStructure parser(String commandString) {

        TableStructure tableStructure = null;
        if (commandString.startsWith("CREATE TABLE")) {
            String[] splits = commandString.split("\\(");
            if (splits.length >= 2) {

                String split = splits[0].trim();
                String[] splitTableName = split.split("`");
                if (splitTableName.length > 0) {
                    String tableName = splitTableName[splitTableName.length - 1];
                    tableStructure = new TableStructure();
                    tableStructure.setTableName(tableName);

                    //
                    split = commandString.replaceFirst(splits[0], "");

                    //
                    splits = split.split(",");
                    for (String slitColumn : splits) {
                        slitColumn = slitColumn.replace("(", "");
                        slitColumn = slitColumn.trim();
                        String firstChar = slitColumn.substring(0, 1);
                        if (firstChar.equals("`")) {
                            String[] sColumn = slitColumn.split("`");
                            if (sColumn.length > 2) {
                                Column column = new Column();
                                column.setColumnName(sColumn[1]);
                                String dataType = sColumn[2];
                                column.parser(dataType);
                                tableStructure.getColumns().add(column);
                            }
                        }
                    }
                }
            }
        }

        return tableStructure;
    }

    public String functionName() {
        return "addNote" + tableName + "(schema);";
    }

    public String createFunction() {
        String result = "\n private static void addNote" + tableName + "(Schema schema){\n" +
                "\t Entity note = schema.addEntity(\"" + capitalize(tableName) + "\");\n";

        for (Column column : columns) {

            String sColumn = column.createNote();
            if (!TextUtils.isEmpty(sColumn)) {
                result += "\n\t " + "note." + sColumn;
            }
        }

        result += "\n}";
        return result;
    }

    public static String capitalize(String name) {
        if (name != null && name.length() != 0) {
            char[] chars = name.toCharArray();
            chars[0] = Character.toUpperCase(chars[0]);
            return new String(chars);
        } else {
            return name;
        }
    }
}
