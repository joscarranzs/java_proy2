/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.validates;

import javax.swing.JCheckBox;
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
      JOptionPane.showMessageDialog(null, "Los valores no pueden estar vacios", "Error", JOptionPane.ERROR_MESSAGE);
      return true;
    }
    return false;
  }
  
  public static boolean validateVector(float[] mainVector){
      if (mainVector == null || mainVector.length == 0) {
        JOptionPane.showMessageDialog(
                null,
                "Debe ingresar los valores del vector primero.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
        return true;
    }
      return false;
  }
  
  
  public static boolean validateOptionSelection(JCheckBox sumPosVecElements, 
    JCheckBox sumNegVecElements, 
    JCheckBox sumPosVecWithNegVec, 
    JCheckBox sortPosVecAsc, 
    JCheckBox sortNegVecDesc){
      
            if (!sumPosVecElements.isSelected() && 
              !sumNegVecElements.isSelected() && 
              !sumPosVecWithNegVec.isSelected() && 
              !sortPosVecAsc.isSelected() && 
              !sortNegVecDesc.isSelected()) {

              // Mostrar mensaje de advertencia
              JOptionPane.showMessageDialog(
                  null, 
                  "Debe seleccionar al menos una opción para realizar las operaciones.", 
                  "Advertencia", 
                  JOptionPane.WARNING_MESSAGE
              );
              return  true;
          }


            return false;
  }
  
}
