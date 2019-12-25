package com.adero.yy.database.core.table;


import java.util.ArrayList;
import java.util.List;

public class RowInfo {
    private List<CellInfo> cellInfos = new ArrayList<>();

    public List<CellInfo> getCellInfos() {
        return cellInfos;
    }

    public void setCellInfos(List<CellInfo> cellInfos) {
        this.cellInfos = cellInfos;
    }
}
