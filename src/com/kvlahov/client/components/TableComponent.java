/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.client.events.TableEvent;
import com.kvlahov.client.events.TableEventListener;
import com.kvlahov.client.tableModels.GenericTableModel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class TableComponent<T> extends javax.swing.JPanel {

//    private List<T> modelCollection;
    private TableEventListener<T> tableEventListener;
    private String searchExpression;
    private final GenericTableModel<T> tableModel;

    public TableComponent(GenericTableModel tableModel) {
//        this.modelCollection = modelCollection;
        this.tableModel = tableModel;

        initComponents();
        initTable();
    }

    public TableEventListener<T> getTableListener() {
        return tableEventListener;
    }

    public void setTableListener(TableEventListener<T> patientTableListenr) {
        this.tableEventListener = patientTableListenr;
    }
//
//    public List<T> getModelCollection() {
//        return modelCollection;
//    }
//
//    public void setModelCollection(List<T> modelCollection) {
//        this.modelCollection = modelCollection;
//        ((GenericTableModel<T>) mainTable.getModel()).updateModel(modelCollection);
//    }

    public String getSearchExpression() {
        return searchExpression;
    }
    
    public GenericTableModel<T> getTableModel() {
        return this.tableModel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        tfSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.GridBagLayout());

        tfSearch.setColumns(30);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.weightx = 1.2;
        jPanel2.add(tfSearch, gridBagConstraints);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(btnSearch, gridBagConstraints);

        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        jPanel2.add(btnClear, gridBagConstraints);

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 0.5;
        jPanel2.add(btnView, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.weightx = 0.6;
        jPanel2.add(filler2, gridBagConstraints);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        searchExpression = tfSearch.getText().trim();
        ((GenericTableModel) mainTable.getModel()).filterModelCollection();
        mainTable.repaint();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        tfSearch.setText("");
        btnSearchActionPerformed(evt);
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        fireModelSelectedEvent(evt.getSource());

    }//GEN-LAST:event_btnViewActionPerformed

    private void fireModelSelectedEvent(Object source) {
        T selectedModel = getSelectedModel(mainTable);
        if (selectedModel == null) {
            return;
        }
        if (tableEventListener != null) {
            tableEventListener.tableEventOccured(new TableEvent<>(source, selectedModel));
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnView;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfSearch;
    // End of variables declaration//GEN-END:variables
    private JTable mainTable;

    private void initTable() {
        mainTable = new JTable();
        mainTable.setModel(tableModel);

        mainTable.setAutoCreateRowSorter(true);
        mainTable.setDragEnabled(false);
        mainTable.setShowHorizontalLines(true);
        mainTable.setSelectionBackground(Color.DARK_GRAY);

        mainTable.setRowHeight(100);
        mainTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    fireModelSelectedEvent(e.getSource());
                }
            }
        });

        mainTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scroll = new JScrollPane(mainTable);

        add(scroll, BorderLayout.CENTER);

    }

    private T getSelectedModel(JTable target) {
        int selected = target.getSelectedRow();
        if (selected != -1) {
            int index = target.convertRowIndexToModel(selected);
            return getModelForRow(target, index);

        } else {
            JOptionPane.showMessageDialog(null, "No resource selected", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }

    private T getModelForRow(JTable target, int selectedRow) {
        return ((GenericTableModel<T>) target.getModel()).getModelForRow(selectedRow);
    }

}
