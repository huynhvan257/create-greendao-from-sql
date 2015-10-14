package com.example;

public class SQL2GreenDao {

    public static void main(String[] args) throws Exception {

        ScriptReader scriptReader = new ScriptReader();
        String bodyFile = scriptReader.generationClass("../sql2greendao/res/files/Database.sql", "de.greenrobot.daoexample",
                "../app/src/main/java", "com.example", "GeneratorGreenDao", "../generatorgreendao/src/main/java/com/example/");
    }

}
