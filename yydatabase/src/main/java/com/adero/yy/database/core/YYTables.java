package com.adero.yy.database.core;

import com.adero.yy.database.core.table.RowInfo;
import com.adero.yy.database.core.table.TableInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class YYTables {

    private static Map<String, TableInfo> yyTables = new ConcurrentHashMap<String, TableInfo>();

    public static synchronized void createTable(String tableName, RowInfo rowInfo){
        TableInfo tableInfo = new TableInfo(rowInfo);
        yyTables.put(tableName,tableInfo);
    }

    public  static boolean exsitTable(String tableName){
        if(yyTables.get(tableName)!=null){
            return true;
        }
        return false;
    }

    public static Map<String, TableInfo> getYyTables() {
        return yyTables;
    }
}
