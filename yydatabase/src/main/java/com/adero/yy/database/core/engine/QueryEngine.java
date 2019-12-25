package com.adero.yy.database.core.engine;

import com.adero.yy.database.core.YYTables;
import com.adero.yy.database.core.table.TableInfo;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectQuery;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.clause.MySqlSelectIntoStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlSelectQueryBlock;
import com.alibaba.fastjson.JSON;

public class QueryEngine implements DataBaseEngine {

    public void execute(SQLStatement sqlStatement) {
        SQLSelectStatement sqlSelectStatement = (SQLSelectStatement) sqlStatement;
        SQLSelectQuery sqlSelectQuery = sqlSelectStatement.getSelect().getQuery();
        if(sqlSelectQuery instanceof MySqlSelectQueryBlock){
            MySqlSelectQueryBlock mySqlSelectQueryBlock = (MySqlSelectQueryBlock)sqlSelectQuery;
            String tableName = mySqlSelectQueryBlock.getFrom().toString();
            TableInfo tableInfo = YYTables.getYyTables().get(tableName);
            if(tableInfo==null){
                throw new RuntimeException(tableInfo + "not exsit");
            }
            System.out.println(JSON.toJSONString(tableInfo.getTableData()));
        }else{
            throw new RuntimeException("sql error");
        }
    }
}
