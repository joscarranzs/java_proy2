/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.calculations;

import com.example.validates.ValidatesProgram2;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Alberto
 */
public class CalculationsProgram2 {
    
    private float[][] sales; // Declaración de la matriz de ventas a nivel de clase para usarse en otros metodos
    DecimalFormat df = new DecimalFormat("#.##"); //Dec
    
    public boolean fillMatrix(int numberOfSellers, int numberOfMonths) {
        // Inicializar la matriz con las dimensiones proporcionadas
        sales = new float[numberOfSellers][numberOfMonths];

        // Llenar la matriz con los valores ingresados por el usuario
        for (int i = 0; i < numberOfSellers; i++) {
            for (int j = 0; j < numberOfMonths; j++) {
                String input = JOptionPane.showInputDialog(null, 
                    "Ingrese la venta para el vendedor " + (i + 1) + ", mes " + (j + 1), 
                    "Entrada de ventas", JOptionPane.QUESTION_MESSAGE);
                
                   // Si el usuario cancela, mostrar mensaje y salir del método
                    if (input == null) {
                        JOptionPane.showMessageDialog(
                            null,
                            "Entrada de datos cancelada.",
                            "Cancelado",
                            JOptionPane.WARNING_MESSAGE
                        );
                        return false; // Devuelve false para indicar que no se completó el llenado
                    }
                
                try {
                    // Parsear el valor ingresado a entero y asignarlo a la matriz
                    sales[i][j] = Float.parseFloat(input);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, 
                        "Error, ingrese un número válido.", 
                        "Error", JOptionPane.ERROR_MESSAGE);
                    j--; // Reintentar el mismo mes si el valor ingresado no es válido
                }
            }
        }
        return true; // Devuelve true solo si se completó exitosamente
    }

    
 private void showVector(float[] vector, String title) {
        // Crear el encabezado de columna para el vector
        String[] columnNames = {title};
        
        // Crear los datos de la tabla usando el vector
        Object[][] tableData = new Object[vector.length][1];
        for (int i = 0; i < vector.length; i++) {
            tableData[i][0] = df.format(vector[i]); // Formateo con DecimalFormat a dos decimales
        }
        
        // Crear el JTable y mostrarlo en un JScrollPane
        JTable table = new JTable(tableData, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        
        // Mostrar el JTable en un JOptionPane
        JOptionPane.showMessageDialog(null, scrollPane, title, JOptionPane.INFORMATION_MESSAGE);
    }    
    
public void showSalesMatrix() {
    // Verifica si la matriz de ventas (sales) es null usando el método de validación; si es null, sale del método
    if (ValidatesProgram2.validateNullSales(sales)) return;

    // Crear encabezados para las columnas, incluyendo una columna adicional para el "Vendedor"
    String[] columnNames = new String[sales[0].length + 1];
    columnNames[0] = "Vendedor"; // Etiqueta para la columna del vendedor
    for (int j = 0; j < sales[0].length; j++) {
        columnNames[j + 1] = "Mes " + (j + 1); // Etiquetas para cada columna de mes
    }

    // Crear los datos de la tabla incluyendo los nombres de los vendedores en la primera columna
    Object[][] tableData = new Object[sales.length][sales[0].length + 1];
    for (int i = 0; i < sales.length; i++) {
        tableData[i][0] = "Vendedor " + (i + 1); // Nombre del vendedor
        for (int j = 0; j < sales[i].length; j++) {
            tableData[i][j + 1] = sales[i][j]; // Asigna cada venta en su posición correspondiente
        }
    }

    // Crear y configurar el JTable para mostrar la matriz
    JTable table = new JTable(tableData, columnNames);
    table.getColumnModel().getColumn(0).setPreferredWidth(100); // Ajustar el ancho de la columna "Vendedor"
    JScrollPane scrollPane = new JScrollPane(table);

    // Mostrar el JTable en un JOptionPane
    JOptionPane.showMessageDialog(null, scrollPane, "Ventas en Formato Tabular", JOptionPane.INFORMATION_MESSAGE);
}

public void showSalesPerSeller() {
    // Verifica si la matriz de ventas es null; si es null, sale del método
    if (ValidatesProgram2.validateNullSales(sales)) return;

    // Crear un vector para almacenar la suma de ventas por vendedor
    float[] salesPerSeller = new float[sales.length];
    for (int i = 0; i < sales.length; i++) {
        for (int j = 0; j < sales[i].length; j++) {
            salesPerSeller[i] += sales[i][j]; // Suma las ventas del vendedor i
        }
    }

    // Llamar al método para mostrar el vector con el título adecuado
    showVector(salesPerSeller, "Ventas por Vendedor");
}

public void showAvgPerSeller() {
    // Verifica si la matriz de ventas es null; si es null, sale del método
    if (ValidatesProgram2.validateNullSales(sales)) return;

    // Crear un vector para almacenar el promedio de ventas por vendedor
    float[] avgPerSeller = new float[sales.length];
    for (int i = 0; i < sales.length; i++) {
        float sum = 0;
        for (int j = 0; j < sales[i].length; j++) {
            sum += sales[i][j]; // Suma las ventas del vendedor i
        }
        avgPerSeller[i] = sum / sales[i].length; // Calcula el promedio dividiendo por la cantidad de meses
    }

    // Llamar al método para mostrar el vector con el título adecuado
    showVector(avgPerSeller, "Promedio de Ventas por Vendedor");
}

public void showSalesPerMonth() {
    // Verifica si la matriz de ventas es null; si es null, sale del método
    if (ValidatesProgram2.validateNullSales(sales)) return;

    // Crear un vector para almacenar la suma de ventas por mes
    float[] salesPerMonth = new float[sales[0].length];
    for (int j = 0; j < sales[0].length; j++) {
        for (int i = 0; i < sales.length; i++) {
            salesPerMonth[j] += sales[i][j]; // Suma las ventas del mes j
        }
    }

    // Llamar al método para mostrar el vector con el título adecuado
    showVector(salesPerMonth, "Ventas por Mes");
}

public void showAvgPerMonth() {
    // Verifica si la matriz de ventas es null; si es null, sale del método
    if (ValidatesProgram2.validateNullSales(sales)) return;

    // Crear un vector para almacenar el promedio de ventas por mes
    float[] avgPerMonth = new float[sales[0].length];
    for (int j = 0; j < sales[0].length; j++) {
        float sum = 0;
        for (int i = 0; i < sales.length; i++) {
            sum += sales[i][j]; // Suma las ventas del mes j
        }
        avgPerMonth[j] = sum / sales.length; // Calcula el promedio dividiendo por la cantidad de vendedores
    }

    // Llamar al método para mostrar el vector con el título adecuado
    showVector(avgPerMonth, "Promedio de Ventas por Mes");
}

public void totalizeSales() {
    // Verifica si la matriz de ventas es null; si es null, sale del método
    if (ValidatesProgram2.validateNullSales(sales)) return;

    // Sumar todas las ventas de la matriz
    float total = 0;
    for (int i = 0; i < sales.length; i++) {
        for (int j = 0; j < sales[i].length; j++) {
            total += sales[i][j]; // Suma cada venta al total
        }
    }

    // Mostrar el total de ventas 
    JOptionPane.showMessageDialog(null, "Total de Ventas del Negocio: " + df.format(total));
}


    
    
}
