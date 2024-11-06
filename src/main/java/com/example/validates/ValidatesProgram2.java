/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.validates;

import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class ValidatesProgram2 {
    
    public static boolean validateEmptyValues(String strSellers, String strMonths){
        if (strSellers.isEmpty() || strMonths.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Por favor, ingresa valores en ambos campos.");
        return true;
    } 
        return false;
    }
    
    public static boolean validatePositive(int NumbSellers, int NumbMonths){
        if(NumbSellers <=0 || NumbMonths<=0){
            JOptionPane.showMessageDialog(null, "Error. Ingrese valores positivos.", null, JOptionPane.ERROR_MESSAGE);
            return true;
        }
        
        
        return false;
    }
    
    public static boolean validateNullSales(float[][] sales) {
        if (sales == null) {
            JOptionPane.showMessageDialog(null, "Primero ingresa los datos de ventas.");
            return true;
        }
        return false;
    }
}
