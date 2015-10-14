package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by van on 10/13/15.
 */
public class ScriptReader {
    private static final String DEFAULT_DELIMITER = ";";

    private String delimiter = DEFAULT_DELIMITER;
    private boolean fullLineDelimiter = false;

    /**
     * Default constructor
     */
    public ScriptReader() {
    }

    /**
     * This method is used create class GreenDao generator from file SQL (export from mysql, MySQLWorkbench ...)
     *
     * @param pathFile - path of file SQL
     * @param dbName - Database name
     * @param folderSource - folder of source when generation
     * @param packageClass - Package of class
     * @param className - class name of file generation
     * @param pathFileClass - path of file generation
     * @return
     */
    public String generationClass(String pathFile, String dbName, String folderSource, String packageClass, String className, String pathFileClass) {

        String packageName = "package " + packageClass  + ";\n\n";
        String importFile = "\n" +
                "import de.greenrobot.daogenerator.DaoGenerator;\n" +
                "import de.greenrobot.daogenerator.Entity;\n" +
                "import de.greenrobot.daogenerator.Property;\n" +
                "import de.greenrobot.daogenerator.Schema;\n" +
                "import de.greenrobot.daogenerator.ToMany;\n\n";
        String createClass = "public class " + className +" {\n\n";

        String string = "public static void main(String[] args) throws Exception {" +
                "\n" +
                "\tSchema schema = new Schema(1000, \"" + dbName + "\");" +
                "\n\n" +
                "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(pathFile));

            ArrayList<TableStructure> tableStructures = generationClass(in);
            String allFuncClass = "";
            String funcName = "";
            for (TableStructure tableStructure : tableStructures) {
                funcName +=  "\n\t" + tableStructure.functionName();
                allFuncClass += tableStructure.createFunction();
            }
            string += funcName +
                    "\n\tnew DaoGenerator().generateAll(schema, \"" + folderSource + "\");" +
                    "\n}" +
                    "\n\n";
            string += allFuncClass;
            System.out.println(string);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String result = packageName +  importFile + createClass + string + "\n}";
        File file = new File(pathFileClass, className + ".java");
        Writer writer = null;
        try {
            writer = new FileWriter(file);
            try {
                writer.write(result);
                System.out.println("Written " + file.getCanonicalPath());
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                writer.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Runs an SQL script (read in using the Reader parameter) using the
     * connection passed in
     *
     * @param reader - the source of the script
     * @throws SQLException if any SQL errors occur
     * @throws IOException  if there is an error reading from the Reader
     */
    private ArrayList<TableStructure> generationClass(Reader reader) throws IOException,
            SQLException {
        StringBuffer command = null;
        LineNumberReader lineReader = new LineNumberReader(reader);
        String line = null;
        ArrayList<TableStructure> tableStructures = new ArrayList<TableStructure>();
        while ((line = lineReader.readLine()) != null) {
            if (command == null) {
                command = new StringBuffer();
            }
            String trimmedLine = line.trim();
            if (trimmedLine.startsWith("--")) {
            } else if (trimmedLine.length() < 1
                    || trimmedLine.startsWith("//")) {
                // Do nothing
            } else if (trimmedLine.length() < 1
                    || trimmedLine.startsWith("--")) {
                // Do nothing
            } else if (!fullLineDelimiter
                    && trimmedLine.endsWith(getDelimiter())
                    || fullLineDelimiter
                    && trimmedLine.equals(getDelimiter())) {
                command.append(line.substring(0, line
                        .lastIndexOf(getDelimiter())));
                command.append(" ");

                String commandString = command.toString().trim();

                TableStructure table = TableStructure.parser(commandString);
                if (table != null) {
                    tableStructures.add(table);
                }

                command = null;
            } else {
                command.append(line);
                command.append(" ");
            }
        }
        return tableStructures;
    }

    private String getDelimiter() {
        return delimiter;
    }

}
