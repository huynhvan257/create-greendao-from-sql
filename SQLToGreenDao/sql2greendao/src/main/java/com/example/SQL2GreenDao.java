package com.example;

public class SQL2GreenDao {

    /**
     * Đường dẫn của file SQL
     */
    private static final String PATH_SQL  = "../sql2greendao/res/files/Database.sql";
    /**
     * Package name của source database sau khi generator từ greendao.
     */
    private static final String PACKAGE_NAME_DB  = "de.greenrobot.daoexample";
    /**
     * Folder chứa source database sau khi generator từ greendao.
     */
    private static final String FOLDER_SOURCE  = "../app/src/main/java";
    /**
     * Package name của class generator cho greendao.
     */
    private static final String PACKAGE_NAME_GENERATOR  = "com.example";
    /**
     * Tên class generator.
     */
    private static final String CLASS_NAME_GENERATOR  = "GeneratorGreenDao";
    /**
     * Folder chứa file generator.
     */
    private static final String FOLDER_FILE_GENERATOR  = "../generatorgreendao/src/main/java/";

    public static void main(String[] args) throws Exception {

        ScriptReader scriptReader = new ScriptReader();
        scriptReader.generationClass(PATH_SQL, PACKAGE_NAME_DB,
                FOLDER_SOURCE, PACKAGE_NAME_GENERATOR, CLASS_NAME_GENERATOR, FOLDER_FILE_GENERATOR);
    }

}
