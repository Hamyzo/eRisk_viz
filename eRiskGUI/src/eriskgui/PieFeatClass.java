/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriskgui;


import java.awt.Color;
import java.awt.Dimension;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author JENNIFER
 */
public class PieFeatClass extends javax.swing.JFrame {

    /**
     * Creates a new demo instance.
     *
     * @param title the frame title.
     */
    public PieFeatClass(String Feature, double vp, double vn) {
        super("Average of " + Feature + " for depressed and non depressed people");
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Depressed", (vp/(vp+vn))*100.0);
        dataset.setValue("Not depressed", (vn/(vp+vn))*100.0);
        JFreeChart chart = ChartFactory.createPieChart(
            "Average of " + Feature + " for depressed and non depressed people",
                dataset,
                true, 
                true, 
                false 
        );
        PiePlot pieplot = (PiePlot) chart.getPlot();
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0} ({2} percent)"));
    pieplot.setLabelBackgroundPaint(new Color(220, 220, 220));
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(1300, 600));
        setContentPane(chartPanel);
        
    }
}
