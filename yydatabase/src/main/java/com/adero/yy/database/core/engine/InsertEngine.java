package com.adero.yy.database.core.engine;

import com.adero.yy.database.core.YYTables;
import com.adero.yy.database.core.models.Cell;
import com.adero.yy.database.core.models.Row;
import com.adero.yy.database.core.table.TableInfo;
import com.alibaba.druid.sql.ast.SQLExpr;
import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.ast.statement.SQLInsertStatement;
import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlInsertStatement;

public class InsertEngine implements DataBaseEngine {

    public static void insert(String tableName, Row row){

    }

    public void execute(SQLStatement sqlStatement) {
        MySqlInsertStatement sqlInsertStatement = (MySqlInsertStatement)sqlStatement;
        String tableName = sqlInsertStatement.getTableName().toString();

        TableInfo tableInfo = YYTables.getYyTables().get(tableName);
        if(tableInfo==null){
            throw new RuntimeException(tableName+" not exsit");
        }

        Row row = new Row();
        for(int i=0;i<sqlInsertStatement.getColumns().size();i++){
            Cell cell = new Cell();
            String colName = sqlInsertStatement.getColumns().get(i).toString();
            //check col name
            if(tableInfo.exsitCol(colName)){
                cell.setColName(colName);
            }else{
                throw new RuntimeException(colName + " not exsit");
            }

            String colVal = sqlInsertStatement.getValuesList().get(i).getValues().get(0).toString();
            cell.setColVal(colVal);
            cell.setColSize(colVal.length());
            row.getCells().add(cell);
        }

        tableInfo.getTableData().getRows().add(row);
    }
}
