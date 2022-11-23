package org.example.creational.factory.easy;

//not included in book 4' Gang -> not

public abstract class EasyFactory {
    public static final int ORACLE = 0;
    public static final int MSSQL = 1;
    public static final int MYSQL = 2;

    public static Database createDatabase(int type){
        switch (type){
            case ORACLE:
                return new OracleDB();
            case MSSQL:
                return new MssqlDB();
            case MYSQL:
                return new MysqlDB();
        }
        return null;
    }
}
