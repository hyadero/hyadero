package com.adero.yy.database.core.engine;

import com.adero.yy.database.core.YYTables;
import com.adero.yy.database.core.models.Cell;
import com.adero.yy.database.core.table.CellInfo;
import com.adero.yy.database.core.table.RowInfo;
import com.adero.yy.database.core.table.TableInfo;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLCreateTableStatement;
import com.alibaba.fastjson.JSON;

import java.util.List;

public class CreateEngine implements DataBaseEngine {

    public static synchronized int createTable(String tableName, RowInfo rowInfo){
        if(YYTables.exsitTable(tableName)){
            return 0;
        }
        YYTables.createTable(tableName,rowInfo);
        return 1;
    }

    public void execute(SQLStatement sqlStatement) {
        SQLCreateTableStatement sqlCreateTableStatement = (SQLCreateTableStatement)sqlStatement;
        String tableName = sqlCreateTableStatement.getName().toString();
        RowInfo rowInfo = new RowInfo();
        sqlCreateTableStatement.forEachColumn(column -> {
            CellInfo cellInfo = new CellInfo();
            cellInfo.setCellName(column.getColumnName());
            cellInfo.setCellType(column.getDataType().getName());
            rowInfo.getCellInfos().add(cellInfo);
        });

        YYTables.createTable(tableName,rowInfo);
    }
}
