package com.adero.yy.database.core;

import com.adero.yy.database.core.engine.*;
import com.alibaba.druid.sql.SQLUtils;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.druid.sql.ast.statement.SQLInsertStatement;
import com.alibaba.druid.sql.ast.statement.SQLSelectStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlExplainStatement;
import com.alibaba.fastjson.JSON;

public class YYDataBase {

    public static void executeSql(String sql){
        SQLStatement statement = SQLUtils.parseSingleMysqlStatement(sql);
        DataBaseEngine dataBaseEngine = null;
        if(statement instanceof SQLCreateTableStatement){
            dataBaseEngine = new CreateEngine();
        }
        else if(statement instanceof SQLSelectStatement){
            dataBaseEngine = new QueryEngine();
        }
        else if(statement instanceof SQLInsertStatement){
            dataBaseEngine = new InsertEngine();
        }
        else if(statement instanceof MySqlExplainStatement){
            dataBaseEngine = new InfoEngine();
        }
        dataBaseEngine.execute(statement);
    }
}
