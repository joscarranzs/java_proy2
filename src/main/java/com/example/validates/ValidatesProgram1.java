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
public class ValidatesProgram1 {
    public static boolean validatePositive(int number){
        if(number <=0){
            JOptionPane.showMessageDialog(null, "Error. Ingrese valores positivos.", null, JOptionPane.ERROR_MESSAGE);
            return true;
        }
        return false;
     }
    
    public static boolean validateEmptyValues(String value){
        if(value.isEmpty()){
             JOptionPane.showMessageDialog(null, "Los valores no pueden estar vacios", null, JOptionPane.ERROR_MESSAGE);
             return true;
        }
        return false;
    }
}
