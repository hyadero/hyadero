package com.adero.yy.database.core.models;

import java.util.ArrayList;
import java.util.List;

/**
 * data row
 */
public class Row {
    private List<Cell> cells = new ArrayList<Cell>();

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
