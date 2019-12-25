package com.adero.yy.database.core.table;

import com.adero.yy.database.core.models.RowSet;

public class TableInfo {
    private RowInfo rowInfo;
    private RowSet tableData;

    public TableInfo(RowInfo rowInfo){
        this.rowInfo = rowInfo;
        this.tableData = new RowSet();
    }

    public boolean exsitCol(String colName){
        for(CellInfo cellInfo :rowInfo.getCellInfos()){
            if(colName.equals(cellInfo.getCellName())){
                return true;
            }
        }
        return false;
    }

    public RowInfo getRowInfo() {
        return rowInfo;
    }

    public void setRowInfo(RowInfo rowInfo) {
        this.rowInfo = rowInfo;
    }

    public RowSet getTableData() {
        return tableData;
    }

    public void setTableData(RowSet tableData) {
        this.tableData = tableData;
    }
}
