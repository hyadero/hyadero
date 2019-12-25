package com.adero.yy.database.core.engine;

import com.adero.yy.database.core.YYTables;
import com.adero.yy.database.core.table.RowInfo;
import com.adero.yy.database.core.table.TableInfo;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlExplainStatement;
import com.alibaba.fastjson.JSON;

public class InfoEngine implements DataBaseEngine{

    @Override
    public void execute(SQLStatement sqlStatement) {
        MySqlExplainStatement mySqlExplainStatement = (MySqlExplainStatement)sqlStatement;
        String tableName = mySqlExplainStatement.getTableName().toString();
        TableInfo tableInfo = YYTables.getYyTables().get(tableName);
        if(tableInfo!=null){
            RowInfo rowInfo = tableInfo.getRowInfo();
            System.out.println(JSON.toJSONString(rowInfo));
        }else{
            System.out.println(tableName+" not exsit");
        }
    }
}
