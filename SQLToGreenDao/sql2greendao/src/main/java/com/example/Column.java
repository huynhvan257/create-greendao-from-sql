package com.example;

/**
 * Created by van on 10/13/15.
 */
public class Column {
    private String columnName;
    private String dataType;
    private boolean PK;
    private boolean NN;
    private boolean UQ;
    private boolean BIN;
    private boolean UN;
    private boolean ZF;
    private boolean AI;

    public Column() {
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public boolean isPK() {
        return PK;
    }

    public void setPK(boolean PK) {
        this.PK = PK;
    }

    public boolean isNN() {
        return NN;
    }

    public void setNN(boolean NN) {
        this.NN = NN;
    }

    public boolean isUQ() {
        return UQ;
    }

    public void setUQ(boolean UQ) {
        this.UQ = UQ;
    }

    public boolean isBIN() {
        return BIN;
    }

    public void setBIN(boolean BIN) {
        this.BIN = BIN;
    }

    public boolean isUN() {
        return UN;
    }

    public void setUN(boolean UN) {
        this.UN = UN;
    }

    public boolean isZF() {
        return ZF;
    }

    public void setZF(boolean ZF) {
        this.ZF = ZF;
    }

    public boolean isAI() {
        return AI;
    }

    public void setAI(boolean AI) {
        this.AI = AI;
    }

    public void parser(String command){
        command.trim();
        String[] getTypes = command.split(" ");
        for (String getType : getTypes){
            if(!TextUtils.isEmpty( getType.trim())) {
                setDataType(getType);
                break;
            }
        }
        if(command.contains("AUTO_INCREMENT")){
            setAI(true);
        }
    }

    //



    //Byte, Short, Int, Long, Boolean, Float, Double, String, ByteArray, Date
    public String createNote(){
        String result = "";
        if(TextUtils.isEmpty(dataType.trim())){
            return result;
        }
        String type;
        switch (dataType.toUpperCase()){
            case "INT":
            case "INTEGER":
            case "TINYINT":
            case "SMALLINT":
            case "MEDIUMINT":
            case "BIGINT":
            case "UNSIGNED BIG INT":
            case "INT2":
            case "INT8":
                type = "Int";
                break;
            case "REAL":
            case "FLOAT":
                type = "Float";
                break;
            case "DOUBLE":
            case "DOUBLE PRECISION":
                type = "Double";
                break;
            case "DATETIME":
            case "TIMESTAMP":
            case "DATE":
            case "TIME":
                type = "Date";
                break;
            case "CHARACTER":
            case "VARCHAR":
            case "VARYING":
            case "NCHAR":
            case "NATIVE CHARACTER":
            case "NVARCHAR":
            case "TEXT":
            case "CLOB":
                type = "String";
                break;
            case "BLOB":
            case "LONGBLOB":
            case "MEDIUMBLOB":
            case "TINYBLOB":
                type = "Byte";
                break;
            case "BOOLEAN":
                type = "Boolean";
                break;
            default:
                type = "String";
                break;
        }
        if(!TextUtils.isEmpty(type)) {
            result += "add" + type + "Property(\"" + columnName + "\");";
        }
        return result;
    }
}
