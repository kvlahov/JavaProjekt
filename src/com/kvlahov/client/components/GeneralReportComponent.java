/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kvlahov.client.components;

import com.kvlahov.client.global.Constants;
import com.kvlahov.client.tableModels.StatNewRecurringPatientsTableModel;
import com.kvlahov.client.tableModels.StatPatientsTreatedTableModel;
import com.kvlahov.model.report.GeneralReport;
import java.awt.BasicStroke;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.block.BlockBorder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author lordo
 */
public class GeneralReportComponent extends javax.swing.JPanel {

    private ActionListener btnSaveActionListener;
    private GeneralReport generalReport;

    public GeneralReportComponent(GeneralReport generalReport) {
        this.generalReport = generalReport;

        initComponents();
        initUI();
    }

    public ActionListener getBtnSaveActionListener() {
        return btnSaveActionListener;
    }

    public void setBtnSaveActionListener(ActionListener btnSaveActionListener) {
        this.btnSaveActionListener = btnSaveActionListener;
    }

    public GeneralReport getGeneralReport() {
        return generalReport;
    }

    public void setGeneralReport(GeneralReport generalReport) {
        this.generalReport = generalReport;
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

        mainPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        patientsTreatedPane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPatientsTreated = new javax.swing.JTable();
        chartPane = new javax.swing.JPanel();
        chartScrollPane = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnSave = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(339, 500));
        setLayout(new java.awt.BorderLayout());

        mainPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 50, 1, 50));
        mainPane.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setText("General Report");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weighty = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 15, 0);
        mainPane.add(jLabel1, gridBagConstraints);

        jLabel2.setText("Period:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 10);
        mainPane.add(jLabel2, gridBagConstraints);

        lblDate.setText("N/A");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        mainPane.add(lblDate, gridBagConstraints);

        patientsTreatedPane.setBorder(new javax.swing.border.MatteBorder(null));
        patientsTreatedPane.setLayout(new java.awt.BorderLayout());

        tblPatientsTreated.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblPatientsTreated.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tblPatientsTreated);

        patientsTreatedPane.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        mainPane.add(patientsTreatedPane, gridBagConstraints);

        chartPane.setBorder(new javax.swing.border.MatteBorder(null));
        chartPane.setLayout(new java.awt.BorderLayout());
        chartPane.add(chartScrollPane, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 3.0;
        gridBagConstraints.insets = new java.awt.Insets(15, 0, 0, 0);
        mainPane.add(chartPane, gridBagConstraints);

        jLabel5.setText("Average patients treated by doctors");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weighty = 0.5;
        mainPane.add(jLabel5, gridBagConstraints);

        jLabel7.setText("New and recurring patients");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LAST_LINE_START;
        gridBagConstraints.weighty = 0.3;
        mainPane.add(jLabel7, gridBagConstraints);

        add(mainPane, java.awt.BorderLayout.CENTER);

        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        jPanel2.add(btnSave);

        add(jPanel2, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (btnSaveActionListener != null) {
            btnSaveActionListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSave;
    private javax.swing.JPanel chartPane;
    private javax.swing.JScrollPane chartScrollPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JPanel mainPane;
    private javax.swing.JPanel patientsTreatedPane;
    private javax.swing.JTable tblPatientsTreated;
    // End of variables declaration//GEN-END:variables

    private void initUI() {
        initTblPatientsTreated();
//        initTblNewRecurringPatients();
        initLabels();
        initChart();
    }

    private void initLabels() {
        lblDate.setText(generalReport.getFormatedDate());

    }

    private void initTblPatientsTreated() {
        tblPatientsTreated.setModel(new StatPatientsTreatedTableModel(generalReport.getPatientsTreated()));
        tblPatientsTreated.setRowHeight(50);
    }

//    private void initTblNewRecurringPatients() {
//        tblNewRecurringPatients.setRowHeight(50);
//        tblNewRecurringPatients.setModel(new StatNewRecurringPatientsTableModel(generalReport.getNewReccuringPatients()));
//        tblNewRecurringPatients.setVisible(false);
//    }
    private void initChart() {
        XYDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);

        chartPanel.setMaximumDrawHeight(1000);
        chartPanel.setMaximumDrawWidth(2000);
        chartPanel.setMinimumDrawWidth(10);
//        chartPanel.setMinimumDrawHeight(10);

//        chartPane.add(chartPanel, BorderLayout.CENTER);
        chartScrollPane.setViewportView(chartPanel);
    }

    private XYDataset createDataset() {

        XYSeries series1 = new XYSeries("New");
        XYSeries series2 = new XYSeries("Recurring");

        generalReport.getNewReccuringPatients().forEach(o -> {
            series1.add(o.getDate().getDayOfMonth(), o.getNoNewPatients());
            series2.add(o.getDate().getDayOfMonth(), o.getNoRecurringPatients());
        });
//        series1.add(18, 530);
//        series1.add(20, 580);
//        series1.add(25, 740);
//        series1.add(30, 901);
//        series1.add(40, 1300);
//        series1.add(50, 2219);

//        series2.add(18, 567);
//        series2.add(20, 612);
//        series2.add(25, 800);
//        series2.add(30, 980);
//        series2.add(40, 1210);
//        series2.add(50, 2350);

        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);

        return dataset;
    }

    private JFreeChart createChart(final XYDataset dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart(
                "Number of new and recurring Patients",
                "Day",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        XYPlot plot = chart.getXYPlot();

        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();

        renderer.setSeriesPaint(0, Color.RED);
        renderer.setSeriesStroke(0, new BasicStroke(2.0f));

        renderer.setSeriesPaint(1, Color.BLUE);
        renderer.setSeriesStroke(1, new BasicStroke(2.0f));

        plot.setRenderer(renderer);
        plot.setBackgroundPaint(Color.white);

        plot.setRangeGridlinesVisible(false);
        plot.setDomainGridlinesVisible(false);

        chart.getLegend().setFrame(BlockBorder.NONE);

        chart.setTitle(new TextTitle("Number of new and recurring Patients",
                new Font("Serif", Font.BOLD, 18)
        )
        );

        return chart;
    }

}
