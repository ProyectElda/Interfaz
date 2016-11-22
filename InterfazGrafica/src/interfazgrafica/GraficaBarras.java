/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfazgrafica;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class GraficaBarras extends JFrame{
    JPanel panel;
    public GraficaBarras(){
        setTitle("Grafica de Rutas");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        init();
    }

    private void init() {
        panel = new JPanel();
        getContentPane().add(panel);
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(1.5 , "Ruta A", "A");
        dataset.setValue(1.3 , "Ruta B", "N");
        dataset.setValue(1   , "Ruta C", "C");
        dataset.setValue(1.6 , "Ruta D", "D");
        dataset.setValue(1.9 , "Ruta E", "E");
        dataset.setValue(2   , "Ruta F", "F");
        dataset.setValue(1.2 , "Ruya G", "G");
        dataset.setValue(1.5 , "Ruta H", "H");
        dataset.setValue(1.45, "Ruta I", "I");
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D("Tiempo en ruta por unidad","Unidades", "Tiempo (Hrs)", dataset, PlotOrientation.VERTICAL, true,true, false);
        chart.setBackgroundPaint(Color.getColor("#040D68"));
        chart.getTitle().setPaint(Color.white); 
        CategoryPlot p = chart.getCategoryPlot(); 
        p.setRangeGridlinePaint(Color.red); 
        // Mostrar Grafico
        ChartPanel chartPanel = new ChartPanel(chart);
        panel.add(chartPanel);
    }
}