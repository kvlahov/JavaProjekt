/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.tableModels;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.swing.table.AbstractTableModel;

public abstract class GenericTableModel<T> extends AbstractTableModel {

    //https://tips4java.wordpress.com/2008/11/21/row-table-model/
    private List<T> modelCollection;
    private List<T> filteredCollection;
    private Predicate<T> filterPredicate;
    private Predicate<T> rowModelPredicate;

    private Object cellValue = new Object();
    private int modelIdColumn;

    private String[] columnNames = {};

    public GenericTableModel(List<T> modelCollection, int modelIdColumn) {
        this.modelCollection = modelCollection;
        this.filteredCollection = modelCollection;
        this.modelIdColumn = modelIdColumn;

        this.filterPredicate = (p) -> true;
        this.rowModelPredicate = (p) -> true;
    }

    protected void setColumnNames(String[] newColumnNames) {
        this.columnNames = newColumnNames;

        fireTableStructureChanged();
    }

    public Predicate<T> getFilterPredicate() {
        return filterPredicate;
    }

    public void setFilterPredicate(Predicate<T> filterPredicate) {
        this.filterPredicate = filterPredicate;
    }

    public Predicate<T> getRowModelPredicate() {
        return rowModelPredicate;
    }

    public void setRowModelPredicate(Predicate<T> rowModelPredicate) {
        this.rowModelPredicate = rowModelPredicate;
    }

    public Object getCellValue() {
        return cellValue;
    }

    @Override
    public int getRowCount() {
        return filteredCollection.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        T model = filteredCollection.get(rowIndex);

        return cellValueForColumnIndex(model, columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public T getModelForRow(int row) {
        cellValue = getValueAt(row, modelIdColumn);

        Optional<T> optionalModel = modelCollection.stream()
                .filter(rowModelPredicate)
                .findFirst();

        if (optionalModel.isPresent()) {
            return optionalModel.get();
        }
        return null;
    }

    public void updateModel(List<T> modelCollection) {
        this.modelCollection = modelCollection;
        filteredCollection = modelCollection;
        fireTableDataChanged();
    }

    public void filterModelCollection() {
        filteredCollection = modelCollection.stream()
                .filter(filterPredicate)
                .collect(Collectors.toList());

        fireTableDataChanged();

    }

    public abstract Object cellValueForColumnIndex(T model, int columnIndex);

}
