/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.calculations;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Alberto
 */
public class CalculationsProgram1 {
  private float[] mainVector; 
  //Método para llenar de valores el vector
  public void fillVector(int numbValue){
    float[] vector = new float[numbValue];
    // Llenar el vector con valores ingresados por el usuario usando JOptionPane
    for (int i = 0; i < numbValue; i++) {
      String input = JOptionPane.showInputDialog(
        null,
        "Ingrese el valor para la posición " + i + ":",
        "Ingreso de valores",
        JOptionPane.PLAIN_MESSAGE
      );
      try {
        vector[i] = Float.parseFloat(input);
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(
          null,
          "Entrada no válida. Por favor ingrese un número.",
          "Error",
          JOptionPane.ERROR_MESSAGE
        );
        i--; // volver a solicitar el valor para esta posición
      }
    }

    this.mainVector = vector;
  }

  public void operationsOptions(JCheckBox sumPosVecElements, 
    JCheckBox sumNegVecElements, 
    JCheckBox sumPosVecWithNegVec, 
    JCheckBox sortPosVecAsc, 
    JCheckBox sortNegVecDesc){
    StringBuilder result = new StringBuilder("Resultados de Operaciones Seleccionadas:\n");
    DecimalFormat df = new DecimalFormat("#.##");

    // Variables para las operaciones
    float positiveSum = 0;
    float negativeSum = 0;
    ArrayList<Float> posVector = new ArrayList<>();
    ArrayList<Float> negVector = new ArrayList<>();

    // Recorrer el vector y realizar las operaciones
    for (int i = 0; i < mainVector.length; i++) {
      float value = mainVector[i];

      // Separar en vectores positivos y negativos
      if (value > 0) {
        posVector.add(value);
        positiveSum += value; // Suma de elementos positivos
      } else if (value < 0) {
        negVector.add(value);
        negativeSum += value; // Suma de elementos negativos
      }
    }
    // Suma de vectores positivo y negativo (si tienen el mismo tamaño)
    if (sumPosVecWithNegVec.isSelected()) {
      if (posVector.size() == negVector.size()) {
        float totalSum = 0;
        for (int i = 0; i < posVector.size(); i++) {
          totalSum += posVector.get(i) + negVector.get(i);
        }
        result.append("Suma de VecPos y VecNeg: ").append(df.format(totalSum)).append("\n");
      } else {
        result.append("Suma de VecPos y VecNeg: Imposible, no tienen igual tamaño.\n");
      }
    }

    // Suma de elementos positivos
    if (sumPosVecElements.isSelected()) {
      result.append("Suma de Elementos Positivos: ").append(df.format(positiveSum)).append("\n");
    }

    // Suma de elementos negativos
    if (sumNegVecElements.isSelected()) {
      result.append("Suma de Elementos Negativos: ").append(df.format(negativeSum)).append("\n");
    }



    // Ordenar vector positivo en orden ascendente
    if (sortPosVecAsc.isSelected()) {
      Collections.sort(posVector);

      // Convertir a enteros y mostrar
      StringBuilder posVectorAsInt = new StringBuilder("VecPos Ordenado Ascendentemente: [");
      for (int i = 0; i < posVector.size(); i++) {
        posVectorAsInt.append((int) Math.floor(posVector.get(i))); // Convierte cada elemento a int
        if (i < posVector.size() - 1) {
          posVectorAsInt.append(", ");
        }
      }
      posVectorAsInt.append("]\n");
      result.append(posVectorAsInt);
    }

    // Ordenar vector negativo en orden descendente
    if (sortNegVecDesc.isSelected()) {
      Collections.sort(negVector, Collections.reverseOrder());

      // Convertir a enteros y mostrar
      StringBuilder negVectorAsInt = new StringBuilder("VecNeg Ordenado Descendentemente: [");
      for (int i = 0; i < negVector.size(); i++) {
        negVectorAsInt.append((int) Math.floor(negVector.get(i))); // Convierte cada elemento a int
        if (i < negVector.size() - 1) {
          negVectorAsInt.append(", ");
        }
      }
      negVectorAsInt.append("]\n");
      result.append(negVectorAsInt);
    }
    // Mostrar todos los resultados 
    JOptionPane.showMessageDialog(
      null,
      result.toString(),
      "Resultados",
      JOptionPane.INFORMATION_MESSAGE
    );
  }

  // Método getter para obtener el vector principal y acceder a los valores ingresados por el usuario   
  public float[] getMainVector() {
    return mainVector;
  }

  //Método para reiniciar el vector principal, se usa para resetear los valores ingresados
  public void resetVector() {
    mainVector = null;
  }



}
