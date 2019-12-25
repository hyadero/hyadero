package com.adero.yy.database;

import com.adero.yy.database.core.YYDataBase;
import com.adero.yy.database.core.engine.DataBaseEngine;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.util.JdbcConstants;
import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            try {
                String sql = stdin.readLine();
                System.out.println("sql:"+sql);
                YYDataBase.executeSql(sql);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
