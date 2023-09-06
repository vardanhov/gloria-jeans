package ru.gloria_jeans.ui.server.model.table;

import ru.gloria_jeans.ui.server.jetpackcompose.modifier.Color;

import java.util.List;
public class Row {

    private Color rowTextColor;

    private Color rowBackgroundColor;

    private List<Cell> cells;

    public Row() {
    }

    public Row(List<Cell> cells) {
        this.cells = cells;
    }

    public Color getRowTextColor() {
        return rowTextColor;
    }

    public void setRowTextColor(Color rowTextColor) {
        this.rowTextColor = rowTextColor;
    }

    public Color getRowBackgroundColor() {
        return rowBackgroundColor;
    }

    public void setRowBackgroundColor(Color rowBackgroundColor) {
        this.rowBackgroundColor = rowBackgroundColor;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public void setCells(List<Cell> cells) {
        this.cells = cells;
    }
}
