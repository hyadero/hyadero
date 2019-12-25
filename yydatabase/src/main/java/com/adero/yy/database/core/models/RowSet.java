package com.adero.yy.database.core.models;

import java.util.ArrayList;
import java.util.List;

public class RowSet {
    private List<Row> rows = new ArrayList<Row>();

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }
}
