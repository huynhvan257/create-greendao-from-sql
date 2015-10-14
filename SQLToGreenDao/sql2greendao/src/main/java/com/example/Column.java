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
    public String createNote(){
        String result = "";
        String type = "";
        switch (dataType.toLowerCase()){
            case "int":
                type = "Int";
                break;
            case "datetime":
            case "timestamp":
                type = "Date";
                break;
            case "varchar":
                type = "String";
                break;
        }
        if(!TextUtils.isEmpty(type)) {
            result += "add" + type + "Property(\"" + columnName + "\");";
        }
        return result;
    }
}
