/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eriskgui;

import java.awt.Color;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
/**
 *
 * @author hamza
 */
public class LineFeatFeat extends javax.swing.JFrame {

    
    public LineFeatFeat(ArrayList<String> Features, ArrayList<Integer> valuesFeat1, ArrayList<Integer> valuesFeat2) {

        super("Correlation of " + Features);

        final XYDataset dataset = createDataset(Features, valuesFeat1, valuesFeat2);
        final JFreeChart chart = createChart(dataset, Features);
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1300, 600));
        setContentPane(chartPanel);

    }
    
   
    private XYDataset createDataset(ArrayList<String> Features, ArrayList<Integer> valuesFeat1, ArrayList<Integer> valuesFeat2) {
        
        final XYSeries series1 = new XYSeries(Features.get(0) + " - " + Features.get(1));
        for(int i = 0; i < 10; i++)
            series1.add(valuesFeat1.get(i), valuesFeat2.get(i));

        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
                
        return dataset;
        
    }
    
    
    private JFreeChart createChart(final XYDataset dataset, final ArrayList<String> Features) {
        
        
        final JFreeChart chart = ChartFactory.createXYLineChart(
            "Correlation of total of subjects by " + Features,
            Features.get(0),                      
            Features.get(1),                     
            dataset,                  
            PlotOrientation.VERTICAL,
            true,                     
            true,                     
            false                     
        );
        return chart;
    }
}