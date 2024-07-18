package Controlador;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.List;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.ResultSet;

import org.jfree.chart.plot.PlotOrientation;

import Modelo.Entidad.Contact;
import Vista.ChartView;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.plot.CategoryPlot;

public class ChartController {
    ContactController contactC;
    PhoneController phoneC;
    ChartView chartView;

    public ChartController() {
        this.contactC = new ContactController();
        this.phoneC = new PhoneController();
        this.chartView = new ChartView();
    }

    public void createChart(DefaultCategoryDataset dataSet, String chartTitle, String titleXAxis, String titleYAxis,
            int type) {
        JFreeChart chart;
        if (type == 0) {
            chart = ChartFactory.createBarChart3D(
                    chartTitle, // Nombre del grafico
                    titleXAxis, // Nombre de las barras (eje x)
                    titleYAxis, // Nombre de los valores (eje y)
                    dataSet, // Datos del grafico
                    PlotOrientation.VERTICAL, // Orientación
                    true, // Leyenda para los valores en barra (individuales)
                    false, // Herramientas
                    false // URL del gráfico
            );
        }
        else{
            chart = ChartFactory.createLineChart(
                    chartTitle, // Nombre del grafico
                    titleXAxis, // Nombre de las barras (eje x)
                    titleYAxis, // Nombre de los valores (eje y)
                    dataSet, // Datos del grafico
                    PlotOrientation.VERTICAL, // Orientación
                    true, // Leyenda para los valores en barra (individuales)
                    false, // Herramientas
                    false // URL del gráfico
            );
        }

        // Personaliza el eje X
        CategoryPlot plot = chart.getCategoryPlot();
        CategoryAxis domainAxis = plot.getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setPreferredSize(new Dimension(400, 200));

        // Asegúrate de que el panel se redimensiona correctamente
        chartPanel.setMaximumDrawWidth(Integer.MAX_VALUE);
        chartPanel.setMaximumDrawHeight(Integer.MAX_VALUE);

        chartView.getPanelCharts().removeAll();
        chartView.getPanelCharts().setLayout(new BorderLayout());
        chartView.getPanelCharts().add(chartPanel, BorderLayout.CENTER); // Añade al centro para ocupar todo el espacio
                                                                         // disponible
        chartView.getPanelCharts().revalidate();
        chartView.getPanelCharts().repaint();
        chartView.setVisible(true);
    }

    // Mostrar la cantidad de telefonos por cada usuario
    public void genGraph1() {
        try {
            List<Contact> contacts = contactC.getAllContacts();
            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

            for (Contact c : contacts) {
                dataSet.setValue(c.phones.size(), "telefonos", c.name);
            }

            createChart(dataSet, "Cantidad de telefonos por cada usuario", "Contactos", "Cantidad de numeros", 0);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error al cargar la foto de perfil " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void genGraph2() {
        try {
            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

            ResultSet rs = phoneC.phonesByCategory();
            while (rs.next()) {
                dataSet.setValue(
                        rs.getLong(1),
                        "Categorias",
                        rs.getString(2));
            }

            createChart(dataSet, "Teléfonos por categoría", "Categoria", "Cantidad", 0);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error al cargar la foto de perfil " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    public void genGraph3() {
        try {
            List<Contact> contacts = contactC.getAllContacts();
            DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

            for (Contact c : contacts) {
                dataSet.setValue(c.phones.size(), "telefonos", c.name);
            }

            createChart(dataSet, "Cantidad de telefonos por cada usuario", "Contactos", "Cantidad de numeros", 1);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null,
                    "Error al cargar la foto de perfil " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
