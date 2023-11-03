/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ackermann;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author auror
 */



class Nodo {
    int valor;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int valor) {
        this.valor = valor;
        this.izquierdo = null;
        this.derecho = null;
    }
}

class ArbolBinario {
    Nodo raiz;
    ArrayList<Nodo> nodos = new ArrayList<>();

    public void agregarNodo(int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        nodos.add(nuevoNodo);
        if (raiz == null) {
            raiz = nuevoNodo;
        }
    }

    public String obtenerDiagrama() {
        StringBuilder diagrama = new StringBuilder();
        for (Nodo nodo : nodos) {
            diagrama.append("Nodo ").append(nodo.valor).append(": ");
            if (nodo.izquierdo != null) {
                diagrama.append("Izquierdo: ").append(nodo.izquierdo.valor).append(", ");
            }
            if (nodo.derecho != null) {
                diagrama.append("Derecho: ").append(nodo.derecho.valor);
            }
            diagrama.append("\n");
        }
        return diagrama.toString();
    }
}

public class App {
    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

        while (true) {
            String valorStr = JOptionPane.showInputDialog("Ingrese un valor/salir: ");

            if (valorStr == null || valorStr.equalsIgnoreCase("salir")) {
                break;
            }

            try {
                int valor = Integer.parseInt(valorStr);
                arbol.agregarNodo(valor);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada no válida. Introduzca un número válido.");
            }
        }

        String diagrama = arbol.obtenerDiagrama();
        JOptionPane.showMessageDialog(null, "Diagrama del árbol binario:" + diagrama);
    }
}