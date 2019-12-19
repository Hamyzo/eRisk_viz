/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriskgui;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author hamza
 */
public class BarFeatStat extends javax.swing.JFrame {
    
    public BarFeatStat(String Feature, String Class, ArrayList<Integer> values, ArrayList<Integer> values2) {
        super("Number of users on segments of " + Feature);
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if(Class.equals("Both"))
            Class = "Depressed";
        
        dataset.addValue(values.get(0), "Number of " + Class + " Subjects", "0 - 0.0005");
        dataset.addValue(values.get(1), "Number of " + Class + " Subjects", "0.0005 - 0.002");
        dataset.addValue(values.get(2), "Number of " + Class + " Subjects", "0.002 - 0.007");
        dataset.addValue(values.get(3), "Number of " + Class + " Subjects", "0.007 - 0.01");
        dataset.addValue(values.get(4), "Number of " + Class + " Subjects", "> 0.01");
        
        if(values2.size() > 0) {
            
            dataset.addValue(values2.get(0)/10, "Number of Not depressed Subjects", "0 - 0.0005");
            dataset.addValue(values2.get(1)/10, "Number of Not depressed Subjects", "0.0005 - 0.002");
            dataset.addValue(values2.get(2)/10, "Number of Not depressed Subjects", "0.002 - 0.007");
            dataset.addValue(values2.get(3)/10, "Number of Not depressed Subjects", "0.007 - 0.01");
            dataset.addValue(values2.get(4)/10, "Number of Not depressed Subjects", "> 0.01");
        }
        
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Bar Chart of " + Feature, 
                Feature, 
                "Number of subjects", 
                dataset, 
                PlotOrientation.VERTICAL, 
                true, 
                true, 
                false 
        );
        ChartPanel chartPanel = new ChartPanel(chart, false);
        chartPanel.setPreferredSize(new Dimension(1300, 600));
        setContentPane(chartPanel);
    }
}
